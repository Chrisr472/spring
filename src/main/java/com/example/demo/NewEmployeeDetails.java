package com.example.demo;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Emp_Dt")
public class NewEmployeeDetails {
	
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Integer id;

private String name,dob,fatherName,motherName,number;

@OneToMany(cascade=CascadeType.ALL)
@JoinColumn(name="a_id")
@OrderColumn(name="type")
List<Address> address;

/**
 * @return the id
 */
public Integer getId() {
	return id;
}

/**
 * @param id the id to set
 */
public void setId(Integer id) {
	this.id = id;
}

/**
 * @return the name
 */
public String getName() {
	return name;
}

/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}

/**
 * @return the dob
 */
public String getDob() {
	return dob;
}

/**
 * @param dob the dob to set
 */
public void setDob(String dob) {
	this.dob = dob;
}

/**
 * @return the fatherName
 */
public String getFatherName() {
	return fatherName;
}

/**
 * @param fatherName the fatherName to set
 */
public void setFatherName(String fatherName) {
	this.fatherName = fatherName;
}

/**
 * @return the motherName
 */
public String getMotherName() {
	return motherName;
}

/**
 * @param motherName the motherName to set
 */
public void setMotherName(String motherName) {
	this.motherName = motherName;
}

/**
 * @return the number
 */
public String getNumber() {
	return number;
}

/**
 * @param number the number to set
 */
public void setNumber(String number) {
	this.number = number;
}




}