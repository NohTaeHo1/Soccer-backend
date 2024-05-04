package com.aws.soccer.schedule.repository;

import com.aws.soccer.schedule.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface ScheduleJPQLRepository extends JpaRepository<Schedule, Long> {

    @Query("SELECT new map((SELECT s.stadiumName FROM Stadium s WHERE sc.stadiumId = s.stadiumId) as 경기장 ,sc.scheDate as 경기날짜) FROM Schedule sc")
    List<Map<String, Object>> findStadiumNamesByDateRange();

    @Query("SELECT new map ((SELECT s.stadiumName FROM Stadium s WHERE sc.stadiumId = s.stadiumId) as 경기장 ,sc.scheDate as 경기날짜) FROM Schedule sc WHERE sc.scheDate LIKE '201205%'")
    List<Map<String, Object>> mayStadium();
}
