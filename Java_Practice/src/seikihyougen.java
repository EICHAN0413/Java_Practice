


public class seikihyougen {
	
	public static void main(String[] atgs) {
		// 連続する文字列を1文字に置き換える
		String input = "Ahkfh--ha----adk-jkaKaAo-UDE------IIL";
		String output = input.replaceAll("-{2,}", "-");
		System.out.println(output);
	}
	
}
