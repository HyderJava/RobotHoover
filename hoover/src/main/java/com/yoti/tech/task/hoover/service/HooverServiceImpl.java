package com.yoti.tech.task.hoover.service;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.yoti.tech.task.hoover.error_handling.exceptions.CoordinatesOutOfBoundsException;
import com.yoti.tech.task.hoover.error_handling.exceptions.PatchesOutOfBoundsException;
import com.yoti.tech.task.hoover.model.Hoover;
import com.yoti.tech.task.hoover.model.Room;
import com.yoti.tech.task.hoover.rest.Request;
import com.yoti.tech.task.hoover.rest.Response;
import com.yoti.tech.task.hoover.rest.controller.HooverController;
import com.yoti.tech.task.hoover.utils.HooverUtils;

@Service
public class HooverServiceImpl implements HooverService {
	
	private static final Logger logger = LoggerFactory.getLogger(HooverServiceImpl.class);

	@Override
	public Response cleanPatches(Request request) throws PatchesOutOfBoundsException, CoordinatesOutOfBoundsException {

		logger.debug("Converting & validating request objects ");
		// Convert the request object into suitable data structures & validate context (room size & starting point)
		Set<Point> patches = HooverUtils.getPatchesSet(request.getPatches(), request.getRoomSize());
		List<Character> instructionList = HooverUtils.stringToList(request.getInstructions());
		Point startingPoint = HooverUtils.getStartPoint(request.getRoomSize(), request.getCoords());
		Point roomSize = HooverUtils.getRoomSize(request.getRoomSize());
		logger.debug("Instantiating new hoover & room objects ");
		// Instantiate a new hoover and room object
		Room room = new Room(patches, roomSize);
		Hoover hoover = new Hoover(startingPoint, room);
		// Execute the instructions
		logger.info("Executing instructions ");
		hoover.runInstructions(instructionList);
		// form response
		Response response = new Response();
		response.setCoords(new int[]{hoover.getCurrentPoint().x, hoover.getCurrentPoint().y});
		response.setPatches(hoover.getNumOfPatchesCleaned());
		logger.info("Number of patches cleaned :  " + hoover.getNumOfPatchesCleaned());
		logger.info("Final coordinates are : " + hoover.getCurrentPoint().x + hoover.getCurrentPoint().y);
		return response;
	}

}
