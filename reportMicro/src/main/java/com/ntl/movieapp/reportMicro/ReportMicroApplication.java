package com.ntl.movieapp.reportMicro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class ReportMicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReportMicroApplication.class, args);
		System.out.println("I AM ALm");
	}
}
