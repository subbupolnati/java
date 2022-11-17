
class Author
{
	int author_id;
	String author_name;
	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	public String getAuthor_name() {
		return author_name;
	}
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	public Author(int author_id, String author_name) {
		super();
		this.author_id = author_id;
		this.author_name = author_name;
	}
	@Override
	public String toString() {
		return "Author [author_id=" + author_id + ", author_name=" + author_name + "]";
	}
	
}
public class BookDeatails {


	int book_id;
	String book_name;
	
	Author auth;
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	
	public Author getAuth() {
		return auth;
	}
	public void setAuth(Author auth) {
		this.auth = auth;
	}
	public BookDeatails(int book_id, String book_name, Author auth) {
		super();
		this.book_id = book_id;
		this.book_name = book_name;
		this.auth = auth;
	}
	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", book_name=" + book_name + ",auth=" + auth + "]";
	}
	
}
