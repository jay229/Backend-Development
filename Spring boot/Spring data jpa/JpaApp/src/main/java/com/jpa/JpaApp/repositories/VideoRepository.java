package com.jpa.JpaApp.repositories;

import com.jpa.JpaApp.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface VideoRepository extends JpaRepository<Video,Integer> {
}
