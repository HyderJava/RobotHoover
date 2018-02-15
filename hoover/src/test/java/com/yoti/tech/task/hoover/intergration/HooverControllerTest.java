package com.yoti.tech.task.hoover.intergration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yoti.tech.task.hoover.rest.controller.HooverController;
import com.yoti.tech.task.hoover.service.HooverService;

@RunWith(SpringRunner.class)
@WebMvcTest(HooverController.class)
public class HooverControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	HooverController hooverController;
	
	@Autowired
	ObjectMapper objectMapper;

	@Test
	public void testInvalidInstructions() throws Exception {
		
		mockMvc.perform(("/api/hoover/position")
	           ));*/
	}
}
