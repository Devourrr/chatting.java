package week6day2_chatting;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class Server2 {
	private ServerSocket serverSocket;
	private Socket clientSocket;
	private DataInputStream dataInputStream;   //
	private DataOutputStream dataOutputStream;  //

	public Server2(){
		try {
			    serverSocket= new ServerSocket(6077);  //클라이언트가 접속할 서버주소와 포트번호
			    System.out.println("서버준비");
		        clientSocket = serverSocket.accept();
		        System.out.println("클라이언트 소켓 생성");
			    dataInputStream = new DataInputStream(clientSocket.getInputStream());
			    dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
			}catch(Exception e) {
				e.printStackTrace();
			
		}
	   // 데이터 받기
		 try{
		      String data= dataInputStream.readUTF();
		      System.out.println(data);
		    }catch(Exception e) {
		    	e.printStackTrace();
		   } 
		
		
		// 데이터 보내기
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
		 new Server2(); 
		   
	}
}
