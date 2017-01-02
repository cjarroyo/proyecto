package logger;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;

import belatrix.com.main.JobLogger;
import belatrix.com.util.LogType;

/**
 * Created by Cristian Arroyo on 30/12/2016
 */
public class JobLoggerTest {
	private final Logger log = Logger.getLogger(JobLoggerTest.class.getName());

	//any Logtype
	@Test(expected = Exception.class)
	public void test01() throws Exception {
		try {
			JobLogger logger = new JobLogger(false, false, false, null);
			logger.logMessage(LogType.MESSAGE, "Test01");
		} catch (Exception e) {
			log.info("Exception in test01: " + e.getMessage());
			Assert.assertSame("Invalid configuration", e.getMessage());
			throw e;
		}
	}

	//any message
	@Test(expected = Exception.class)
	public void test02() throws Exception {
		try {
			JobLogger logger = new JobLogger(true, true, true, null);
			logger.logMessage(null, "Test02");
		} catch (Exception e) {
			log.info("Exception in test02: " + e.getMessage());
			Assert.assertSame("Error or Warning or Message must be specified",
					e.getMessage());
			throw e;
		}
	}

	@Test
	public void test03() throws Exception {
		JobLogger logger = new JobLogger(true, true, true, null);
		logger.logMessage(null, "");
	}
	//file
	@Test
	public void test04() throws Exception {
		Map<String, Object> params = new HashMap<>();
		params.put("logFileFolder", "/Temp");
		JobLogger logger = new JobLogger(true, false, false, params);
		logger.logMessage(LogType.WARNING, "Test04");
	}
	//console
	@Test
	public void test05() throws Exception {
		JobLogger logger = new JobLogger(false, true, false, null);
		logger.logMessage(LogType.ERROR, "Test05");
	}
	//connection
	@Test(expected = SQLException.class)
	public void test06() throws Exception {
		Map<String, Object> params = new HashMap<>();
		params.put("userName", "test");
		params.put("password", "test");
		params.put("dbms", "test");
		params.put("serverName", "localhost");
		params.put("portNumber", "3306");
		JobLogger logger = new JobLogger(false, false, true, params);
		logger.logMessage(LogType.MESSAGE, "Test06");
	}
}
