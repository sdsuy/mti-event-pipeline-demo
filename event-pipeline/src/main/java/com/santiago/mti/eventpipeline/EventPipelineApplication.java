package com.santiago.mti.eventpipeline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class EventPipelineApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventPipelineApplication.class, args);
	}

}
