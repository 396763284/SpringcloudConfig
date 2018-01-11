package per.wxp.elasticsearchDemo.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

//@Configuration
public class MyConfig {


    @Value("${elasticsearch.cluster.name}")
    private String clusterName;

    @Value("${elasticsearch.host}")
    private String host;

    public MyConfig() {
    }


    @Bean
    public  TransportClient client() throws UnknownHostException {

        InetSocketTransportAddress node= new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"),9200);


        Settings settings=Settings.builder()
                            .put("cluster.name",clusterName)
                            .build();

        TransportClient client= new PreBuiltTransportClient(settings) ;

        client.addTransportAddress(node);


        return client;
    }
}
