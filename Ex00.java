package week6day2_chatting;

class R implements Runnable{
	
	@Override
	public void run() {
		for(int i=0; i<100; i++)
	}
}

public class Ex00 {

	public static void main(String[] args) {
		
		Thread t = new Thread();
		t.start();
		for(int i=0; i<100; i++)
			System.out.println("thread="+i);
		for(int i=0; i<100; i++)
			System.out.println("main"+i);

	}

}
