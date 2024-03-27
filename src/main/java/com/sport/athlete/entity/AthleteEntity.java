package com.sport.athlete.entity;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import com.sport.running.entity.RunningEntity;
@Entity
@Table(
        name = "athlete"
)
public class AthleteEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private double height;
    private double weight;
    private double maxSpeed;
    private int speciality;

    // private int physicalCondition;
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)    
    @JoinTable(name = "running_athlete", 
    	joinColumns = @JoinColumn(name = "athlete_id"), 
        inverseJoinColumns = @JoinColumn(name = "running_id"))
    private Set<RunningEntity> running = new HashSet<>();

    public AthleteEntity(long id, String firstName, String lastName, int age, double height, double weight, double maxSpeed, int speciality) {
        this.id= id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.maxSpeed = maxSpeed;
        this.speciality = speciality;
    }

    public AthleteEntity() {
    }

    public AthleteEntity(AthleteEntity athlete) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getSpeciality() {
        return speciality;
    }

    public void setSpeciality(int speciality) {
        this.speciality = speciality;
    }
    
}
