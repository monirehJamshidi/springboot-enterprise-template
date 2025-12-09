package org.j2os.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Value("${app.name}")
    private String appName;

    public PersonService() {
        System.out.println("Constructor called");
    }

    public void save(){
        System.out.println(appName);
    }
}
