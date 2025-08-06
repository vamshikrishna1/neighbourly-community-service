package com.neighbourly.community.web;

import com.neighbourly.community.dto.CommunityDto;
import com.neighbourly.community.dto.Response;
import com.neighbourly.community.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/communities")
public class CommunityController {

    @Autowired
    private CommunityService communityService;

    @GetMapping
    public ResponseEntity getAllCommunities(@RequestHeader String uuid) {
        Response response =  communityService.getAllCommunities(uuid);
    return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCommunityById(@PathVariable Long id) {
        Response response = communityService.getCommunityById(id);
        return ResponseEntity.ok(response);
    }

//    @PostMapping
//    public CommunityDto createCommunity(@RequestBody CommunityDto community) {
//        return communityService.createCommunity(community);
//    }
//
//    @PutMapping("/{id}")
//    public CommunityDto updateCommunity(@PathVariable Long id, @RequestBody CommunityDto community) {
//        return communityService.updateCommunity(id, community);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteCommunity(@PathVariable Long id) {
//        communityService.deleteCommunity(id);
//    }
}