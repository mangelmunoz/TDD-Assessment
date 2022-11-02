package com.example.TDDAnalytics.repository;

import com.example.TDDAnalytics.model.Analytic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AnalyticRepository extends JpaRepository<Analytic, Long> {

    Optional<List<Analytic>> findByDateBetween(LocalDateTime start, LocalDateTime end);
}
