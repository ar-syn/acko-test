package com.example.security.securityDemo.User.Service;

import com.example.security.securityDemo.User.Model.User;
import com.example.security.securityDemo.User.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User getByEmail(String email) {
        User user = repository.findOneNotDeletedByEmail(email);
        return user;
    }
}
