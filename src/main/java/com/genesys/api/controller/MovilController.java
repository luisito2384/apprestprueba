package com.genesys.api.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.genesys.api.dao.entity.MovilEntity;

@RestController
@RequestMapping("/api/v2")
public class MovilController {

	private static final Logger logger = LogManager.getLogger(MovilController.class);
	@GetMapping("/logs")
	public ResponseEntity<?> getAllMovil(){
		Map<String, Object> response = new HashMap<String, Object>();
		MovilEntity moviles = new MovilEntity();
		response.put("moviles", moviles);
		//To clear context
		//ThreadContext.clearAll();
		logger.info(" - Prueba");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	@PostMapping("/movil")
	public ResponseEntity<?> save(@RequestBody MovilEntity movil){
		Map<String, Object> response = new HashMap<String, Object>();
		MovilEntity movilSave = new MovilEntity();
		response.put("movil", movilSave);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
