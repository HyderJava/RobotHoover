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

	private final Room room;
	private final Point startingPoint;

	public Hoover(Room room, Point startingPoint) {

		this.room = room;
		this.startingPoint = startingPoint;
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

	private Point moveNorth() {
		System.out.println("Move north");
		return null;
	}

	private Point moveEast() {
		System.out.println("Move east");
		return null;
	}

	private Point moveSouth() {
		System.out.println("Move south");
		return null;
	}

	private Point moveWest() {
		System.out.println("Move west");
		return null;
	}

	public Room getRoom() {
		return room;
	}

	public Point getStartingPoint() {
		return startingPoint;
	}

}
