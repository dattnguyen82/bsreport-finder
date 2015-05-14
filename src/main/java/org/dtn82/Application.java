package org.dtn82;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;


@SpringBootApplication
public class Application implements CommandLineRunner {

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

    @Override
    public void run(String... args) throws Exception
    {

        // fetch all customers
        System.out.println("FindAll():");
        System.out.println("-------------------------------");
        List<BSRInformation> list =  bsrInformationRepository.findAll();

        System.out.println("Count: " + list.size());

        for (BSRInformation info : list) {
            System.out.println(info.toJson());
        }
        System.out.println();

        // fetch an individual customer
//        System.out.println("Customer found with findByFirstName('Alice'):");
//        System.out.println("--------------------------------");
//        System.out.println(repository.findByFirstName("Alice"));
//
//        System.out.println("Customers found with findByLastName('Smith'):");
//        System.out.println("--------------------------------");
//        for (Customer customer : repository.findByLastName("Smith")) {
//            System.out.println(customer);
//        }

    }

}
