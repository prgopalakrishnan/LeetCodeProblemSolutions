
public class StringSplit {
	
	public static void main(String[] args) {
		String s = "0..";
		 int firstIdx = s.indexOf("\\.");
	        int lastIdx = s.lastIndexOf('.');
		String[] tokens = s.split("\\.");
		System.out.println(firstIdx);
		System.out.println(lastIdx);
		
		System.out.println(tokens.length);
	}

}
