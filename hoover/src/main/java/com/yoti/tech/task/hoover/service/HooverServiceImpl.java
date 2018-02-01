package com.yoti.tech.task.hoover.service;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.yoti.tech.task.hoover.error_handling.exceptions.CoordinatesOutOfBoundsException;
import com.yoti.tech.task.hoover.error_handling.exceptions.PatchesOutOfBoundsException;
import com.yoti.tech.task.hoover.model.Hoover;
import com.yoti.tech.task.hoover.model.Room;
import com.yoti.tech.task.hoover.rest.Request;
import com.yoti.tech.task.hoover.rest.Response;
import com.yoti.tech.task.hoover.utils.HooverUtils;

@Service
public class HooverServiceImpl implements HooverService {

	@Override
	public Response cleanPatches(Request request) throws PatchesOutOfBoundsException, CoordinatesOutOfBoundsException {

		// Convert the request object into suitable data structures & validate context (room size & starting point)
		Set<Point> patches = HooverUtils.getPatchesSet(request.getPatches(), request.getRoomSize());
		List<Character> instructionList = HooverUtils.stringToList(request.getInstructions());
		Point startingPoint = HooverUtils.getStartPoint(request.getRoomSize(), request.getCoords());
		Point roomSize = HooverUtils.getRoomSize(request.getRoomSize());
		// Instantiate a new hoover and room object
		Room room = new Room(patches, roomSize);
		Hoover hoover = new Hoover(startingPoint, room);
		// Execute the instructions
		hoover.runInstructions(instructionList);
		// form response
		Response response = new Response();
		response.setCoords(new int[]{hoover.getCurrentPoint().x, hoover.getCurrentPoint().y});
		response.setPatches(hoover.getNumOfPatchesCleaned());
		return response;
	}

}
