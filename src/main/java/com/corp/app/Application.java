package com.corp.app;


import com.corp.app.entities.Transaction;
import com.corp.app.repository.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String... args) {
        SpringApplication.run(Application.class,args);
    }

    @Bean
    public CommandLineRunner quickAppDemo(final TransactionRepository repository) {
        return (args) -> {
            repository.save(new Transaction(new Date(System.currentTimeMillis()),"Online"));
            repository.save(new Transaction(new Date(System.currentTimeMillis()),"Store"));
            repository.save(new Transaction(new Date(System.currentTimeMillis()),"Store"));

            for (Transaction transaction : repository.findAll()) {
                log.info("Transactions inserte are : " + transaction.toString());
            }
        };
    }

}
