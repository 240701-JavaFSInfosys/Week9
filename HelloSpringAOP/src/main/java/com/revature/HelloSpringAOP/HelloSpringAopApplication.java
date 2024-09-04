package com.revature.HelloSpringAOP;

import com.revature.HelloSpringAOP.models.Human;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringAopApplication {

	//inject (autowire) a Human into main

	static Human h;

	@Autowired
	public HelloSpringAopApplication(Human h) {
		this.h = h;
	}

	public static void main(String[] args) {

		SpringApplication.run(HelloSpringAopApplication.class, args);

		h.setName("Bartholomew");
		h.setAge(2);
		h.setOccupation("Just a lil guy");

		System.out.println(h.eat(500));

		try{
			System.out.println(h.eat(100000));
		} catch(IllegalArgumentException e){
			System.out.println("Human almost exploded");
		}

	}

}
