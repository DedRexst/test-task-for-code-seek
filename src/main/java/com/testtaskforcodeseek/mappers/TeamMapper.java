package com.testtaskforcodeseek.mappers;


import com.testtaskforcodeseek.dtos.requests.PatchTeamDto;
import com.testtaskforcodeseek.dtos.requests.PostTeamDto;
import com.testtaskforcodeseek.dtos.responses.GetTeamDto;
import com.testtaskforcodeseek.entities.Team;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TeamMapper {
    GetTeamDto entityToDto(Team team);
    Team dtoToEntity(PostTeamDto postTeamDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(PatchTeamDto patchTeamDto, @MappingTarget Team team);
}
