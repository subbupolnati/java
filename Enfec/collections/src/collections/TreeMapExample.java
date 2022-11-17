package collections;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class TreeMapExample {

	public static void main(String[] args) {
		TreeMap tm=new TreeMap();
		tm.put("a", 78);
		tm.put("b", 89.542);
		tm.put("c", "subbu");
		tm.put("d",null);
		System.out.println("adding elements in treemap"+tm);
		tm.remove("d");
		System.out.println("after removing element in treemap"+tm);
		Set hs=tm.entrySet();
		Iterator it=hs.iterator();
		System.out.println("Elements in TreeMap");
		while(it.hasNext()) {
			Map.Entry mp=(Entry)it.next();
			System.out.println(""+mp.getKey()+"-"+mp.getValue());
		}

	}

}
