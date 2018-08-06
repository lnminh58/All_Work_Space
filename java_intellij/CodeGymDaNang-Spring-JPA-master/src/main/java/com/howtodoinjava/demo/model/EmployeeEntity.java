package com.howtodoinjava.demo.model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table (name="employee")
public class EmployeeEntity implements Serializable 
{
    private static final long serialVersionUID = 1L;
 
    @Id
    @GeneratedValue
    private Integer id;
     
    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

  /*  @NotNull
    @ManyToOne
    private DepartmentEntity department;
     */
    public EmployeeEntity() {}
      
 /*   public EmployeeEntity(String name, DepartmentEntity department) {
        this.firstName = name;
        this.department = department;
    }
  */    
    public EmployeeEntity(String name) {
        this.firstName = name;
    }
 
    //Setters and Getters
 
    @Override
    public String toString() {
        return "EmployeeVO [id=" + id + ", firstName=" + firstName
                + ", lastName=" + lastName + ", email=" + email
                + ", department="  + "]";
    }
    
    public String getFirstName() {
		return firstName;
	}
    
    public String getLastName() {
		return lastName;
	}
    
    public String getEmail() {
		return email;
	}
}
