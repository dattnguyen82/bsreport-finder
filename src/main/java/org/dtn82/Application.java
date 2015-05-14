package org.dtn82;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class Application  {

    @Autowired
    BSRInformationRepository bsrInformationRepository;

    public static void main(String[] args) {

        String webPort = System.getenv("PORT");
        if (webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }

        System.setProperty("server.port", webPort);

        ApplicationContext ctx = SpringApplication.run(Application.class, args);
    }
}
