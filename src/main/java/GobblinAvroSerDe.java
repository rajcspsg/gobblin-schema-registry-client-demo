import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.io.JsonEncoder;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.avro.specific.SpecificRecordBase;
import org.apache.commons.lang.SerializationException;
import org.apache.gobblin.kafka.serialize.LiAvroSerializer;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

public class GobblinAvroSerDe<T extends SpecificRecordBase> implements CustomSerDeOps<GenericRecord> {

    private LiAvroSerializer encoder;

    private String topic;

    private Properties props;

    public GobblinAvroSerDe(Properties props, String topic) {
        encoder = new LiAvroSerializer();
        Map<String, String> config = props.entrySet().stream().collect(Collectors.toMap(x -> x.getKey().toString(), x -> x.getValue().toString()));
        encoder.configure(config, false);

        this.props = props;
        this.topic = topic;
    }

    @Override
    public byte[] serialize(GenericRecord genericRecord) throws SerializationException {
        return encoder.serialize(this.topic, genericRecord);
    }

    @Override
    public GenericRecord deserialize(byte[] bytes) throws SerializationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public String serializeToString(GenericRecord genericRecord) throws SerializationException {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            JsonEncoder jsonEncoder = EncoderFactory.get().jsonEncoder(genericRecord.getSchema(), out, true);
            SpecificDatumWriter<T> writer = new SpecificDatumWriter<>(genericRecord.getSchema());
            ((DatumWriter)writer).write(genericRecord, jsonEncoder);
            jsonEncoder.flush();
            return out.toString();
        } catch (IOException e) {
            throw new SerializationException(e.getMessage(), e);
        }
    }

    @Override
    public GenericRecord deserialize(String data) throws SerializationException {
        throw new UnsupportedOperationException();
    }
}

