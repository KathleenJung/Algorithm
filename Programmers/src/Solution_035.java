//	Programmers [코딩테스트 입문] 035. 모스부호 (1)

public class Solution_035 {

	public static void main(String[] args) {
		System.out.println(solution(".... . .-.. .-.. ---"));
		System.out.println(solution(".--. -.-- - .... --- -."));
	}

	public static String solution(String letter) {
		String answer = "";
		String[] mos = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
		String[] arr = letter.split(" ");
		for (String s : arr) {
			for (int i = 0; i < mos.length; i++) {
				if(s.equals(mos[i])) {
					answer += (char) (i+'a');
				}
			}
//			if (s.equals(".-")) {
//				answer += "a";
//			} else if (s.equals("-...")) {
//				answer += "b";
//			} else if (s.equals("-.-.")) {
//				answer += "c";
//			} else if (s.equals("-..")) {
//				answer += "d";
//			} else if (s.equals(".")) {
//				answer += "e";
//			} else if (s.equals("..-.")) {
//				answer += "f";
//			} else if (s.equals("--.")) {
//				answer += "g";
//			} else if (s.equals("....")) {
//				answer += "h";
//			} else if (s.equals("..")) {
//				answer += "i";
//			} else if (s.equals(".---")) {
//				answer += "j";
//			} else if (s.equals("-.-")) {
//				answer += "k";
//			} else if (s.equals(".-..")) {
//				answer += "l";
//			} else if (s.equals("--")) {
//				answer += "m";
//			} else if (s.equals("-.")) {
//				answer += "n";
//			} else if (s.equals("---")) {
//				answer += "o";
//			} else if (s.equals(".--.")) {
//				answer += "p";
//			} else if (s.equals("--.-")) {
//				answer += "q";
//			} else if (s.equals(".-.")) {
//				answer += "r";
//			} else if (s.equals("...")) {
//				answer += "s";
//			} else if (s.equals("-")) {
//				answer += "t";
//			} else if (s.equals("..-")) {
//				answer += "u";
//			} else if (s.equals("...-")) {
//				answer += "v";
//			} else if (s.equals(".--")) {
//				answer += "w";
//			} else if (s.equals("-..-")) {
//				answer += "x";
//			} else if (s.equals("-.--")) {
//				answer += "y";
//			} else if (s.equals("--..")) {
//				answer += "z";
//			}
		}
		return answer;
	}

}
