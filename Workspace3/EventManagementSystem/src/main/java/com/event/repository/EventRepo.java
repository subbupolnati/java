package com.event.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.event.model.Event;

@Repository
public interface EventRepo extends JpaRepository<Event,Integer> {

	public List<Event> findByParticipantName(String participantName);
	public Event findByEndTime(Date endTime);
}
