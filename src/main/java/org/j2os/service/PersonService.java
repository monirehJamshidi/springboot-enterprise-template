package org.j2os.service;

import org.j2os.exception.BusinessException;
import org.j2os.exception.NotFoundException;
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

    public String findPersonById(Long id){
        if (id == null || id <= 0) {
            throw new BusinessException("Invalid person id provided");
        }

        if (id != 1L) {
            throw new NotFoundException("Person with id " + id + " not found");
        }

        return "Person 1";
    }
}
