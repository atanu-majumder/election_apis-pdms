package com.service.election_apis.service;

import com.service.election_apis.entity.TestJ;

public interface StudService {

	TestJ saveStud(TestJ stud);

	TestJ getStudById(Integer id);
}
