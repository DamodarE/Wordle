package com.javatpoint;  
import java.net.*;  
import java.io.*;  

public class wordFile{

    public static String getUrlContents(String theUrl)  
    {   
    StringBuilder content = new StringBuilder();  
    // Use try and catch to avoid the exceptions  
    try  
    {  
      URL url = new URL(theUrl); // creating a url object  
      URLConnection urlConnection = url.openConnection(); // creating a urlconnection object  
  
      // wrapping the urlconnection in a bufferedreader  
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));  
      String line;  
      // reading from the urlconnection using the bufferedreader  
      while ((line = bufferedReader.readLine()) != null)  
      {  
        content.append(line);  
      }  
      bufferedReader.close();  
    }  
    catch(Exception e)  
    {  
      e.printStackTrace();  
    }  
    return content.toString();  
  }  
}
  
    
