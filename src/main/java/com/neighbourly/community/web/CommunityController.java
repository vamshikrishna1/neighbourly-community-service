package com.neighbourly.community.web;

import com.neighbourly.community.dto.CommunityDto;
import com.neighbourly.community.dto.HeaderInfo;
import com.neighbourly.community.dto.Response;
import com.neighbourly.community.service.CommunityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/communities")
@RequiredArgsConstructor
public class CommunityController {

    private final CommunityService communityService;

    @GetMapping
    public ResponseEntity<Response<List<CommunityDto>>> getAllCommunities(HeaderInfo headers) {
        Response<List<CommunityDto>> response =  communityService.getAllCommunities(headers);
    return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<CommunityDto>> getCommunityById(@PathVariable Long id, HeaderInfo headers) {
        Response<CommunityDto> response = communityService.getCommunityById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Response<CommunityDto>>  createCommunity(@RequestBody CommunityDto community, HeaderInfo headers) {
        Response<CommunityDto> communityDto = communityService.createCommunity(community);
        return ResponseEntity.ok(communityDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<CommunityDto>> updateCommunity(@PathVariable Long id, @RequestBody CommunityDto community, HeaderInfo headers) {
        Response<CommunityDto> communityDto =  communityService.updateCommunity(id, community);
        return ResponseEntity.ok(communityDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommunity(@PathVariable Long id, HeaderInfo headers) {
        communityService.deleteCommunity(id);
        return ResponseEntity.noContent().build();
    }
}