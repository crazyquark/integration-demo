package com.cegeka;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;


@MessagingGateway
public interface ClientGateway {
    @Gateway(requestChannel = "requests")
    String sendAndReceive(String message);
}
