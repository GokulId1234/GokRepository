package com.scp.sort;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.scp.sort.bean.SortNumberDataBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ScpSortApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SortNumberServiceControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

	}

	@Test
	public void verifyAllSortedList() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.get("/api/retrieveSortedNumbers/")
						.accept(MediaType.APPLICATION_JSON)).andReturn()
				.getResponse().isCommitted();
	}

	@Test
	public void verifySaveToDo() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.post("/api/sortNumbers/")
						.contentType(MediaType.APPLICATION_FORM_URLENCODED)
						.param("inputNumbers", "3,9,6")
						.requestAttr("todo", new SortNumberDataBean()))
				.andReturn().getModelAndView().getModel()
				.containsKey("sortDataBean");

	}

}