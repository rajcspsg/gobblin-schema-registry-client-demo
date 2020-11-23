import com.synacor.network.ClientIdentifier;

import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("kafka.schemaRegistry.class", "org.apache.gobblin.kafka.schemareg.LiKafkaSchemaRegistry");
        props.put("kafka.schemaRegistry.url", "http://localhost:8081");

        try {
            GobblinAvroSerDe serDe = new GobblinAvroSerDe(props, "ImpressionAvroStream");
            System.out.println("Successfully created serde: " + serDe.toString());
            ClientIdentifier clientIdentifier = new ClientIdentifier("www.about.com", "172.76.25.2");
            byte[] serializedBytes = serDe.serialize(clientIdentifier);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
