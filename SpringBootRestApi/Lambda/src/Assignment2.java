import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Assignment2 {
	public static void findCount(String[] ch) {
		Map<String, Integer> charlist=new HashMap<String, Integer>();
		for(int i=0;i<ch.length;i++) {
			int count=0;
			for(int j=0;j<ch.length;j++) {
				if(ch[i]==ch[j])
					count++;
			}
			String s=ch[i];
			charlist.put(s, count);
		}
		Set s1=charlist.entrySet();
		Iterator it= s1.iterator();
		while(it.hasNext()) {
			Map.Entry<String,Integer> mp=(Entry)it.next();
			System.out.println(mp.getKey()+" occurs  "+mp.getValue());
		}
	}
	public static void main(String[] args) {
		
		String[] ch={"a", "b", "a", "f", "b", "a", "z"};
		Assignment2.findCount(ch);
	}
}
