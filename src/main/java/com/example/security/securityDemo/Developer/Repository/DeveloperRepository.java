package com.example.security.securityDemo.Developer.Repository;

import com.example.security.securityDemo.Developer.Model.Developer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.UUID;

public interface DeveloperRepository extends PagingAndSortingRepository<Developer, UUID> {

    @Query("select u from Developer u where u.teamId = ?1")
    List<Developer> findDeveloperByTeamId(UUID login);
}
