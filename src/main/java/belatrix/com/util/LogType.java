package belatrix.com.util;

/**
 * Created by Cristian Arroyo on 30/12/2016
 */
public enum LogType {
	
	MESSAGE(1, "message"), ERROR(2, "error"), WARNING(3, "warning");

	private int type;
	private String title;

	LogType(int type, String title) {
		this.type = type;
		this.title = title;
	}

	public int getType() {
		return type;
	}

	public String getTitle() {
		return title;
	}
}
