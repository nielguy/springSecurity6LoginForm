package com.nielo.springsecurityloginform.springsecurityloginform.service;

import com.nielo.springsecurityloginform.springsecurityloginform.model.People;
import com.nielo.springsecurityloginform.springsecurityloginform.model.Role;
import com.nielo.springsecurityloginform.springsecurityloginform.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private PeopleRepository peopleRepository;

    @Autowired
    public UserDetailsServiceImpl(PeopleRepository peopleRepository) {
        this.peopleRepository=peopleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<People> opt = peopleRepository.findPeopleByEmail(email);
        if(opt.isEmpty()) {
            throw new UsernameNotFoundException("People with email: "+email+" not found");
        } else {
//            return User.builder().username(email).password(opt.get().getPassword()).roles(mapRolesToAuthorities(opt.get().getRoles() )).build();
            return new User(opt.get().getId(), opt.get().getPassword(), mapRolesToAuthorities(opt.get().getRoles()));
        }
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
