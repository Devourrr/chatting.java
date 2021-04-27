package week6day2_chatting;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
public class Client2 {

	private Socket clientSocket;
	   private DataInputStream dataInputStream;   
	   private DataOutputStream dataOutputStream;  


	   public Client2(){

			try {
				 clientSocket= new Socket("192.168.0.106", 6077);
		         System.out.println("서버요청");
		         dataInputStream = new DataInputStream(clientSocket.getInputStream());
				 dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		   
		      // 
		      Scanner in = new Scanner(System.in);			
			   try{
				   String sendData = in.nextLine();
			       dataOutputStream.writeUTF(sendData) ;
			   }catch(Exception e) {
				   e.printStackTrace();
			  }
			   in.close();
			   
			 // 
				  String data;
				try {
					data = dataInputStream.readUTF();
					System.out.println(data);
				} catch (IOException e1) {
					 
					e1.printStackTrace();
				}
			      
		   
		}

		
				 
	public static void main(String[] args) {
		 
		new Client2();

	}

}
