package com.cegeka;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.messaging.MessageChannel;

@Configuration
@IntegrationComponentScan
public class AppConfig {
    @Bean
    public MessageChannel requests() {
        return new DirectChannel();
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        return (ConnectionFactory) new CachingConnectionFactory(
                new ActiveMQConnectionFactory("vm://localhost?broker.persistent=false"));
    }
}
