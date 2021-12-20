package com.example.springbootdemo.config;

public class ESRestClientConfig {

}
//@Configuration
//public class ESRestClientConfig extends AbstractElasticsearchConfiguration {
//    @Override
//    @Bean
//    public RestHighLevelClient elasticsearchClient() {
//        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
//                .connectedTo("localhost:9200")
//                .build();
//        return RestClients.create(clientConfiguration).rest();
//    }
//}