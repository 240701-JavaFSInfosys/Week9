package com.revature.SpringLambda;

import com.revature.SpringLambda.services.FishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

@SpringBootApplication
public class SpringLambdaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringLambdaApplication.class, args);
	}

	@Autowired //field injection bad!!!
	FishService fs = new FishService();

	/*Realistically, each lambda would have its own standalone Spring app
	BUT... we're just gonna make new jars from this same app and comment stuff out
	Making essentially a new app, but it's really just the same one. */


	//A Supplier is a Spring Cloud Function Type that SUPPLIES some value(s)
	//Typically be used for GET-type requests
//	@Bean
//	public Supplier<List<String>> getFish() {
//		return () -> fs.getFish();
//	}


	//A Consumer is a Spring Cloud Function Type that CONSUMES some value(s)
	//Typically be used for non-GET type requests
	@Bean
	public Consumer<String> insertFish(){
		return value -> fs.insertFish(value);
	}

	//TODO: "Function" type would let us consume a value and supply a value.
		//Consumer only lets us insert a value, hence the "OK" on the lambda side.


}
