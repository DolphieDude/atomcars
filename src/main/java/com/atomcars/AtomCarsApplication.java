package com.atomcars;

import com.atomcars.entity.CompleteUser;
import com.atomcars.entity.Document;
import com.atomcars.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AtomCarsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtomCarsApplication.class, args);
	}



}
