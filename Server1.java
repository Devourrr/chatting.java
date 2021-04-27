package week6day2_chatting;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server1 {
	private ServerSocket serverSocket;
	private Socket clientSocket;
	private DataInputStream dataInputStream;   
	private DataOutputStream dataOutputStream;  

	public Server1(){
		try {
			    serverSocket= new ServerSocket(6099);  
			    System.out.println("서버준비");
		        clientSocket = serverSocket.accept();
		        System.out.println("클라이언트 소켓 생성");
			    dataInputStream = new DataInputStream(clientSocket.getInputStream());
			    dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
			}catch(Exception e) {
				e.printStackTrace();
			
		}
	    dataRecv();
	    dataSend();
		
	}
	
	public void dataRecv() {			 
	     try{
	      String data= dataInputStream.readUTF();
	      System.out.println(data);
	    }catch(Exception e) {
	    	e.printStackTrace();
	   } 		      
	}

	public void dataSend(){
	   Scanner in = new Scanner(System.in);
	   try{
		    String sendData = in.nextLine();
	       dataOutputStream.writeUTF(sendData) ;
	   }catch(Exception e) {
		   e.printStackTrace();
	  }
	   in.close();
	}

	
	public static void main(String[] args) {		 
		 new Server1(); 
		   
	}
}
