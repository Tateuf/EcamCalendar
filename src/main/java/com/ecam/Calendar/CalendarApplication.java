package com.ecam.Calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URISyntaxException;

@SpringBootApplication
public class CalendarApplication {
	public static void main(String[] args) throws ClassNotFoundException, IOException, InterruptedException, URISyntaxException {
		//DBConnect db = new DBConnect();
		//db.Ping();
		HttpRequestExample httpRequestExample = new HttpRequestExample();
		httpRequestExample.Print();
		SpringApplication.run(CalendarApplication.class, args);
	}

}
