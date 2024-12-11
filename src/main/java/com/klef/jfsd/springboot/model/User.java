package com.klef.jfsd.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="user_table")
public class User 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "nutritionist_id")
    private Nutritionist nutritionist;
    
    @Column(name="uname", nullable=false, length=50)
    private String name;
    
    @Column(name="ugender", nullable=false, length=20)
    private String gender;
    
    @Column(name="udob", nullable=false, length=20)
    private String dateOfBirth;
    
    @Column(name="uheight", nullable=false)
    private double height; // in cm
    
    @Column(name="uweight", nullable=false)
    private double weight; // in kg
    
    @Column(name="uactivitylevel", nullable=false, length=50)
    private String activityLevel; // e.g., Sedentary, Moderate, Active
    
    @Column(name="udietarypreferences", length=100)
    private String dietaryPreferences; // e.g., Vegetarian, Vegan, Gluten-free
    
    @Column(name="uallergies", length=100)
    private String allergies; // e.g., Peanuts, Shellfish
    
    @Column(name="uhealthconditions", length=200)
    private String healthConditions; // e.g., Diabetes, Hypertension
    
    @Column(name="uemail", nullable=false, unique=true, length=50)
    private String email;
    
    @Column(name="upwd", nullable=false, length=50)
    private String password;
    
    @Column(name="ucontact", nullable=false, unique=true, length=20)
    private String contact;
    
    @Column(name="ulocation", nullable=false, length=50)
    private String location;
    
    @Column(name="utargetweight", nullable=true)
    private Double targetWeight; // Target weight in kg

    @Column(name="ugoal", nullable=true, length=50)
    private String goal; // e.g., Maintain weight, Lose weight, Gain muscle
    
    @Column(name="ustatus", nullable=false, length=50)
    private String status; // e.g., Active, Inactive
    

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Nutritionist getNutritionist() {
		return nutritionist;
	}

	public void setNutritionist(Nutritionist nutritionist) {
		this.nutritionist = nutritionist;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getActivityLevel() {
		return activityLevel;
	}

	public void setActivityLevel(String activityLevel) {
		this.activityLevel = activityLevel;
	}

	public String getDietaryPreferences() {
		return dietaryPreferences;
	}

	public void setDietaryPreferences(String dietaryPreferences) {
		this.dietaryPreferences = dietaryPreferences;
	}

	public String getAllergies() {
		return allergies;
	}

	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	public String getHealthConditions() {
		return healthConditions;
	}

	public void setHealthConditions(String healthConditions) {
		this.healthConditions = healthConditions;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Double getTargetWeight() {
		return targetWeight;
	}

	public void setTargetWeight(Double targetWeight) {
		this.targetWeight = targetWeight;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

    // Getters and Setters for all fields...

}
