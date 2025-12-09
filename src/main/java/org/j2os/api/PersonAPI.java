package org.j2os.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonAPI {

    @Value("${Behsazan.development.project}")
    private String projectName;

    @Value("${platform.name}")
    private String platform;

    @GetMapping("/save")
    public String save(){
        System.out.println("saved1");


        return "projectName: " + projectName + " , platform: " + platform;//"save invoked1";
    }
}
