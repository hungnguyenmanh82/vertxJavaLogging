package hung.com.logging;

import java.util.Set;
import java.util.logging.Logger;

import hung.com.logging.b.TestB;
import hung.com.logging.c.TestC;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;

/**
 * 
 * Nếu ko sẽ dùng config mặc định của Java:  C:\Program Files\Java\jdk-11.0.2\conf\logging.properties
 *  (đây ko phải là ứng dụng Vertx, nên ko dùng file config default của Vertx đc)
 * 
 * cách 1: release mode (run at commandline CMD)
 *  java -Djava.util.logging.config.file=/path/to/app.properties  –jar <jar-file-name>.jar
 * 
 * cách 2: debug F11
 *     set SystemProperties ở Pom.xml với maven-surefire-plugin 
 */
public class App1_java_logging_default{

	public static void main(String[] args) throws InterruptedException{

		Logger logger = Logger.getLogger(App1_java_logging_default.class.getName());
		
		// # SEVERE, WARNING, INFO, CONFIG, FINE, FINER, FINEST
		logger.finest("FINEST");
		logger.finer("FINER");
		logger.fine("FINE");
		logger.config("CONFIG");
		logger.info("INFO");
		logger.warning("WARNING");
		logger.severe("SEVERE");
		
		new TestB().testLogging();
		new TestC().testLogging();
	}
	


}
