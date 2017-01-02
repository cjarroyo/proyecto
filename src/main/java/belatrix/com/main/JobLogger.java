package belatrix.com.main;

import java.util.Map;
import java.util.logging.Logger;

import belatrix.com.logger.LogToConsole;
import belatrix.com.logger.LogToDatabase;
import belatrix.com.logger.LogToFile;
import belatrix.com.util.LogCompose;
import belatrix.com.util.LogType;

/**
 * Created by Cristian Arroyo on 30/12/2016
 */
public class JobLogger {
	private static boolean logToFile;
	private static boolean logToConsole;
	private static boolean logToDatabase;
	@SuppressWarnings("rawtypes")
	private static Map dbParams;
	private static Logger logger;

	@SuppressWarnings("rawtypes")
	public JobLogger(boolean logToFileParam, boolean logToConsoleParam,
			boolean logToDatabaseParam, Map dbParamsMap) throws Exception {
		
		if (!logToConsoleParam && !logToFileParam && !logToDatabaseParam) {
			throw new Exception("Invalid configuration");
		}

		logger = Logger.getLogger("MyLog");
		logToDatabase = logToDatabaseParam;
		logToFile = logToFileParam;
		logToConsole = logToConsoleParam;
		dbParams = dbParamsMap;
	}

	public void logMessage(LogType log, String message) throws Exception {
		
		//messageText.trim(); can be nullPointer if is empty
		
		if (message == null || message.length() == 0) {
			return;
		}
		

		if (log == null) {
			throw new Exception("Error or Warning or Message must be specified");
		}

		String logMessageText = LogCompose.compose(log, message);
		
		LogToFile.print(logToFile, logger, logMessageText, dbParams);
		LogToConsole.print(logToConsole, logger, logMessageText);
		LogToDatabase.print(logToDatabase, logMessageText, log.getType(),
				dbParams);
	}
}
