package chap02;

public class Gretter {
	private String format;

	public String getFormat(String guest) {
		// System.out.println("호출된 aurgument : " + String.format(format));
		return String.format(format, guest);
	}

	public void setFormat(String format) {
		this.format = format;
	}
	
}
