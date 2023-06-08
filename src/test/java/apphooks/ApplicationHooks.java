package apphooks;

import java.io.IOException;

import com.utility.Utility;

import io.cucumber.java.After;
import io.cucumber.java.Before;
//import org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument.Import;

public class ApplicationHooks extends Utility {
		
	@Before()
	public void launchBrowser() throws IOException {
		Utility.launchingBrowser();
		Utility.browserMaximize();
		Utility.launchingApp();
		
	}
	
	
	
	@After()
	public void quitBrowser() {
		Utility.closingBrowser();
		report.flush();
	}
}