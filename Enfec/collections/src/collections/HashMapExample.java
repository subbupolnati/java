package collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapExample {

	public static void main(String[] args) {
		HashMap hm=new HashMap();
		hm.put("100", "subbu");
		hm.put(45, "polnati");
		hm.put(46, 'A');
		hm.put(89,9.0880);
		System.out.println("adding elements in hashmap"+hm);
		hm.remove(46);
		System.out.println("after removing element in hashmap"+hm);
		Set hs=hm.entrySet();
		Iterator it=hs.iterator();
		System.out.println("Elements in Array");
		while(it.hasNext()) {
			Map.Entry mp=(Entry)it.next();
			System.out.println(""+mp.getKey()+"-"+mp.getValue());
		}
	}

}
