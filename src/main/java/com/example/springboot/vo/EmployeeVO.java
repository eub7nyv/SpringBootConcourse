package com.example.springboot.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class EmployeeVO {

	@Id
	@GeneratedValue
	private Long id;
    private String firstName;
    private String laststName;
    private String email;



    public String getFirstName() {
        return firstName;
    }

    

    public EmployeeVO(String firstName, String laststName, String email) {
       // this.srno = srno;
        this.firstName = firstName;
        this.laststName = laststName;
        this.email = email;
    }

    

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLaststName() {
        return laststName;
    }

    public void setLaststName(String laststName) {
        this.laststName = laststName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}

    

}
