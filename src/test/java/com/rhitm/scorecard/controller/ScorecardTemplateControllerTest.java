package com.rhitm.scorecard.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rhitm.scorecard.domain.ScorecardTemplate;
import com.rhitm.scorecard.domain.TeeDescription;
import com.rhitm.scorecard.domain.TeePosition;
import com.rhitm.scorecard.dto.create.HoleRequest;
import com.rhitm.scorecard.dto.create.ScorecardTemplateRequest;
import com.rhitm.scorecard.dto.create.TeePositionRequest;

/**
 * Unit test for the <code>ScoreCardTemplateController</class>.
 *
 */
@AutoConfigureMockMvc
@WebMvcTest
class ScorecardTemplateControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @InjectMocks
    private ScorecardTemplateController controllerUnderTest;
    
    @Mock
    private ScorecardTemplate scorecardTemplate;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCreate() throws Exception {
		TeePositionRequest teePosition = new TeePositionRequest(TeeDescription.WHITE, 500, 3);
		List<TeePositionRequest> teePositions = new ArrayList<TeePositionRequest>();
		teePositions.add(teePosition);
		
		HoleRequest holeRequest = new HoleRequest(1, teePositions);
		List<HoleRequest> holes = new ArrayList<HoleRequest>();
		holes.add(holeRequest);
		
		ScorecardTemplateRequest request = new ScorecardTemplateRequest("Central Park", holes);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		mapper.setSerializationInclusion(Include.NON_EMPTY);
		String jsonRequest = mapper.writeValueAsString(request);
		
		System.out.println(jsonRequest);
		
	    //add the behavior of calc service to add two numbers
		String scorecardId = "sc-1234567890";
	    //when(scorecardTemplate.create()).thenReturn(scorecardId);
		
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/scorecard/templates")
                .content(jsonRequest)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();

        //verify(scorecardTemplate).create();
	}

}
