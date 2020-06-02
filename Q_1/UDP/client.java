import java.io.*; 
import java.net.*; 
import java.util.Scanner; 

class Client 
{ 
	public static void main(String args[]) throws IOException 
	{ 
		DatagramSocket ds = new DatagramSocket(); 
		InetAddress ip = InetAddress.getLocalHost(); 
		byte buf[] = null;
		Scanner sc = new Scanner(System.in);  
		String str = sc.nextLine();  
		buf = str.getBytes(); 
		DatagramPacket DpSend = new DatagramPacket(buf, buf.length, ip, 1234); 
		ds.send(DpSend);
		DatagramSocket dsocket = new DatagramSocket(2356); 
		byte[] receive = new byte[65535]; 
		DatagramPacket DpRcv = new DatagramPacket(receive, receive.length); 
		dsocket.receive(DpRcv); 
		System.out.println("Server :-" + data(receive)); 
	} 

	public static StringBuilder data(byte[] a) 
    	{ 
        	if (a == null) 
          		return null; 
        	StringBuilder retString = new StringBuilder(); 
        	int i = 0; 
        	while (a[i] != 0) 
        	{ 
           		ret.append((char) a[i]); 
            		i++; 
        	} 
        	return retString; 
    	}
} 