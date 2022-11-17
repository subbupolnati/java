package BookAplication;
import java.sql.SQLException;
import java.util.Scanner;

public class BookApplication {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		char ch='y';
		do {
			System.out.println("enter operations\n 1.insert\n 2.update\n 3.delete\n 4.view\n");
			int opt=sc.nextInt();
			switch(opt) {
			case 1:
				BookRecordInsert binsert=new BookRecordInsert();
				binsert.insertBook();
				break;
			case 2:
				BookRecordUpdate bupdate=new BookRecordUpdate();
				bupdate.updateBook();
				break;
			case 3:
				BookRecordDelete bdelete=new BookRecordDelete();
				bdelete.deleteBook();
				break;
			case 4:
				BookRecordView bview=new BookRecordView();
				bview.viewBook();
				break;
			default:
				System.out.println("enter invalid option");
				break;
			}
			System.out.println("Do you Want contionue y/n");
			ch=sc.next().charAt(0);
			if (ch=='n'|| ch =='N')
				break;
		}while(ch=='y'|| ch=='Y');
	}
}
