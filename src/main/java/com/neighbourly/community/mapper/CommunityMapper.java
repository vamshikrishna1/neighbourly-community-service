package com.neighbourly.community.mapper;

import com.neighbourly.community.dto.CommunityDto;
import com.neighbourly.community.entity.Community;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CommunityMapper {
    CommunityDto toCommunityDto(Community community);
    Community toCommunity(CommunityDto communityDto);
    Community toCommunity(CommunityDto communityDto, @MappingTarget Community communityEntity);

     default List<CommunityDto> toCommunityDto(List<Community> communities) {
        return communities.stream()
                .map(this::toCommunityDto)
                .collect(Collectors.toList());
    }



}
