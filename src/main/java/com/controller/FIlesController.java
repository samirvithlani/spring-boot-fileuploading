package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bean.FileBean;
import com.serives.FileStorageServices;
import com.serives.ResponseMessage;

@RestController
@CrossOrigin
public class FIlesController {

	@Autowired
	FileStorageServices fileStorageServices;

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ResponseEntity<ResponseMessage> uplpadFile(FileBean fileBean) {
		String message = " ";
		System.out.println(fileBean.getFile().getOriginalFilename());
		try {
			fileStorageServices.save(fileBean);
			System.out.println(fileBean.getName());
			message = "Upload file successFully :" + fileBean.getFile().getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		} catch (Exception e) {

			message = "could not uplaod file..." + fileBean.getFile().getOriginalFilename();
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}

	}
	
	@GetMapping("/")
	public void demo() {
		
		System.out.println("dd");
	}

}
