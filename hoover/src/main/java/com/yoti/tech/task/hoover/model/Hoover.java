package com.yoti.tech.task.hoover.model;

import java.awt.Point;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class Hoover {

	private static final Character NORTH = 'N';
	private static final Character EAST = 'E';
	private static final Character SOUTH = 'S';
	private static final Character WEST = 'W';

	private Room room;
	private Point currentPoint;
	private int numOfPatchesCleaned;

	public Hoover(Point startingPoint, Room room) {

		this.currentPoint = startingPoint;
		this.room = room;
	}

	public void runInstructions(List<Character> instructionList) {

		instructionList.stream().forEachOrdered(instruction -> {
			typeMap.get(instruction).get();
		});
	}

	@SuppressWarnings("serial")
	Map<Character, Supplier<Point>> typeMap = new HashMap<Character, Supplier<Point>>() {
		{
			put(NORTH, () -> moveNorth());
			put(EAST, () -> moveEast());
			put(SOUTH, () -> moveSouth());
			put(WEST, () -> moveWest());

		}

	};

	public Point moveNorth() {

		if (currentPoint.y < room.getNorthPerimeter()) {
			currentPoint.y++;
			if (isPatchCleaned()) {
				numOfPatchesCleaned++;
			}
		}
		return currentPoint;
	}

	public Point moveSouth() {

		if (currentPoint.y > room.getSouthPerimeter()) {
			currentPoint.y--;
			if (isPatchCleaned()) {
				numOfPatchesCleaned++;
			}
		}

		return currentPoint;
	}

	public Point moveWest() {

		if (currentPoint.x > room.getWestPerimeter()) {
			currentPoint.x--;
			if (isPatchCleaned()) {
				numOfPatchesCleaned++;
			}
		}
		return currentPoint;

	}

	public Point moveEast() {

		if (currentPoint.x < room.getEastPerimeter()) {
			currentPoint.x++;
			if (isPatchCleaned()) {
				numOfPatchesCleaned++;
			}
		}

		return currentPoint;
	}

	public Point getCurrentPoint() {
		return currentPoint;
	}

	private Boolean isPatchCleaned() {

		if (room.getPatches().stream().anyMatch(patch -> patch.equals(currentPoint))) {
			room.getPatches().remove(currentPoint);
			return true;
		}
		return false;
	}

	public int getNumOfPatchesCleaned() {
		return numOfPatchesCleaned;
	}

}
