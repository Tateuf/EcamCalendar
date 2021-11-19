package com.ecam.Calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class CalendarApplication {
	public static void main(String[] args) throws ClassNotFoundException {
		DBConnect.Connect();
		SpringApplication.run(CalendarApplication.class, args);
	}

}
