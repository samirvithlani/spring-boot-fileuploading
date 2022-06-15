package com;

import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.serives.FileStorageServices;

@SpringBootApplication
public class SpringBootFileUploadSeriviceApplication {

	@Resource
	FileStorageServices fileStorageServices;

	public static void main(String[] args) {

		SpringApplication.run(SpringBootFileUploadSeriviceApplication.class, args);

	}

	public void run(String...strings)throws Exception{
		
		
		fileStorageServices.init();
	}
}
