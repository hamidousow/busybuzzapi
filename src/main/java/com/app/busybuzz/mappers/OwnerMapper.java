package com.app.busybuzz.mappers;

import com.app.busybuzz.dto.owner.OwnerDto;
import com.app.busybuzz.models.Owner;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OwnerMapper {

    OwnerMapper INSTANCE = Mappers.getMapper(OwnerMapper.class);
    Owner OwnerDtoToOwner(OwnerDto ownerdto);
}
