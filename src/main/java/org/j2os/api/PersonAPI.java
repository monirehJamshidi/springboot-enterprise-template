package org.j2os.api;

import org.j2os.service.PersonService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonAPI {

    private final PersonService personService;

    public PersonAPI(PersonService personService){
        this.personService = personService;
    }

    @Value("${Behsazan.development.project}")
    private String projectName;

    @Value("${platform.name}")
    private String platform;

    @GetMapping("/save")
    public String save(){
        System.out.println("saved1");


        return "projectName: " + projectName + " , platform: " + platform;//"save invoked1";
    }

    @GetMapping("/find/{id}")
    public String find(@PathVariable Long id){
        return personService.findPersonById(id);
    }

    // Diese API wird zum Testen in Postman verwendet
    @GetMapping("/1")
    public String execute1(){
        return "one";
    }

    @PostMapping("/2")
    public String execute2(){
        return "two";
    }
}
