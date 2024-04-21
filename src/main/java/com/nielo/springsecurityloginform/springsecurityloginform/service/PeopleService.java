package com.nielo.springsecurityloginform.springsecurityloginform.service;


import com.nielo.springsecurityloginform.springsecurityloginform.DTO.PeopleRegistrationDTO;
import com.nielo.springsecurityloginform.springsecurityloginform.model.People;

public interface PeopleService {

    People savePeople(PeopleRegistrationDTO peopleRegistrationDTO);
}
