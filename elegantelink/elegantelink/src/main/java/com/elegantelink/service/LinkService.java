package com.elegantelink.service;
import com.elegantelink.dto.LinkResponse;
import java.util.*;

public interface LinkService 
{
    LinkResponse createShortUrl(String originalUrl);
    String getOriginalUrl(String shortCode);
    LinkResponse getLink(String shortCode);
    void deleteLink(String shortCode);
    List<LinkResponse> getAllLinks();
}
