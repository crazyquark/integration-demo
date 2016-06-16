package com.cegeka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class IntegrationDemoApplication {

	public static void main(String[] args) {
	    ConfigurableApplicationContext ctx = new SpringApplication(IntegrationDemoApplication.class).run();
	    ClientGateway gateway = ctx.getBean(ClientGateway.class);
	    
	    System.out.println(gateway.echo("testing..."));
	    
	    ctx.close();
	}
}
