package com.aws.soccer.schedule.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aws.soccer.schedule.model.Schedule;

@Repository
public interface ScheduleRepository extends ScheduleJPQLRepository {



    
} 