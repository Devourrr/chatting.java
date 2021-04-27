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
			    serverSocket= new ServerSocket(6077);  //Ŭ���̾�Ʈ�� ������ �����ּҿ� ��Ʈ��ȣ
			    System.out.println("�����غ�");
		        clientSocket = serverSocket.accept();
		        System.out.println("Ŭ���̾�Ʈ ���� ����");
			    dataInputStream = new DataInputStream(clientSocket.getInputStream());
			    dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
			}catch(Exception e) {
				e.printStackTrace();
			
		}
	   // ������ �ޱ�
		 try{
		      String data= dataInputStream.readUTF();
		      System.out.println(data);
		    }catch(Exception e) {
		    	e.printStackTrace();
		   } 
		
		
		// ������ ������
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
