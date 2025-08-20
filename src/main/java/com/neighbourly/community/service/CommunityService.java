package com.neighbourly.community.service;

import com.neighbourly.community.dto.CommunityDto;
import com.neighbourly.community.dto.HeaderInfo;
import com.neighbourly.community.dto.Response;
import com.neighbourly.community.entity.Community;
import com.neighbourly.community.exception.CommunityNotFoundException;
import com.neighbourly.community.mapper.CommunityMapper;
import com.neighbourly.community.repository.CommunityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommunityService {

    private final CommunityRepository communityRepository;
    private final CommunityMapper communityMapper;

    public Response<List<CommunityDto>> getAllCommunities(HeaderInfo headers) {
        List<Community> communityList = communityRepository.findAll();
        List<CommunityDto> communityDtoList = communityMapper.toCommunityDto(communityList);
        return Response.<List<CommunityDto>>builder().uuid(headers.getUuid())
                .data(communityDtoList)
                .build();
    }

    public Response<CommunityDto> getCommunityById(Long id) {
        Community community = communityRepository.findById(id).orElseThrow(() -> new CommunityNotFoundException("Community not found with id: " + id));
        CommunityDto communityDto = communityMapper.toCommunityDto(community);
        return Response.<CommunityDto>builder().data(communityDto).build();
    }

    public Response<CommunityDto> createCommunity(CommunityDto communityDto) {
        Community community =  communityMapper.toCommunity(communityDto);
        Community communityEntity = communityRepository.save(community);
        CommunityDto newCommunityDto =  communityMapper.toCommunityDto(communityEntity);
        return Response.<CommunityDto> builder()
                .data(newCommunityDto)
                .build();
    }

    @Transactional
    public Response<CommunityDto> updateCommunity(Long id, CommunityDto communityDto) {
        Community community = communityRepository.findById(id)
                .orElseThrow(() -> new CommunityNotFoundException("Community not found with id: " + id));
        Community updatedCommunity = communityMapper.toCommunity(communityDto, community);
        CommunityDto updatedCommunityDto = communityMapper.toCommunityDto(updatedCommunity);
        return Response.<CommunityDto>builder().data(updatedCommunityDto).build();
    }

    public void deleteCommunity(Long id) {
        communityRepository.deleteById(id);
    }
}
