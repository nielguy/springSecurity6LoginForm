package com.nielo.springsecurityloginform.springsecurityloginform.service;

import com.nielo.springsecurityloginform.springsecurityloginform.DTO.PeopleRegistrationDTO;
import com.nielo.springsecurityloginform.springsecurityloginform.model.People;
import com.nielo.springsecurityloginform.springsecurityloginform.model.Role;
import com.nielo.springsecurityloginform.springsecurityloginform.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class PeopleServiceImpl implements PeopleService {

    private PeopleRepository peopleRepository;

    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public PeopleServiceImpl(PeopleRepository peopleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.peopleRepository=peopleRepository;
        this.passwordEncoder=passwordEncoder;
    }

    @Override
    public People savePeople(PeopleRegistrationDTO peopleRegistrationDTO) {
//        People people = new People(peopleRegistrationDTO.getName(), peopleRegistrationDTO.getEmail(), peopleRegistrationDTO.getPassword(), Arrays.asList(new Role("USER")));
        People people = new People();
        people.setName(peopleRegistrationDTO.getName());
        people.setEmail(peopleRegistrationDTO.getEmail());
        people.setPassword(passwordEncoder.encode(peopleRegistrationDTO.getPassword()));
        people.setRoles(Arrays.asList(new Role("USER")));
        return peopleRepository.save(people);
    }
}
