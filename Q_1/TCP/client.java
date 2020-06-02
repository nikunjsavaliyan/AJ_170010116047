import java.util.*;
import java.io.*;
import java.net.*;

public class Client
{

  private static Socket socket;

  public static void main(String args[])
  {
    try
    {
      String host = "localhost";
      InetAddress address = InetAddress.getByName(host);

      socket = new Socket(address, 3000);

      OutputStream os = socket.getOutputStream();

      OutputStreamWriter osw = new OutputStreamWriter(os);

      BufferedWriter bw = new BufferedWriter(osw);

      String inputText = "This is my text to be changed by the SERVER ";
      String sendMessage = inputText + "\n";
      bw.write(sendMessage);
      bw.flush();
      System.out.println("Message sent : "+sendMessage.trim());

      InputStream is = socket.getInputStream();
      InputStreamReader isr = new InputStreamReader(is);
      BufferedReader br = new BufferedReader(isr);
      String message = br.readLine();

      System.out.println("Message received : " +message);

    }

    catch (IOException e) {
      System.out.println("Error with sending/receiving");
    }

    catch (Exception exception)
    {
      exception.printStackTrace();
    }
    finally
    {
      try
      {
        socket.close();
      }
      catch(Exception e)
      {
        e.printStackTrace();
      }
    }
  }
}