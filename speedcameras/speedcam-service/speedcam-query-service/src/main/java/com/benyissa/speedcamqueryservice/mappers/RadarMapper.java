package com.benyissa.speedcamqueryservice.mappers;


import com.benyissa.commonapi.*;
import com.benyissa.speedcamqueryservice.entities.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RadarMapper {
    Radar fromRadarD(RadarDTO radarDTO) ;
    RadarDTO from (Radar radar);

    OverSpeedDetection from (OverSpeedRequestDTO overSpeedRequestDTO);

}
