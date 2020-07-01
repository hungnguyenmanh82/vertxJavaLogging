package hung.com.logging;

import java.io.FileInputStream;
import java.util.Set;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import hung.com.logging.b.TestB;
import hung.com.logging.c.TestC;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;

/**
 * 
 * java –jar <jar-file-name>.jar  -Djava.util.logging.config.file=/path/to/app.properties
 *
 * Nếu ko sẽ dùng config mặc định của Java:  C:\Program Files\Java\jdk-11.0.2\conf\logging.properties
 *  (đây ko phải là ứng dụng Vertx, nên ko dùng file config default của Vertx đc)
 *  
 */
public class App2_java_logging_properties_file extends AbstractVerticle {

	public static void main(String[] args) throws Exception{
		
		/**
		 * lúc compile sẽ gộp "main/resources/" và "main/java/" vào 1 folder chung
		 App81_https_Server.class.getResource("/") = root = main/resources/ = main/java/
		 App81_https_Server.class.getResource("/abc") = main/resource/abc  = main/java/abc  
		 //
		 App81_https_Server.class.getResource(".") = root/pakage_name/     => package_name của class này
		 App81_https_Server.class.getResource("abc") = root/pakage_name/abc
		 App81_https_Server.class.getResource("abc").getPath()
		 //
		   App81_https_Server.class.getResource("..") = parent folder of root/pakage_name/
		   App81_https_Server.class.getResource("../..") = parent of parent of root/pakage_name/  
		  //===========================
		  + Run or Debug mode trên Eclipse lấy ./ = project folder 
		  
		  + run thực tế:  ./ = folder run "java -jar *.jar"
		 //========= 
		 File("loginTest.json"):   file ở ./ folder    (tùy run thực tế hay trên eclipse)
		 File("./abc/test.json"):   
		 File("/abc"): root folder on linux (not window)
		 */
		
		// file logging config cho app nay
		FileInputStream fis =  new FileInputStream(App2_java_logging_properties_file.class.getResource("/logging.properties").getPath());
		LogManager.getLogManager().readConfiguration(fis);

		Logger logger = Logger.getLogger(App2_java_logging_properties_file.class.getName());

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
