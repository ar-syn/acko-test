package com.example.security.securityDemo.User.Repository;

import com.example.security.securityDemo.User.Model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface UserRepository extends PagingAndSortingRepository<User, UUID> {

    @Query("select u from User u where lower(u.login) = lower(?1)")
    User findOneNotDeletedByEmail(String login);
}
