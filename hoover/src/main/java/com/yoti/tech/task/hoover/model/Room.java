package com.yoti.tech.task.hoover.model;

import java.awt.Point;
import java.util.List;
import java.util.Set;

public class Room {

	private Set<Point> patches;
	private Point size;
	private int northPerimeter;
	private int eastPerimeter;
	private int southPerimeter;
	private int westPerimeter;

	public Room(Set<Point> patches, Point roomSize) {
		super();
		this.patches = patches;
		this.size = roomSize;
		setEdges();
	}

	private void setEdges() {

		this.northPerimeter = size.y;
		this.eastPerimeter = size.x;
		this.southPerimeter = 0;
		this.westPerimeter = 0;
	}

	public Set<Point> getPatches() {
		return patches;
	}

	public Point getSize() {
		return size;
	}
	
	public int getNorthPerimeter() {
		return northPerimeter;
	}

	public int getEastPerimeter() {
		return eastPerimeter;
	}

	public int getSouthPerimeter() {
		return southPerimeter;
	}

	public int getWestPerimeter() {
		return westPerimeter;
	}

}
