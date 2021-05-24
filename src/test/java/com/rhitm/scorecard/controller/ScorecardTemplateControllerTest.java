package com.rhitm.scorecard.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rhitm.scorecard.domain.ScorecardTemplate;
import com.rhitm.scorecard.domain.TeePosition;
import com.rhitm.scorecard.dto.create.HoleRequest;
import com.rhitm.scorecard.dto.create.ScorecardTemplateRequest;
import com.rhitm.scorecard.repository.ScorecardTemplateRepository;

/**
 * Unit test for the <code>ScoreCardTemplateController</class>.
 *
 */
// @SpringBootTest
@WebMvcTest(controllers = ScorecardTemplateController.class)
@AutoConfigureMockMvc
class ScorecardTemplateControllerTest {

	@MockBean
	private ScorecardTemplateRepository mockRepository;

	@Autowired
	private MockMvc mockMvc;

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
		ScorecardTemplateRequest request = createMockScorecardTemplate();

		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		mapper.setSerializationInclusion(Include.NON_EMPTY);
		String jsonRequest = mapper.writeValueAsString(request);

		String mockResponseScorecardId = generateMockScorecardTemplateId();
		ScorecardTemplate mockResponse = new ScorecardTemplate();
		mockResponse.setId(mockResponseScorecardId);
		when(mockRepository.save(any(ScorecardTemplate.class))).thenReturn(mockResponse);

		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.post("/scorecards/templates").content(jsonRequest)
						.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated()).andReturn();

		ArgumentCaptor<ScorecardTemplate> templateCaptor = ArgumentCaptor.forClass(ScorecardTemplate.class);
		verify(mockRepository, times(1)).save(templateCaptor.capture());
		assertThat(templateCaptor.getValue().getCourseName()).isEqualTo("Central Park");
		assertThat(templateCaptor.getValue().getHoles().size()).isEqualTo(1);
		assertThat(result.getResponse().getContentAsString()).isEqualTo(mockResponseScorecardId);
	}

//	@Test
	void testCreate_NegativeDistance() throws Exception {
		ScorecardTemplateRequest request = createMockScorecardTemplateWithNegativeDistance();

		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		mapper.setSerializationInclusion(Include.NON_EMPTY);
		String jsonRequest = mapper.writeValueAsString(request);
		
		String mockResponseScorecardId = generateMockScorecardTemplateId();
		ScorecardTemplate mockResponse = new ScorecardTemplate();
		mockResponse.setId(mockResponseScorecardId);
		when(mockRepository.save(any(ScorecardTemplate.class))).thenReturn(mockResponse);

        mockMvc.perform(MockMvcRequestBuilders.post("/scorecards/templates")
                .content(jsonRequest)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andReturn();
        
		verify(mockRepository, never()).save(any(ScorecardTemplate.class));
	}

//	@Test
	void testCreate_InvalidHoleNumber() throws Exception {
		ScorecardTemplateRequest request = createMockScorecardTemplate();
		request.getHoles().get(0).setHoleNumber(0);

		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		mapper.setSerializationInclusion(Include.NON_EMPTY);
		String jsonRequest = mapper.writeValueAsString(request);

		String mockResponseScorecardId = generateMockScorecardTemplateId();
		ScorecardTemplate mockResponse = new ScorecardTemplate();
		mockResponse.setId(mockResponseScorecardId);
		when(mockRepository.save(any(ScorecardTemplate.class))).thenReturn(mockResponse);

        mockMvc.perform(MockMvcRequestBuilders.post("/scorecards/templates")
                .content(jsonRequest)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andReturn();

		verify(mockRepository, never()).save(any(ScorecardTemplate.class));
	}

//	@Test
void testCreate_InvalidPar() throws Exception {
	ScorecardTemplateRequest request = createMockScorecardTemplate();
	request.getHoles().get(0).setPar(0);

	ObjectMapper mapper = new ObjectMapper();
	mapper.setSerializationInclusion(Include.NON_NULL);
	mapper.setSerializationInclusion(Include.NON_EMPTY);
	String jsonRequest = mapper.writeValueAsString(request);

	String mockResponseScorecardId = generateMockScorecardTemplateId();
	ScorecardTemplate mockResponse = new ScorecardTemplate();
	mockResponse.setId(mockResponseScorecardId);
	when(mockRepository.save(any(ScorecardTemplate.class))).thenReturn(mockResponse);

	mockMvc.perform(MockMvcRequestBuilders.post("/scorecards/templates")
			.content(jsonRequest)
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isBadRequest())
			.andReturn();

	verify(mockRepository, never()).save(any(ScorecardTemplate.class));
}

@Test
	public void testRetrieveAllScorecardTemplates() throws Exception {
	    when(mockRepository.findAll()).thenReturn(new ArrayList<ScorecardTemplate>());

	    mockMvc.perform(get("/scorecards/templates"))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		.andReturn();
	    
        verify(mockRepository, times(1)).findAll();
	}

	@Test
	public void testRetrieveAllScorecardTemplatesWithFilter() throws Exception {
	    when(mockRepository.findByCourseName(any(String.class))).thenReturn(new ArrayList<ScorecardTemplate>());

	    mockMvc.perform(get("/scorecards/templates?CourseName=MyFavCourse"))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		.andReturn();
	    
        ArgumentCaptor<String> templateCaptor = ArgumentCaptor.forClass(String.class);
        verify(mockRepository, times(1)).findByCourseName(templateCaptor.capture());
	}

	@Test
	public void testRetrieveScorecardTemplatesById() throws Exception {
		
	    when(mockRepository.findById(any(String.class))).thenReturn(Optional.of(new ScorecardTemplate()));

	    mockMvc.perform(get("/scorecards/templates/8482458924358"))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		.andReturn();
	    
        ArgumentCaptor<String> templateCaptor = ArgumentCaptor.forClass(String.class);
        verify(mockRepository, times(1)).findById(templateCaptor.capture());
	}

	@Test
	public void testRetrieveScorecardTemplatesByIdNoResult() throws Exception {
		
	    when(mockRepository.findById(any(String.class))).thenReturn(Optional.empty());

	    mockMvc.perform(get("/scorecards/templates/8482458924358"))
		.andExpect(status().isNotFound())
		.andReturn();
	    
        ArgumentCaptor<String> templateCaptor = ArgumentCaptor.forClass(String.class);
        verify(mockRepository, times(1)).findById(templateCaptor.capture());
	}

	private String generateMockScorecardTemplateId() {
		return "sc-1234567890";
	}

	private ScorecardTemplateRequest createMockScorecardTemplate() {
		HoleRequest holeRequest = new HoleRequest(1, TeePosition.WHITE, 500, 3);
		List<HoleRequest> holes = new ArrayList<HoleRequest>();
		holes.add(holeRequest);
		
		ScorecardTemplateRequest request = new ScorecardTemplateRequest("Central Park", holes);
		return request;
	}

	private ScorecardTemplateRequest createMockScorecardTemplateWithNegativeDistance() {
		HoleRequest holeRequest = new HoleRequest(1, TeePosition.WHITE, -100, 3);
		List<HoleRequest> holes = new ArrayList<HoleRequest>();
		holes.add(holeRequest);
		
		ScorecardTemplateRequest request = new ScorecardTemplateRequest("Central Park", holes);
		return request;
	}

}
