package belatrix.com.logger;

import java.io.File;
import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Cristian Arroyo on 30/12/2016
 */
public class LogToFile {

	@SuppressWarnings("rawtypes")
	public static void print(boolean work, Logger logger, String message,
			Map dbParams) throws Exception {
		if (work) {
			String logFileName = dbParams.get("logFileFolder") + "/logFile.txt";
			File logFile = new File(logFileName);
			if (!logFile.exists()) {
				logFile.createNewFile();
			}

			FileHandler fh = new FileHandler(logFileName);
			logger.addHandler(fh);
			logger.log(Level.INFO, message);
		}
	}
}
