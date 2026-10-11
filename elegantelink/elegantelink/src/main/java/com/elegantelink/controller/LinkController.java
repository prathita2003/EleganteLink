package com.elegantelink.controller;

import com.elegantelink.dto.CreateLinkRequest;
import com.elegantelink.service.LinkService;
import com.elegantelink.dto.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import java.util.*;


@RestController
@RequestMapping("/api/links")
@CrossOrigin(origins="http://localhost:5173")
public class LinkController 
{
    private final LinkService ls;

    public LinkController(LinkService ls)
    {
        this.ls=ls;
    }

    @PostMapping
    public LinkResponse createShortUrl(@RequestBody CreateLinkRequest req)
    {
        return ls.createShortUrl(req.getOriginalUrl());
    }

    @GetMapping("/{shortCode}")
    public LinkResponse getLink(@PathVariable String shortCode)
    {
        return ls.getLink(shortCode);
    }

    @GetMapping
    public List<LinkResponse> getAllLinks()
    {
        return ls.getAllLinks();
    }

    @DeleteMapping("/{shortCode}")
    public ResponseEntity<String> deleteLink(@PathVariable String shortCode)
    {
        ls.deleteLink(shortCode);
        return ResponseEntity.ok("URL deleted successfully");
    }
}
