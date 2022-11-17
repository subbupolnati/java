package collections;

import java.util.Iterator;
import java.util.Vector;

public class VectorExample {

	public static void main(String[] args) {
		Vector v=new Vector();
		v.add("Subbu");
		v.add(75);
		v.add('A');
		v.add(85.45661);
		v.insertElementAt(78.5, 4);
		System.out.println("adding elements in vector"+v);
		v.removeElementAt(2);
		System.out.println("after removing elemnt in vector"+v);
		Iterator i1=v.iterator();
		System.out.println("Elements in Array");
		while(i1.hasNext()) {
			System.out.println(""+i1.next());
		}
	}

}
