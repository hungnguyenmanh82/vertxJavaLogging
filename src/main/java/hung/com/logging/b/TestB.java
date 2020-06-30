package hung.com.logging.b;

import java.util.logging.Logger;

public class TestB {

	//neu ko tim thay ten "logger1" ở log4j2.xml => thì log nay sẽ ghi ra "root" logger
	Logger logger = Logger.getLogger(TestB.class.getName());
	
	public void testLogging() {
		//ghi ra logger
		logger.finest("FINEST");
		logger.finer("FINER");
		logger.fine("FINE");
		logger.config("CONFIG");
		logger.info("INFO");
		logger.warning("WARNING");
		logger.severe("SEVERE");
		
	}
}
