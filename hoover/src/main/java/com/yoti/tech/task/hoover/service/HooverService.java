package com.yoti.tech.task.hoover.service;

import com.yoti.tech.task.hoover.error_handling.PatchesOutOfBoundsException;
import com.yoti.tech.task.hoover.rest.Request;
import com.yoti.tech.task.hoover.rest.Response;

public interface HooverService {
	
	  public Response cleanPatches(Request request) throws PatchesOutOfBoundsException;

}
