
class Counter{
	int count;
	
	// burada thread safe saglamak icin synchronized i kullanabiliriz. 
	// boylelikle ayni anda birden fazla thread degisilik yapmayacaktir.
	// bunun disinda atomicinteger kullanarakta thread safe yapabiliriz.
	public synchronized void increment() {
		count++;
	}
}

public class Test1 {

	public static void main(String[] args) throws Exception{
		Counter c = new Counter();
		
		Thread t1 = new Thread(new Runnable()
				{
					public void run(){
						for(int i = 1; i<=1000 ; i++) {
							c.increment();
						}
					}
				}
		);
		
		Thread t2 = new Thread(new Runnable()
				{
					public void run(){
						for(int i = 1; i<=1000 ; i++) {
							c.increment();
						}
					}
				}
		);
		
		t1.start();
		t2.start();
		
		t1.join(); 
		t2.join();
		
		System.out.println(c.count);
		System.out.println("Test");
		System.out.println("Test2");
	}

}
