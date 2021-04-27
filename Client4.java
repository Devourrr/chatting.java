package week6day2_chatting;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client4 {
	Socket socket;
	DataInputStream dataInputStream;
	DataOutputStream dataOutputStream;
	
	public Client4() {
		try {
			socket = new Socket("192.168.0.79",6000);
			System.out.println("request Server");
			
			dataInputStream = new DataInputStream(socket.getInputStream());
			dataOutputStream = new DataOutputStream(socket.getOutputStream());
		
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		//데이터 보내기
		Scanner sc = new Scanner (System.in);
		String msg = sc.nextLine();
		try {
			dataOutputStream.writeUTF(msg); //데이터 송출
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		//데이터 받기
		String receiver;
		try {
			receiver = dataInputStream.readUTF();
			System.out.println(receiver); //데이터수신
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
		
	}
	

	public static void main(String[] args) {
		new Client4();
	
		
		

	}

}
