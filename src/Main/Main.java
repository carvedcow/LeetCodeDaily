package Main;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// Task 1
		//System.out.println(toGoatLatin("I speak Goat Latin"));
		
		// Task 2
		int[] nums = new int[] {2, 7, 11, 15};
		Arrays.stream(twoSum(nums, 9)).forEach(System.out::println);
		
		// Task 3
		System.out.println(reverse(123));
	}

	/*	Task 1
	  
	 	A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.

		We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)

		The rules of Goat Latin are as follows:

		If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
		For example, the word 'apple' becomes 'applema'.

		If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
		For example, the word "goat" becomes "oatgma".

		Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
		For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
		Return the final sentence representing the conversion from S to Goat Latin.

		Input: "I speak Goat Latin"
		Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"

		Input: "The quick brown fox jumped over the lazy dog"
		Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"

		S contains only uppercase, lowercase and spaces. Exactly one space between each word.
		1 <= S.length <= 150.
	 */
	
	public static String toGoatLatin(String S) {
		Set<Character> vowel = new HashSet<Character>();
		for (char c: new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'})
			vowel.add(c);

		int t = 1;
		StringBuilder ans = new StringBuilder();
		for (String word: S.split(" ")) {
			char first = word.charAt(0);
			if (vowel.contains(first)) {
				ans.append(word);
			} else {
				ans.append(word.substring(1));
				ans.append(word.substring(0, 1));
			}
			ans.append("ma");
			for (int i = 0; i < t; i++)
				ans.append("a");
			t++;
			ans.append(" ");
		}

		ans.deleteCharAt(ans.length() - 1);
		return ans.toString();
	}

	/*	Task 2
	 * 
	 * 	Given an array of integers, return indices of the two numbers such that they add up to a specific target.

		You may assume that each input would have exactly one solution, and you may not use the same element twice.
	 *  Given nums = [2, 7, 11, 15], target = 9,

		Because nums[0] + nums[1] = 2 + 7 = 9,
		return [0, 1].
	 * */
	public static int[] twoSum(int[] nums, int target) {
		// Values
		int[] result = new int[2];
		
		// Methods
		for (int i = 0; i < nums.length - 1 ; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					result[0] = i;
					result[1] = j;
				}
			}
		}
		return result;
	}
	
	// Task 3
	/* Reverse an Integer
	 * int x = 123 -> x = 321
	 * */
	
	public static int reverse(int x) {
		
		// Values
		int result = 0;
        
		// Methods
        while (x != 0){
        	
            int lastDigit = x % 10;
            
            result = result * 10 + lastDigit;
            x = x / 10;
            
        }
        return result;
    }
    


}
