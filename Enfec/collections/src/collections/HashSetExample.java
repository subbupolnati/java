package collections;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample {

	public static void main(String[] args) {
		HashSet hs=new HashSet();
		hs.add("Subbu");
		hs.add(52);
		hs.add(89.52);
		hs.add('A');
		System.out.println("hash list id"+hs);
		hs.remove(52);
		System.out.println("after removing elemnet "+hs);
		Iterator i1=hs.iterator();
		System.out.println("Elements in Array");
		while(i1.hasNext()) {
			System.out.println(""+i1.next());
		}
	}

}
