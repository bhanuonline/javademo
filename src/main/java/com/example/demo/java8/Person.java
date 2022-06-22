package com.example.demo.java8;

import java.time.LocalDate;
import java.util.List;

interface CheckPerson {
    boolean test(Person p);
}

public class Person {

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;
    int age;

    public int getAge() {
       return this.age;
    }

    public void printPerson() {
       System.out.println("Name of the Person:"+getName());
    }
    
    public String getName() {
		return name;
	}
    
	public LocalDate getBirthday() {
		return birthday;
	}

	public Sex getGender() {
		return gender;
	}

	

	public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }
	public static void printPersons(
		    List<Person> roster, CheckPerson tester) {
		    for (Person p : roster) {
		        if (tester.test(p)) {
		            p.printPerson();
		        }
		    }
		}
	
}

class CheckPersonEligibleForSelectiveService implements CheckPerson {
    public boolean test(Person p) {
        return p.gender == Person.Sex.MALE &&
            p.getAge() >= 18 &&
            p.getAge() <= 25;
    }
}