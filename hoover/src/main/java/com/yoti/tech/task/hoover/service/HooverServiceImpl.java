package com.yoti.tech.task.hoover.service;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.yoti.tech.task.hoover.error_handling.PatchesOutOfBoundsException;
import com.yoti.tech.task.hoover.model.Hoover;
import com.yoti.tech.task.hoover.model.Room;
import com.yoti.tech.task.hoover.rest.Request;
import com.yoti.tech.task.hoover.rest.Response;
import com.yoti.tech.task.hoover.utils.HooverUtils;

@Service
public class HooverServiceImpl implements HooverService {

	@Override
	public Response cleanPatches(Request request) throws PatchesOutOfBoundsException {

		// Convert the request object into suitable data structures
		List<Point> patches = HooverUtils.getPointList(request.getPatches(), request.getRoomSize());
		List<Character> instructionList = HooverUtils.stringToList(request.getInstructions());
		
		//get coords
		// Instantiate a new hoover and room object
		Room room = new Room(); // TODO
		Hoover hoover = new Hoover(room, null);
		// Execute the instructions
		hoover.runInstructions(instructionList);

		// TODO
		// ERROR MESSAGES
		// COMPLETE LOGIC

		// Execute the instructions

		return null;
	}

}
