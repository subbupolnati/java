package com.event.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.model.Event;
import com.event.repository.EventRepo;

@Service
public class EventService {

	@Autowired
	EventRepo eventRepo;
	
	public Event bookEvent(Event event) {
		return eventRepo.save(event);
	}
	public List<Event> getALLEvents(){
		return eventRepo.findAll();
	}
	public Event updateEvent(int eventid) {
		Optional<Event> optional=eventRepo.findById(eventid);
		Event event=null;
		if(optional.isPresent()) {
			event=optional.get();
			return event;
		}
		return event;
	}
	public Event getEventById(int eventid) {
		Optional<Event> optional=eventRepo.findById(eventid);
		Event event=null;
		if(optional.isPresent()) {
			event=optional.get();
			return event;
		}
		return event;
	}
	public void deleteEvent(int eventid) {
			eventRepo.deleteById(eventid);
	}
	public List<Event> searchEventBySearchParticipantName(String participantname){
		return eventRepo.findByParticipantName(participantname);
	}
	public Event findByDate(Date endTime) {
		return eventRepo.findByEndTime(endTime);
	}
}
