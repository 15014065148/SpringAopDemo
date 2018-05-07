package com.example.demo1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringAopDemo1ApplicationTests {
	@Autowired
	WebApplicationContext context;
	MockMvc mockMvc;

	private static final Logger logger = LoggerFactory.getLogger(SpringAopDemo1ApplicationTests.class);
	@Before
	public void setup(){
		mockMvc =  MockMvcBuilders.webAppContextSetup(context).build();
	}
	@Test
	public void accessWithoutAuth() throws Exception {
		String contentAsString = mockMvc.perform(MockMvcRequestBuilders.get("/accessWithoutAuth")
				.param("param","access something not important"))
				.andReturn().getResponse().getContentAsString();
		logger.info(contentAsString);
	}

	@Test
	public void accessWithAuthWithoutToken() throws Exception {
		MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get("/accessWithAuth")
				.param("param","access something  important")
		).andReturn().getResponse();
		String contentAsString = response.getContentAsString();
		logger.info(contentAsString);

	}

	@Test
	public void accessWithAuthWithToken() throws Exception {
		String contentAsString = mockMvc.perform(MockMvcRequestBuilders.get("/accessWithAuth")
				.param("param","access something  important")
				.param("token","123456")
		).andReturn().getResponse().getContentAsString();
		logger.info(contentAsString);

	}
}
