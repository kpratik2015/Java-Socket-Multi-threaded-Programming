import java.io.*;
import java.net.*;
import java.lang.*;

public class ClientMulti implements Runnable{
	
	public static int portNumber = 2010;
	
	public void run(){
		try{
			Socket s = new Socket("127.0.0.1", portNumber);
			DataOutputStream dobj = new DataOutputStream(s.getOutputStream());
			dobj.writeUTF("Hello Server from Client with port " +portNumber);
			dobj.writeUTF("4");
			DataInputStream dobj1 = new DataInputStream(s.getInputStream());
			//Reading message from Server
			String str = (String) dobj1.readUTF();
			System.out.println(str);
			
			dobj.close();
			dobj1.close();
			s.close();
		} catch(Exception e){
			System.out.println(e);
		}
	}

	public static void main(String []args){
		try{
			ClientMulti obj = new ClientMulti();
			
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
