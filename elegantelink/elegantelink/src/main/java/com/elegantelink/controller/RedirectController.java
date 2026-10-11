package com.elegantelink.controller;

import com.elegantelink.service.LinkService;
import java.net.URI;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class RedirectController 
{
    private final LinkService ls;
    
    public RedirectController(LinkService ls)
    {
        this.ls=ls;
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirectToOriginalUrl(@PathVariable String shortCode)
    {
        String originalURL=ls.getOriginalUrl(shortCode);
        return ResponseEntity
        .status(HttpStatus.FOUND)
        .location(URI.create(originalURL))
        .build();
    }
}
