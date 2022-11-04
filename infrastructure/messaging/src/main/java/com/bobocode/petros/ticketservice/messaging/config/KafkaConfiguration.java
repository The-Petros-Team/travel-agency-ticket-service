package com.bobocode.petros.ticketservice.messaging.config;

import com.bobocode.petros.ticketservice.adapter.MessageConsumerAdapter;
import com.bobocode.petros.ticketservice.adapter.MessageProducerAdapter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;

import java.util.HashMap;

@EnableKafka
@Configuration
public class KafkaConfiguration {
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        var configs = new HashMap<String, Object>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, this.bootstrapAddress);
        return new KafkaAdmin(configs);
    }

    @Bean
    public ObjectMapper objectMapper() {
        final var objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }

    @Bean
    public StringJsonMessageConverter stringJsonMessageConverter() {
        return new StringJsonMessageConverter();
    }

    @Bean
    public NewTopic ticketRequestsTopic() {
        return new NewTopic(MessageConsumerAdapter.TICKET_REQUEST_TOPIC_NAME, 1, (short) 1);
    }

    @Bean
    public NewTopic ticketResponsesTopic() {
        return new NewTopic(MessageProducerAdapter.TICKET_RESPONSE_TOPIC_NAME, 1, (short) 1);
    }
}
