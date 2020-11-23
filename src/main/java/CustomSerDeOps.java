import org.apache.commons.lang.SerializationException;

public interface CustomSerDeOps<T> {

    byte[] serialize(T t) throws SerializationException;

    T deserialize(byte[] bytes) throws SerializationException;

    String serializeToString(T t) throws SerializationException;
    T deserialize(String data) throws SerializationException;
}
