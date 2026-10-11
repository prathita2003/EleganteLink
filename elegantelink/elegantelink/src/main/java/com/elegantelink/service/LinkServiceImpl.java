package com.elegantelink.service;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

import com.elegantelink.dto.LinkResponse;
import com.elegantelink.entity.LinkEntity;
import com.elegantelink.repository.LinkRepository;

@Service
public class LinkServiceImpl implements LinkService
{
    private final LinkRepository lr;

    public LinkServiceImpl(LinkRepository lr)
    {
        this.lr=lr;
    }
    @Override
    public LinkResponse createShortUrl(String originalUrl)
    {
        if(!originalUrl.startsWith("http://") && !originalUrl.startsWith("https://"))
        {
            originalUrl="https://"+originalUrl;
        }
        String shortCode=UUID.randomUUID().toString().substring(0,6);
        LinkEntity link=new LinkEntity();
        link.setOriginalURL(originalUrl);
        link.setShortCode(shortCode);
        link.setCreatedAt(LocalDateTime.now());
        link=lr.save(link);
        String shortUrl="http://localhost:8080/"+link.getShortCode();

        return new LinkResponse(
            link.getId(),
            link.getOriginalURL(),
            link.getShortCode(),
            shortUrl,
            link.getCreatedAt()
        );

    }
    @Override
    public LinkResponse getLink(String shortCode) 
    {
        LinkEntity link=lr.findByShortCode(shortCode).orElseThrow(()->new RuntimeException("Short URL could not be found"));
       return toResponse(link);
    }

    @Override
    public String getOriginalUrl(String shortCode) 
    {
        LinkEntity link=lr.findByShortCode(shortCode).orElseThrow(()->new RuntimeException("Short URL not found"));

        return link.getOriginalURL();
    }

    @Override
    public void deleteLink(String shortCode) 
    {
        LinkEntity link=lr.findByShortCode(shortCode).orElseThrow(()->new RuntimeException("Short URL not found"));
        lr.deleteById(link.getId());    
    }

    @Override
    public List<LinkResponse> getAllLinks() 
    {
        List<LinkEntity> links=lr.findAll();
        return links.stream().map(this::toResponse).toList();   
    }
    
    private LinkResponse toResponse(LinkEntity link)
    {
        String shortUrl="http://localhost:8080/" +link.getShortCode();

        return new LinkResponse(
            link.getId(),
            link.getOriginalURL(),
            link.getShortCode(),
            shortUrl,
            link.getCreatedAt()
        );
    }
}
