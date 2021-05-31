package com.example.security.securityDemo.Team.Repository;

import com.example.security.securityDemo.Team.Model.Team;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;
import java.util.UUID;

public interface TeamRepository extends PagingAndSortingRepository<Team, UUID> {
}
