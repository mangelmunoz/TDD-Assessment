package com.example.TDDAnalytics;

import com.example.TDDAnalytics.model.Analytic;
import com.example.TDDAnalytics.service.AnalyticService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class TddAnalyticsApplicationTests {

	@Autowired
	AnalyticService analyticService;

	@Test
	void whenGivenDate_getAnalytics_threeDaysInterval(){
		Analytic analytic = new Analytic(Long.valueOf(100), "post method", "123-123-123-123", LocalDateTime.of(2016, 06,29,0,0));
		analyticService.addAnalytic(analytic);

		List<Analytic> result = analyticService.getAnalyticsByDate(LocalDateTime.of(2016,06,29,0,0));
		List<Analytic> result2 = analyticService.getAnalyticsByDate(LocalDateTime.of(2016,06,25,0,0));

		Assertions.assertNotNull(result);
		Assertions.assertEquals(1, result.size());
		Assertions.assertEquals(0, result2.size());
	}

	@Test
	void whenGetAllAnalytics_withAnalytics_returnAnalytics(){
		Analytic analytic = new Analytic(Long.valueOf(100), "post method", "123-123-123-123", LocalDateTime.of(2016, 06,29,0,0));
		analyticService.addAnalytic(analytic);

		Assertions.assertEquals(1, analyticService.getAnalytics().size());
	}

	@Test
	void whenPostAnalytic_withAnalytic_returnAnalytic(){
		Analytic analytic = new Analytic(Long.valueOf(100), "post method", "123-123-123-123", LocalDateTime.of(2016, 06,29,0,0));
		Analytic analytic2 = analyticService.addAnalytic(analytic);

		Assertions.assertEquals(analytic.getAction(), analytic2.getAction());
		Assertions.assertEquals(analytic.getDate(), analytic2.getDate());
		Assertions.assertEquals(analytic.getUserIp(), analytic2.getUserIp());
	}

}
