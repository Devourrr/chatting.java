package week6day2_chatting;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client5 {
	private Socket clientSocket;
	private DataInputStream dataInputStream; //데이터 받는 통로
	private DataOutputStream dataOutputStream; //데이터 보내는 통로
	
	public  Client5() {
			try {
				clientSocket = new Socket("192.168.0.79",6077);
				System.out.println("request server");
				
				dataInputStream = new DataInputStream(clientSocket.getInputStream());
				dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		
		//데이터 보내기
			Scanner in = new Scanner(System.in);
			
			try {
				String sendData = in.nextLine();
				dataOutputStream.writeUTF(sendData);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			in.close();
			//데이터 받기
			String data;
			try {
				data = dataInputStream.readUTF();
				System.out.println(data);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static void main(String[] args) {
		new Client5();

	}

}
