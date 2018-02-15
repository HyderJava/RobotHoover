package com.yoti.tech.task.hoover.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.yoti.tech.task.hoover.error_handling.exceptions.CoordinatesOutOfBoundsException;
import com.yoti.tech.task.hoover.error_handling.exceptions.PatchesOutOfBoundsException;
import com.yoti.tech.task.hoover.rest.Request;
import com.yoti.tech.task.hoover.rest.Response;

public class HooverServiceTest {

	HooverService service;
	Request request;

	@Before
	public void setUp() throws Exception {
		service = new HooverServiceImpl();
	}

	@After
	public void tearDown() throws Exception {
		request = null;
	}

	@Test
	public void runPatchesOutSideOfRoom() throws Exception {

		// Given
		request = new Request(new int[] { 5, 6 }, new int[] { 1, 1 }, new int[][] { { 2, 3 }, { 10, 10 }, { 3, 3 } },
				"NESW");
		// When
		try {
			service.cleanPatches(request);
		}
		// Then
		catch (Exception e) {
			assertTrue(e instanceof PatchesOutOfBoundsException);
		}
	}

	@Test
	public void runStartingPointOutsideOfRoomException() throws Exception {

		// Given
		request = new Request(new int[] { 5, 6 }, new int[] { 7, 7 }, new int[][] { { 2, 2 }, { 3, 3 } }, "NESW");
		// When
		try {
			service.cleanPatches(request);
		}
		// Then
		catch (Exception e) {
			assertTrue(e instanceof CoordinatesOutOfBoundsException);
		}
	}

	@Test
	public void runStartingPointInsideRoomBoundry() throws Exception {

		// Given
		request = new Request(new int[] { 5, 6 }, new int[] { 1, 1 }, new int[][] { { 2, 3 }, { 3, 2 }, { 3, 3 } },
				"NESW");

		Response expectedResponse = new Response();
		expectedResponse.setCoords(new int[] { 5, 3 });
		expectedResponse.setPatches(2);
		// When
		Response actualResponse = service.cleanPatches(request);

		// Then

	}

	@Test
	public void runPatchesInsideOfRoomBoundry() throws Exception {

		// Given
		request = new Request(new int[] { 5, 6 }, new int[] { 1, 1 }, new int[][] { { 2, 3 }, { 3, 2 }, { 3, 3 } },
				"NESW");
		Response expectedResponse = new Response();
		expectedResponse.setCoords(new int[] { 5, 3 });
		expectedResponse.setPatches(2);
		// When
		Response actualResponse = service.cleanPatches(request);

		// Then
	}
}
