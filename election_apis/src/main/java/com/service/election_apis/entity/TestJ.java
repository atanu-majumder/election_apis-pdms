package com.service.election_apis.entity;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.JsonNode;
import tools.jackson.databind.JsonNode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="test_j", schema = "pdms")
public class TestJ {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idd;
	
	@Column(name="stud_key")
	private Integer studKey;
	
	@JdbcTypeCode(SqlTypes.JSON)
	@Column(name="stud_data")
	private JsonNode studData;

	public TestJ(Integer idd, Integer studKey, JsonNode studData) {
		super();
		this.idd = idd;
		this.studKey = studKey;
		this.studData = studData;
	}

	public Integer getIdd() {
		return idd;
	}

	public void setIdd(Integer idd) {
		this.idd = idd;
	}

	public Integer getStudKey() {
		return studKey;
	}

	public void setStudKey(Integer studKey) {
		this.studKey = studKey;
	}

	public JsonNode getStudData() {
		return studData;
	}

	public void setStudData(JsonNode studData) {
		this.studData = studData;
	}
	
	
}
