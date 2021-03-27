package com.meetingsystem.mapper;


import com.meetingsystem.databaseOperation.model.Meeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MeetingMapper {
    public List<Meeting> getAllMeetings();


}
