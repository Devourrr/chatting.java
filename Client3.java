package week6day2_chatting;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client3 {

	Socket socket;
	DataInputStream dataInputStream;
	DataOutputStream dataOutputStream;
	
	
	public Client3() {
		try {
			socket = new Socket("192.168.0.79",6000);
			System.out.println("request Server");
			
			dataInputStream = new DataInputStream(socket.getInputStream());
			dataOutputStream = new DataOutputStream(socket.getOutputStream()); 
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //접속할 대상 ip, 포트번호
	}
	
	public static void main(String[] args) {
		new Client3();

	}

}
