package com.benyissa.speedcamqueryservice.repositories;

import com.benyissa.speedcamqueryservice.entities.OverSpeedDetection;
import com.benyissa.speedcamqueryservice.entities.Radar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OverSpeedDetectionRepository extends JpaRepository<com.benyissa.speedcamqueryservice.entities.OverSpeedDetection,String> {

    List<OverSpeedDetection> findByRadar(Radar radar);
}
