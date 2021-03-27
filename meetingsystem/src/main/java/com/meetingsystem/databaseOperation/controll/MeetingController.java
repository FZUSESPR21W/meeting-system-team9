package com.meetingsystem.databaseOperation.controller;

import com.meetingsystem.databaseOperation.dao.MeetingDaoImpl;
import com.meetingsystem.databaseOperation.model.Meeting;
import com.meetingsystem.service.meeting.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/meeting")
public class MeetingController {

    @Autowired
    private MeetingService meetingService;

    @PostMapping("/all")
    public List<Meeting> getAllMeetings(){
        List<Meeting> meetings = meetingService.getAllMeetings();
        return meetings;
    }
}
