package com.testtaskforcodeseek.mappers;

import com.testtaskforcodeseek.dtos.requests.PatchPlayerDto;
import com.testtaskforcodeseek.dtos.requests.PostPlayerDto;
import com.testtaskforcodeseek.dtos.responses.GetPlayerDto;
import com.testtaskforcodeseek.entities.Player;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PlayerMapper {
    GetPlayerDto entityToDto(Player player);

    Player dtoToEntity(PostPlayerDto postPlayerDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(PatchPlayerDto patchPlayerDto, @MappingTarget Player player);
}
