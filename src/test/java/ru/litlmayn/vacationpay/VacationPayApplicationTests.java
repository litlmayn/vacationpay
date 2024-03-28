package ru.litlmayn.vacationpay;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc(printOnlyOnFailure = false)
class VacationPayApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void withoutStartDayTest() throws Exception {
		var requestBuilder = get("/calculate");
		this.mockMvc.perform(
				requestBuilder
						.param("salary", "50000")
						.param( "count_days", "28")
				).andExpectAll(
						status().isOk(),
						content().string("Сумма отпускных равна 47781,57.")
		);
	}

	@Test
	void withStartDayTest() throws Exception {
		var requestBuilder = get("/calculate");
		this.mockMvc.perform(
				requestBuilder
						.param("salary", "50000")
						.param( "count_days", "28")
						.param("day_start_vacation", "2024-02-20")
				).andExpectAll(
						status().isOk(),
						content().string("Сумма отпускных равна 44368,60.")
		);
	}


}
