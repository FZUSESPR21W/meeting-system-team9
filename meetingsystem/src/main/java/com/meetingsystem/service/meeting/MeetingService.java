package com.meetingsystem.service.meeting;

import com.meetingsystem.databaseOperation.dao.MeetingDaoImpl;
import com.meetingsystem.databaseOperation.model.Meeting;

import java.util.List;

public class MeetingService {
    MeetingDaoImpl meetingDaoImpl = new MeetingDaoImpl();

    public List<Meeting> getAllMeetings(){
        List<Meeting> meetings = meetingDaoImpl.readByKey(null, null);
        return meetings;
    }
}
