package week6day2_chatting;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server4 {

	ServerSocket serverSocket;
	Socket socket;
	
	DataInputStream dataInputStream;
	DataOutputStream dataOutputStream;
	
	public Server4() {
		
			try {
				serverSocket = new ServerSocket(6000);
				System.out.println("server readey");
				socket = serverSocket.accept();
				System.out.println("creat client socket");
				
				dataInputStream = new DataInputStream(socket.getInputStream());
				dataOutputStream = new DataOutputStream(socket.getOutputStream());
			
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
	}
	public static void main(String[] args) {
		new Server4();

	}

}
