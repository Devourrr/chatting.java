package week6day2_chatting;
//interface Runnable{
//	void run();
//}
class R implements Runnable{
	public void run() {
		for(int i=0; i<100; i++)
		System.out.println("thread="+i);
	}
}
public class Ex01 {

	public static void main(String[] args) {
		Thread th = new Thread(new R() {
			@Override
			public void run() {
				for(int i=0; i<100;i++) {
					System.out.println("thread"+i);
				}
		
		}
	});
		th.start(); //������ ���� ��û
		
		for(int i=0; i<100; i++)
			System.out.println("main"+ i);

	}

}
