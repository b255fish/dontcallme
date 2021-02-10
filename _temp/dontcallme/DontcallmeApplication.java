package com.practice.dontcallme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DontcallmeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DontcallmeApplication.class);
	}
}


/*
	gradle bootRun 이 아닌, main() 메소드를 갖는 ~Application.java 를 실행시켜줘야함.
*/