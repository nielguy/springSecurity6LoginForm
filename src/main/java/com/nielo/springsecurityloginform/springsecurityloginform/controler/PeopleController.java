package com.nielo.springsecurityloginform.springsecurityloginform.controler;

import com.nielo.springsecurityloginform.springsecurityloginform.DTO.PeopleRegistrationDTO;
import com.nielo.springsecurityloginform.springsecurityloginform.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class PeopleController {

    private PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService=peopleService;
    }

    @ModelAttribute("people")
    public PeopleRegistrationDTO peopleRegistrationDTO() {
        return new PeopleRegistrationDTO();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String registrationPeopleAccount(@ModelAttribute("people") PeopleRegistrationDTO peopleRegistrationDTO) {
        peopleService.savePeople(peopleRegistrationDTO);
        return "redirect:/registration?success";
    }
}
