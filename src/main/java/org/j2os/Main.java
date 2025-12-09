package org.j2os;

import org.j2os.service.PersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Main.class);
        springApplication.addListeners(new ApplicationPidFileWriter("process.id"));
        springApplication.run();
    }

    @Bean
    CommandLineRunner startup(PersonService personService, PersonService personService1) {
        return (environment) -> {
            personService.save();
            System.out.println("******");
//            PersonService personService1 = new PersonService();
            personService1.save();
        };
    }
}
