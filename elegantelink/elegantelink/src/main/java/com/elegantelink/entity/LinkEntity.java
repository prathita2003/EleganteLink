package com.elegantelink.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkEntity 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String originalURL;

    @Column(nullable=false, unique=true)
    private String shortCode;

    @Column(nullable=false)
    private LocalDateTime createdAt;
}
