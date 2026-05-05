package com.santiago.mti.eventpipeline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santiago.mti.eventpipeline.entity.WebinarEvent;

public interface WebinarEventRepository extends JpaRepository<WebinarEvent, Long> {
}
