package com.yoti.tech.task.hoover.utils;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.yoti.tech.task.hoover.error_handling.PatchesOutOfBoundsException;

public class HooverUtils {

	private static final int X = 0;
	private static final int Y = 1;

	public static LinkedList<Character> stringToList(String instruc) {

		LinkedList<Character> instructionList = new LinkedList<>();
		final char[] charArray = instruc.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			instructionList.add(charArray[i]);
		}
		return instructionList;
	}

	public static List<Point> getPointList(int[][] patches, int[] roomSize) throws PatchesOutOfBoundsException {

		List<Point> coords = new ArrayList<Point>(patches.length);

		for (int i = 0; i < patches.length; i++) {

			if (patches[i][X] > roomSize[X] || patches[i][Y] > roomSize[Y]) {

				throw new PatchesOutOfBoundsException("Patches must be inside the room");
			}
			coords.add(new Point(patches[i][X], patches[i][Y]));
		}
		return coords;

	}
}
