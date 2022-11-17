import java.sql.SQLException;
import java.util.Scanner;

public class GameApplication {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		char ch='y';
		do {
			System.out.println("enter operations\n 1.insert\n 2.update\n 3.delete\n 4.view\n");
			int opt=sc.nextInt();
			switch(opt) {
			case 1:
				GameRecordInsert ginsert=new GameRecordInsert();
				ginsert.insertGame();
				break;
			case 2:
				GameRecordUpdate gupdate=new GameRecordUpdate();
				gupdate.updateGame();
				break;
			case 3:
				GameRecordDelete gdelete=new GameRecordDelete();
				gdelete.deleteRecord();
				break;
			case 4:
				GameRecordView bview=new GameRecordView();
				bview.viewGame();
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
