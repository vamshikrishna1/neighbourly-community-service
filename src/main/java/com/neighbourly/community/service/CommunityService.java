package com.neighbourly.community.service;

import com.neighbourly.community.dto.Response;
import com.neighbourly.community.entity.Community;
import com.neighbourly.community.repository.CommunityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityService {

    CommunityRepository communityRepository;

    public Response<List<Community>> getAllCommunities(String uuid) {
        List<Community> communityList = communityRepository.findAll();
        return Response.<List<Community>>builder().uuid(uuid)
                .data(communityList)
                .build();
    }


    public Response<Community> getCommunityById(Long id) {
        Community community = communityRepository.findById(id).orElse(null);
        return Response.<Community>builder().data(community).build();
    }

}
