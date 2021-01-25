package hung.com.logging;

import java.util.Set;
import java.util.logging.Logger;

import hung.com.logging.b.TestB;
import hung.com.logging.c.TestC;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;

/**
 * Đây là Vertx nên nó sẽ đọc file config mặc định:  src/main/resources/vertx-default-jul-logging.properties
 * 
 * Nhược điểm: ko show đc Line number of code trên log để jump tới (trừ trường hợp Exception) => nên dùng log4j2 cho nó tiện.
 *
 */
public class App3_vertx_logging_properties_file extends AbstractVerticle {
	
	static Logger logger = Logger.getLogger(App1_java_logging_default.class.getName());
	
	public static void main(String[] args) throws InterruptedException{
		
		//
		Vertx vertx = Vertx.vertx();
		vertx.deployVerticle(new App3_vertx_logging_properties_file()); //asynchronous call MyVerticle1.start() in worker thread
		
	}
	
	@Override
	public void start() throws Exception {
		super.start();
		
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
		
		// Vertx 4.0 Milestone5 ko hiển thị Vertx-Log => lỗi
		throw new Exception("test Exception Handler");
	}

}
