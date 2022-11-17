
public class RemoveDuplicate {
	public static void removeDup(String str) {
		char[] ch=new char[str.length()];
		
		for(int i=0;i<str.length();i++) {
			int count=0;
			int j;
			for(j=0;j<=i;j++) {
				if(str.charAt(i)==str.charAt(j))
					break;
			}
			if(i==j) {
				ch[i]=str.charAt(i);
			}
		}
		for(char c:ch) {
			System.out.print(c);
		}
	}
	public static void main(String[] args) {
		removeDup("ABBCCCD");
	}
}
