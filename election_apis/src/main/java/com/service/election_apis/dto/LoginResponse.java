package com.service.election_apis.dto;

public class LoginResponse {

	private String token;
    private String tokenType;
    private Integer pollingStationId;
    private Integer blockId;
    private Integer electionId;
    private String empName;
    private String designation;
    private String gender;
    private String pollingStationName;
    private String districtName;
    private String blockName;
    private Integer wardId;
    private String wardName;
    private java.util.List<Integer> seatNos;

    
	 
    public LoginResponse() {
    }
    
    

    public LoginResponse(String token, Integer pollingStationId, Integer blockId, Integer electionId,
			String empName, String designation, String gender, String pollingStationName, String districtName,
			String blockName, Integer wardId, String wardName) {
		
		this.token = token;
		this.tokenType = "Bearer";
		this.pollingStationId = pollingStationId;
		this.blockId = blockId;
		this.electionId = electionId;
		this.empName = empName;
		this.designation = designation;
		this.gender = gender;
		this.pollingStationName = pollingStationName;
		this.districtName = districtName;
		this.blockName = blockName;
		this.wardId = wardId;
		this.wardName = wardName;
	}


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public Integer getPollingStationId() {
        return pollingStationId;
    }

    public Integer getBlockId() {
        return blockId;
    }

    public Integer getElectionId() {
        return electionId;
    }



	public String getEmpName() {
		return empName;
	}

	public String getDesignation() {
		return designation;
	}

	public String getGender() {
		return gender;
	}

	public String getPollingStationName() {
		return pollingStationName;
	}

	public String getDistrictName() {
		return districtName;
	}

	public String getBlockName() {
		return blockName;
	}
	
	public Integer getWardId() {
		return wardId;
	}

	public String getWardName() {
		return wardName;
	}


	public java.util.List<Integer> getSeatNos() {
        return seatNos;
    }

    public void setSeatNos(java.util.List<Integer> seatNos) {
        this.seatNos = seatNos;
    }
    
}
