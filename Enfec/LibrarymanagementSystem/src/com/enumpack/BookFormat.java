package com.enumpack;

public enum BookFormat {

	  HARDCOVER,
	  PAPERBACK,
	  AUDIO_BOOK,
	  EBOOK,
	  NEWSPAPER,
	  MAGAZINE,
	  JOURNAL
	}

enum BookStatus {
	  AVAILABLE,
	  RESERVED,
	  LOANED,
	  LOST
	}

enum ReservationStatus{
	  WAITING,
	  PENDING,
	  CANCELED,
	  NONE
	}

enum AccountStatus{
	  ACTIVE,
	  CLOSED,
	  CANCELED,
	  BLACKLISTED,
	  NONE
}
