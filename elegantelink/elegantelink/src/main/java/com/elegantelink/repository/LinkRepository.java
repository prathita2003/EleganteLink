package com.elegantelink.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.elegantelink.entity.LinkEntity;
import java.util.*;

public interface LinkRepository extends JpaRepository<LinkEntity,Long>
{
    Optional<LinkEntity> findByShortCode(String shortCode);    
}
