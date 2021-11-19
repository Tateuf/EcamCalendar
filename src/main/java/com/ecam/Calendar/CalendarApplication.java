package com.ecam.Calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class CalendarApplication {
	DBConnect();
	public static void main(String[] args) {
		SpringApplication.run(CalendarApplication.class, args);
	}

}
