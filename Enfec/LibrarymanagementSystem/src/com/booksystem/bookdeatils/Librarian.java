package com.booksystem.bookdeatils;

import java.sql.Date;

import com.booksystem.Constants;

public class Librarian extends Account {
public boolean addBookItem(BookItem bookItem);

public boolean blockMember(Member member);

public boolean unBlockMember(Member member);
}

class abstract Member extends Account {
	private Date dateOfMembership;
	private int totalBooksCheckedout;
	
	public int getTotalBooksCheckedout();
	
	public boolean reserveBookItem(BookItem bookItem);
		
	private void incrementTotalBooksCheckedout();
		
	public boolean checkoutBookItem(BookItem bookItem) {
		 if (this.getTotalBooksCheckedout() >= Constants.MAX_BOOKS_ISSUED_TO_A_USER) {
		   return false;
	 }
	BookReservation bookReservation = BookReservation.fetchReservationDetails(bookItem.getBarcode());
		if (bookReservation != null && bookReservation.getMemberId() != this.getId()) {
		   return false;
		 } else if (bookReservation != null) {
		   // book item has a pending reservation from the give member, update it
		   bookReservation.updateStatus(ReservationStatus.COMPLETED);
		 }
		
		 if (!bookItem.checkout(this.getId())) {
		   return false;
		 }
		
		 this.incrementTotalBooksCheckedout();
		 return true;
		}
		
		private void Syste(String string) {
		// TODO Auto-generated method stub
		
	}

		private void checkForFine(String bookItemBarcode) {
		 BookLending bookLending = BookLending.fetchLendingDetails(bookItemBarcode);
		 Date dueDate = bookLending.getDueDate();
		 Date today = new Date();
		 // check if the book has been returned within the due date
		 if (today.compareTo(dueDate) > 0) {
		   long diff = todayDate.getTime() - dueDate.getTime();
		   long diffDays = diff / (24 * 60 * 60 * 1000);
		   Fine.collectFine(memberId, diffDays);
		 }
}

public void returnBookItem(BookItem bookItem) {
 this.checkForFine(bookItem.getBarcode());
 BookReservation bookReservation = BookReservation.fetchReservationDetails(bookItem.getBarcode());
 if (bookReservation != null) {
   // book item has a pending reservation
   bookItem.updateBookItemStatus(BookStatus.RESERVED);
   bookReservation.sendBookAvailableNotification();
 }
 bookItem.updateBookItemStatus(BookStatus.AVAILABLE);
}

public bool renewBookItem(BookItem bookItem) {
 this.checkForFine(bookItem.getBarcode());
 BookReservation bookReservation = BookReservation.fetchReservationDetails(bookItem.getBarcode());
 // check if this book item has a pending reservation from another member
 if (bookReservation != null && bookReservation.getMemberId() != this.getMemberId()) {
   ShowError("This book is reserved by another member");
   member.decrementTotalBooksCheckedout();
   bookItem.updateBookItemState(BookStatus.RESERVED);
   bookReservation.sendBookAvailableNotification();
   return false;
 } else if (bookReservation != null) {
   // book item has a pending reservation from this member
   bookReservation.updateStatus(ReservationStatus.COMPLETED);
 }
 BookLending.lendBook(bookItem.getBarCode(), this.getMemberId());
 bookItem.updateDueDate(LocalDate.now().plusDays(Constants.MAX_LENDING_DAYS));
 return true;
}
}