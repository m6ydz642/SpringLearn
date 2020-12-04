package chap02;

public class Gretter {
	private String format;

	public String getFormat1(String guest ) {
		return String.format(format, guest); // String.format의 %s인자때문에 반대로 받음 
										// (ex) printf("%s 님안녕", guest); 랑 같음
	}
	public String getFormat(String guest) {
		return print(guest, format);
	}
	
	public String print(String guest, String format){
		return guest + format;
	}

	public void setFormat(String format) {
		this.format = format;
	}
	
}
