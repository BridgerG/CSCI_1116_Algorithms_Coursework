package chapter24_05;

public class Chapter24_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyGenericQueue<String> a = new MyGenericQueue<String>();
		
		a.enqueue("A tree");
		a.enqueue("Two trees");
		a.enqueue("THREE TREES?!");
		
		while(a.size() > 0) {
			System.out.println(a.dequeue());
		}

	}

}
