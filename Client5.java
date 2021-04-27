package week6day2_chatting;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client5 {
	private Socket clientSocket;
	private DataInputStream dataInputStream; //������ �޴� ���
	private DataOutputStream dataOutputStream; //������ ������ ���
	
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
			
			
		
		//������ ������
			Scanner in = new Scanner(System.in);
			
			try {
				String sendData = in.nextLine();
				dataOutputStream.writeUTF(sendData);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			in.close();
			//������ �ޱ�
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
