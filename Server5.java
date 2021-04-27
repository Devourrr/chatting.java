package week6day2_chatting;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server5 {

	private ServerSocket serverSocket;
	private Socket clientSocket;
	private DataInputStream dataInputStream;
	private DataOutputStream dataOutputStream;
	
	public Server5() {
		try {
			serverSocket = new ServerSocket(6077); //생성, 바인딩
			System.out.println("server ready");
			clientSocket = serverSocket.accept();
			System.out.println("create client socket");
			dataInputStream = new DataInputStream(clientSocket.getInputStream());
			dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		try {
			String data = dataInputStream.readUTF();
			System.out.println(data);
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

				
	}
	
	
	
	public static void main(String[] args) {
	
		new Server5();

	}

}
