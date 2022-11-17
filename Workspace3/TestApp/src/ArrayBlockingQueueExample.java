import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueExample {

	public static void main(String[] args) throws InterruptedException {
		ArrayBlockingQueue<Integer> arrayBlockingQueue= new ArrayBlockingQueue<>(5);
		arrayBlockingQueue.put(100);
		arrayBlockingQueue.put(200);
		arrayBlockingQueue.put(300);
		arrayBlockingQueue.put(400);
		arrayBlockingQueue.put(500);
		//arrayBlockingQueue.put(600);
		System.out.println(arrayBlockingQueue.take());
		System.out.println(arrayBlockingQueue.take());
		System.out.println(arrayBlockingQueue.take());
		System.out.println(arrayBlockingQueue.take());
		System.out.println(arrayBlockingQueue.take());
		arrayBlockingQueue.put(600);
		System.out.println(arrayBlockingQueue.take());

	}

}
