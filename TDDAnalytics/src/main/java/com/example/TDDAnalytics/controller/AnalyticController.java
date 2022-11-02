package com.example.TDDAnalytics.controller;

import com.example.TDDAnalytics.model.Analytic;
import com.example.TDDAnalytics.service.AnalyticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticController {

    @Autowired
    public AnalyticService analyticService;

    @GetMapping
    public List<Analytic> getAnalytics(){
        return analyticService.getAnalytics();
    }

    @GetMapping("/{year}/{month}/{day}")
    public List<Analytic> getAnalyticByDate(@PathVariable(value = "year") Integer year,
                                            @PathVariable(value = "month") Integer month,
                                            @PathVariable(value = "day") Integer day){
        LocalDateTime date = LocalDateTime.of(year, month, day, 0,0);

        return analyticService.getAnalyticsByDate(date);
    }

    @PostMapping("/add")
    public Analytic addAnalytic(@RequestBody Analytic analytic){
        return analyticService.addAnalytic(analytic);
    }
}
