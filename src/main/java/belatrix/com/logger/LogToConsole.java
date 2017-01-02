package belatrix.com.logger;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Cristian Arroyo on 30/12/2016
 */
public class LogToConsole {
	
	public static void print(boolean work, Logger logger, String message)
			throws Exception {
		if (work) {
			ConsoleHandler ch = new ConsoleHandler();
			logger.addHandler(ch);
			logger.log(Level.INFO, message);
		}
	}
}
