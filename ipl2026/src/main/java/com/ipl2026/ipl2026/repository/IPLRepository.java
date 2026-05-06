package com.ipl2026.ipl2026.repository;

import com.ipl2026.ipl2026.entity.IPL2026;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPLRepository extends JpaRepository<IPL2026, Integer> {

    List<IPL2026> findTop5ByOrderByNrrDesc();

    List<IPL2026> findByNrrGreaterThan(Float nrr);

    List<IPL2026> findByNoOfMatchesWonGreaterThan(Integer wins);

    List<IPL2026> findByNoOfMatchesPlayedGreaterThan(Integer matches);

}
