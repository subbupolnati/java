package com.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.event.ExceptionHandling.EventNotFoundException;
import com.event.model.Event;
import com.event.model.Venue;
import com.event.service.EventService;
import com.event.service.VenueService;

@SpringBootTest
class EventManagementSystemApplicationTests {
	Venue venue=new Venue(1,"SSConvention","Rk Beach Road","vizag","ap","536455");
	Event event=new Event(1,"Wedding",new Date(2022-10-04),new Date(2022-10-04),"subbu","9951933459",150,venue);
	Event e;
	EventService es=Mockito.mock(EventService.class);
	VenueService vs=Mockito.mock(VenueService.class);
	ArrayList<Event> eList=new ArrayList<Event>();
	ArrayList<Venue> vList=new ArrayList<Venue>();
	@BeforeEach
	void init() {
		eList.add(event);
		vList.add(venue);
	}
	@Test
	void sameEventObjects() {
		Event e=event;
		assertSame(event,e);
	}
	@Test
	void comapareTwoEventObjects() {
	assertEquals(event,event);
	}
	@Test
	void ObjectNotEqulas() {
	assertNotEquals("event","venue");
	}
	@Test
	void gettingParticipentName() {
		assertEquals(event.getParticipantName(),"subbu");
	}
	@Test
	void CheckingNullPointerException() {
		assertThrows(NullPointerException.class,()->e.getEventName());
	}
	@Test
	void compareEventName() {
		assertSame("Wedding",event.getEventName());
	}
	@Test
	void notNull() {
		assertNotNull(event.getEventName());
	}
	@Test
	void checkingTrueOrFlase() {
		assertTrue(event.getEventid()==1);
	}
	@Test
	void checkingFlase() {
		assertFalse(event.getEventName().equals("birthday"));
	}
	@Test
	void checkingListSize() {
		assertTrue(eList.size()==1);
	}
	//Mockito TestCases
	
	@Test
	void addingEvent() {
		when(es.bookEvent(event)).thenReturn(event);
	}
	@Test
	void checkingException() {
		doThrow(new EventNotFoundException("not found")).when(es).searchEventBySearchParticipantName("veera");
	}
	@Test
	void addingVenue() {
		when(vs.addVenue(venue)).thenReturn(venue);
	}
	@Test
	void geetingEventsUsing() {
		es.getALLEvents();
		verify(es,times(1)).getALLEvents();
	}
	@Test
	void eventListReturn() {
	doReturn(eList).when(es).getALLEvents();
	
	}
	@Test
	void callingMethodUsigNever() {
	verify(vs,never()).updateVenue(1);
	}
	@Test
	void usingAtLeastMethod() {
		when(vs.getAllVenues()).thenReturn(vList);
		assertEquals(vList,vs.getAllVenues());
		verify(vs,atLeast(1)).getAllVenues();
	}
	@Test
	void usingAtMostMethod() {
		when(vs.getAllVenues()).thenReturn(vList);
		assertEquals(vList,vs.getAllVenues());
		assertEquals(vList,vs.getAllVenues());
		assertEquals(vList,vs.getAllVenues());
		verify(vs,atMost(3)).getAllVenues();
	}
	@Test
	void listSize() {
		when(vs.getAllVenues()).thenReturn(vList);
		assertEquals(1,vList.size());
	}
	@Test
	void returnList() {
		doReturn(eList).when(es).searchEventBySearchParticipantName("subbu");
	}
}
