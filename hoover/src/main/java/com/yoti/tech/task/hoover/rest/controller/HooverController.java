package com.yoti.tech.task.hoover.rest.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yoti.tech.task.hoover.error_handling.exceptions.CoordinatesOutOfBoundsException;
import com.yoti.tech.task.hoover.error_handling.exceptions.PatchesOutOfBoundsException;
import com.yoti.tech.task.hoover.rest.Request;
import com.yoti.tech.task.hoover.rest.Response;
import com.yoti.tech.task.hoover.service.HooverServiceImpl;

@RestController
@RequestMapping("api/hoover")
public class HooverController {

	@Autowired
	HooverServiceImpl hooverService;
	
	private static final Logger logger = LoggerFactory.getLogger(HooverController.class);

	@PostMapping(value = "/position", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> hooverPosition(@Valid @RequestBody Request request) throws PatchesOutOfBoundsException, CoordinatesOutOfBoundsException {
		logger.info("Enpoint : api/hoover/position");
		Response response = hooverService.cleanPatches(request);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

}
