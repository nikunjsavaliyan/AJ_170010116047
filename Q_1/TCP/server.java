import java.util.*;
import java.io.*;
import java.net.*;

public class Server
{

  private static Socket socket;

  public static void main(String[] args)
  {
    try
    {
      ServerSocket serverSocket = new ServerSocket(3000);
      System.out.println("Server Started");
      socket = serverSocket.accept();
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String inputMessage = br.readLine();
        System.out.println("Message received "+inputMessage);
        String returnMessage;

        StringBuilder input1 = new StringBuilder();
        input1.append(inputMessage);

        input1 = input1.reverse();
        String out = input1.toString();

        StringBuffer cap =  new StringBuffer(out);
        int ln = cap.length();

        for (int i=0; i<ln; i++)
         {
            Character c = cap.charAt(i);
            if (Character.isLowerCase(c))
              cap.replace(i, i+1, Character.toUpperCase(c)+"");
            else
              cap.replace(i, i+1, Character.toLowerCase(c)+"");
         }

         returnMessage = cap.toString();

        OutputStream os = socket.getOutputStream();

        OutputStreamWriter osw = new OutputStreamWriter(os);

        
        BufferedWriter bw = new BufferedWriter(osw);

        bw.write(returnMessage);

        System.out.println("Message "+returnMessage);
        bw.flush();
    }

    catch (IOException e) {
      System.out.println("Error with sending/receiving");
    }
    
    catch (Exception e)
    {
      e.printStackTrace();
    }
    finally
    {
      try
      {
        socket.close();
      }
      catch(Exception e){}
    }
  }
}