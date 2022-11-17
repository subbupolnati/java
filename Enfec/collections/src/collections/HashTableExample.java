package collections;

import java.util.Enumeration;
import java.util.Hashtable;

public class HashTableExample {

	public static void main(String[] args) {
		Hashtable ht=new Hashtable();
		ht.put(100, 89);
		ht.put(101, 819);
		ht.put(99,85);
		ht.put(103, 200);
		ht.put(89, "subbu");
		System.out.println(""+ht);
		Enumeration e=ht.elements();
		Enumeration e1=ht.keys();
		System.out.println("values by enumertions");
		while(e1.hasMoreElements()&&e.hasMoreElements()) {
			System.out.println(e1.nextElement()+"="+e.nextElement());
		}
		

	}

}
