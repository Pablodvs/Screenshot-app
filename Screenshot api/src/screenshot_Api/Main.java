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

		
		//Arrays to iterate with
		String []	wNames = {"iFunded", "Property Partner", "Property Moose","Homegrown", "Realty Mogul"};
		String []	websites = {"https://ifunded.de/en/", "www.propertypartner.co", "propertymoose.co.uk",
				"www.homegrown.co.uk", "https://www.realtymogul.com"};
		for (int i =0; i<websites.length;i++) {
			Client c = new Client();
			try {
				c.client(customerKey, secretPhrase, websites[i], wNames[i] );
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
