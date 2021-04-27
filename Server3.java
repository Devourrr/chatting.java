package week6day2_chatting;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server3 {

	ServerSocket serverSocket; //서버소켓
	Socket socket; //소켓(클라이언트와 통신할 수 있는 소켓)
	
	DataInputStream dataInputStream;
	DataOutputStream dataOutputStream;
	
	public Server3() {
		try {
			serverSocket = new ServerSocket(6000);
			System.out.println("Server reday");
			socket = serverSocket.accept();
			System.out.println("create Client Socket");
			
			dataInputStream = new DataInputStream(socket.getInputStream());
			dataOutputStream = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
//		Server3 s =new Server3();
		new Server3(); //익명 객체
		

	}

}
