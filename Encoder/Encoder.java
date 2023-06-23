import java.util.Scanner;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Arrays;
import java.lang.Character;

public class Encoder {
	private char[] referenceTable = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
								 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
								 'W', 'X', 'Y', 'Z', '0', '1', '2', '3','4', '5', '6',
								 '7', '8', '9', '(', ')', '*', '+', ',', '-', '.', '/'};
	private char[] offsetTable = Arrays.copyOf(referenceTable, referenceTable.length);

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("Choose an offset character:");
		char offsetChar = in.next().toUpperCase().charAt(0);

		in.nextLine();

		System.out.println("Enter your message:");
		String inputText = in.nextLine().toUpperCase();

		Encoder encoder = new Encoder();
		encoder.offset(offsetChar);
		String outputEnText = encoder.encode(inputText);
		String outputDeText = encoder.decode(outputEnText);

		System.out.println("The encoded message is:" + outputEnText);
		System.out.println("The decoded message is:" + outputDeText);

		in.close();
	}

	public void offset (char characterInput) {
		int shiftIndex = 0;
		HashMap<Character, Integer> charIndexMap = new LinkedHashMap<>();

		for (int i = 0; i < referenceTable.length; i++) {
			charIndexMap.put(referenceTable[i], i);
		}

		if(charIndexMap.containsKey(characterInput)) {
			shiftIndex = charIndexMap.get(characterInput);
		}

		for (int i = 0; i < shiftIndex; i++) {
			char lastChar = offsetTable[offsetTable.length - 1];

			for (int j = offsetTable.length - 1; j > 0; j--) {
				offsetTable[j] = offsetTable[j - 1];
			}

			offsetTable[0] = lastChar;
		}
	}

	public String encode (String plainText) {
		StringBuilder encodedText = new StringBuilder();

		for (int i = 0; i < plainText.length(); i++) {
			char plainChar = plainText.charAt(i);
			boolean isEncoded = false;

			for (int j = 0; j < referenceTable.length; j++) {
				if (plainChar == referenceTable[j]) {
					encodedText.append(offsetTable[j]);
					isEncoded = true;
					break;				
				} else if (Character.isWhitespace(plainChar)) {
					encodedText.append(" ");
					isEncoded = true;
					break;
				}
			}

			if (!isEncoded) {
				encodedText.append(plainChar);
			}

		}

		return encodedText.toString();
	}

	public String decode (String encodedText) {
		StringBuilder decodedText = new StringBuilder();

		for (int i = 0; i < encodedText.length(); i++) {
			char encodedChar = encodedText.charAt(i);
			boolean isDecoded = false;

			for (int j = 0; j < offsetTable.length; j++) {
				if (encodedChar == offsetTable[j]) {
					decodedText.append(referenceTable[j]);
					isDecoded = true;
					break;				
				} else if (Character.isWhitespace(encodedChar)) {
					decodedText.append(" ");
					isDecoded = true;
					break;
				}
			}

			if (!isDecoded) {
				decodedText.append(encodedChar);
			}

		}

		return decodedText.toString();
	}
}