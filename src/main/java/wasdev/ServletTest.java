import java.net.*;
import java.io.*;
import java.net.URLEncoder;

public class ServletTest {
  public static void main(String[] args) throws Exception {
	String param = "Hopefully this is a successful testing of language translation POC";
	System.out.println(URLEncoder.encode(param, "UTF-8"));
    URL yahoo = new URL("https://clarkjavaliberty.mybluemix.net/SimpleServlet?content=" + URLEncoder.encode(param, "UTF-8"));
    URLConnection yc = yahoo.openConnection();
    //BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()), "UTF-8");
	InputStreamReader isr = new InputStreamReader(yc.getInputStream(), "UTF-8");
	BufferedReader in = new BufferedReader(isr);
    String inputLine;
    while ((inputLine = in.readLine()) != null) 
        System.out.println(inputLine);
    in.close();
  }
}