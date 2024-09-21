package com.inicio.helder.modules.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface mapperExample {

//    mapperExample INSTANCE = Mappers.getMapper(mapperExample.class);
//
//    // Mapeamento de EventDTO para EventEntity
//    @Mapping(target = "date", source = "date")
//    @Mapping(target = "holiday", constant = "false")
//    @Mapping(target = "startTime", source = "period.start")
//    @Mapping(target = "endTime", source = "period.end")
//    @Mapping(target = "description", source = "period.description")
//    @Mapping(target = "userId", source = "userId")
//    EventEntity toEntity(EventDTO dto);
//
//    // Opcionalmente, você pode criar o mapeamento inverso se necessário
//    @Mapping(target = "period.start", source = "startTime")
//    @Mapping(target = "period.end", source = "endTime")
//    @Mapping(target = "period.description", source = "description")
//    EventDTO toDTO(EventEntity entity);
}