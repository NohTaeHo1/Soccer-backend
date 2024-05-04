package com.aws.soccer.stadium.service;

import com.aws.soccer.stadium.repository.StadiumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StadiumServiceImpl implements StadiumService {

    private final StadiumRepository repository;

}