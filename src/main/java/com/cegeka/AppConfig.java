package com.cegeka;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.channel.MessageChannels;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.messaging.MessageChannel;

@Configuration
@IntegrationComponentScan
public class AppConfig {
    @Bean
    public MessageChannel requests() {
        return MessageChannels.direct().get();
    }
    
    @Bean
    public ConnectionFactory connectionFactory() {
        return (ConnectionFactory) new CachingConnectionFactory(
                new ActiveMQConnectionFactory("vm://localhost?broker.persistent=false"));
    }
    
    @Bean
    public IntegrationFlow simpleToUpperCaseFlow() {
        return IntegrationFlows.from(requests()).transform((String s) -> s.toUpperCase()).get();
    }
}
