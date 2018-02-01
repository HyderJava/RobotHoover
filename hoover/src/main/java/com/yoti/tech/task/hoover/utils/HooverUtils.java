package com.yoti.tech.task.hoover.utils;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yoti.tech.task.hoover.error_handling.exceptions.CoordinatesOutOfBoundsException;
import com.yoti.tech.task.hoover.error_handling.exceptions.PatchesOutOfBoundsException;
import com.yoti.tech.task.hoover.service.HooverServiceImpl;

public class HooverUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(HooverUtils.class);

	private static final int X = 0;
	private static final int Y = 1;

	public static LinkedList<Character> stringToList(String instruc) {

		LinkedList<Character> instructionList = new LinkedList<>();
		final char[] charArray = instruc.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			instructionList.add(charArray[i]);
		}
		logger.info("Insturctions successfully processed ");
		return instructionList;
	}

	public static Set<Point> getPatchesSet(int[][] patches, int[] roomSize) throws PatchesOutOfBoundsException {

		Set<Point> coords = new HashSet<Point>(patches.length);
		for (int i = 0; i < patches.length; i++) {

			if (patches[i][X] > roomSize[X] || patches[i][Y] > roomSize[Y]) {

				logger.error("Patches are not valid coordinates inside the perimeter of the room");
				throw new PatchesOutOfBoundsException();
			}
			coords.add(new Point(patches[i][X], patches[i][Y]));
		}
		logger.info("Patches successfully processed ");
		return coords;

	}

	public static Point getStartPoint(int[] roomSize, int[] startingPoint) throws CoordinatesOutOfBoundsException {

		if (0 > roomSize[X] || 0 > roomSize[Y] || roomSize[X] < startingPoint[X] || roomSize[Y] < startingPoint[Y]) {

			logger.error("Coordinates are not inside the perimeter of the room");
			throw new CoordinatesOutOfBoundsException();
		}
		logger.info("Starting point successfully processed ");
		return new Point(startingPoint[X], startingPoint[Y]);
	}

	public static Point getRoomSize(int[] roomSize) {

		return new Point(roomSize[X], roomSize[Y]);
	}
}
