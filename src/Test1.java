
class Counter{
	int count;
	
	public void increment() {
		count++;
	}
}

public class Test1 {

	public static void main(String[] args) {
		Counter c = new Counter();
		
		for(int i = 1; i<=2000 ; i++) {
			c.increment();
		}
		
		System.out.println(c.count);
	}

}
