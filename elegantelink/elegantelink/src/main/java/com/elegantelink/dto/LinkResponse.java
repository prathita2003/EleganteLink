package com.elegantelink.dto;
import java.time.LocalDateTime;
import lombok.*;

@Data
@AllArgsConstructor 
public class LinkResponse 
{
    private Long id;
    private String originalUrl;
    private String shortCode;
    private String shortUrl;
    private LocalDateTime createdAt;    
}
