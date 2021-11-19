package com.ecam.Calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class CalendarApplication {
	public static void main(String[] args) throws ClassNotFoundException {
		DBConnect db = new DBConnect();
		db.Ping();
		SpringApplication.run(CalendarApplication.class, args);
	}

}
