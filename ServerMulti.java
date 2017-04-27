import java.io.*;
import java.net.*;
import java.lang.*;

public class ServerMulti implements Runnable{

	public static int portNumber = 2010;	
	
	public void run(){
		try{
			ServerSocket ss = new ServerSocket(portNumber);
			Socket s = ss.accept();
			DataInputStream dobj = new DataInputStream(s.getInputStream());
			String str = (String) dobj.readUTF();
			int num = Integer.parseInt(dobj.readUTF());
			//Sending message from Server to Client
			DataOutputStream dobj1 = new DataOutputStream( s.getOutputStream() );
			dobj1.writeUTF("Hello from Server\n");
			
			int sqr = num*num;
			System.out.println("Message from client: " +str);
			System.out.println("The square is: " +sqr);
			dobj.close();
			dobj1.close();
			ss.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}

	public static void main(String[] args){
		try{
			ServerMulti obj = new ServerMulti();
			for(int i = 0 ; i < 5 ; i++){
				Thread t = new Thread(obj);
				t.start();
				portNumber = portNumber + 1;
				t.sleep(50);
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}

}
