package com.aws.soccer.schedule.repository;

import com.aws.soccer.schedule.model.ScheduleDTO;

import java.util.List;

public interface ScheduleDAO {

    List<ScheduleDTO> getAllSchedule();

}
