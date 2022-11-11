package screenshot_Api;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String customerKey="";
		//get the key from a external file
		try {
			BufferedReader br = new BufferedReader(new FileReader("./key.txt"));
			customerKey = br.readLine();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	    String secretPhrase = "";//leave secret phrase empty, if not needed
		
		Map <String, String> targetWebs = new HashMap<String, String>();
		
		targetWebs.put("iFunded" , "https://ifunded.de/en/");
		targetWebs.put("Property Partner" , "www.propertypartner.co");
		targetWebs.put("Property Moose" , "propertymoose.co.uk");
		targetWebs.put("Homegrown" , "www.homegrown.co.uk");
		targetWebs.put("Realty Mogul" , "https://www.realtymogul.com");
		
		for(Entry <String,String> targetWeb : targetWebs.entrySet()) {			
			Client c = new Client();
			try {
				c.client(customerKey, secretPhrase, targetWeb.getValue(), targetWeb.getKey());
			} catch (NoSuchAlgorithmException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try
		{ 
		 // We are running Quickstart on cmd
		 Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"cd ../Quickstart && gradle run \"");
		}
		catch (Exception e)
		{
		    System.out.println("Something Wrong ");
		    e.printStackTrace();
		}

	}

}
