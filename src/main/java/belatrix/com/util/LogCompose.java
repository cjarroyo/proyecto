package belatrix.com.util;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.util.Date;

/**
 * Created by Cristian Arroyo on 30/12/2016
 */
public class LogCompose {
	
	public static String compose(LogType type, String msg) {
		return MessageFormat.format("{0}\t{1}\t{2}", type.getTitle(),
				DateFormat.getDateInstance(DateFormat.LONG).format(new Date()),
				msg);
	}
}
