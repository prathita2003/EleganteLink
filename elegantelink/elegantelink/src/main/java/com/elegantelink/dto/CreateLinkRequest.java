package com.elegantelink.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
public class CreateLinkRequest 
{
        @NotBlank(message="URL cannot be empty")
        private String originalUrl;
}
