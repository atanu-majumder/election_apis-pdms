package com.service.election_apis.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.election_apis.entity.TestJ;

@Repository
public interface StudRepository extends JpaRepository<TestJ, Integer> {

}
