package com.example.TDDAnalytics.service;

import com.example.TDDAnalytics.model.Analytic;
import com.example.TDDAnalytics.repository.AnalyticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AnalyticService {

    @Autowired
    public AnalyticRepository analyticRepository;

    public List<Analytic> getAnalytics(){
        return analyticRepository.findAll();
    }

    public List<Analytic> getAnalyticsByDate(LocalDateTime localDateTime){
        return analyticRepository.findByDateBetween(localDateTime.minusDays(3), localDateTime.plusDays(3)).orElse(new ArrayList<>());
    }

    public Analytic addAnalytic(Analytic analytic){
        return analyticRepository.save(analytic);
    }
}
