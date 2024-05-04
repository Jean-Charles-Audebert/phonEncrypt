import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MultiTapConverter {

    private static final Map<Character, String> multiTapMap;

    static {
        multiTapMap = new HashMap<>();
        multiTapMap.put('a', "2");
        multiTapMap.put('b', "22");
        multiTapMap.put('c', "222");
        multiTapMap.put('d', "3");
        multiTapMap.put('e', "33");
        multiTapMap.put('f', "333");
        multiTapMap.put('g', "4");
        multiTapMap.put('h', "44");
        multiTapMap.put('i', "444");
        multiTapMap.put('j', "5");
        multiTapMap.put('k', "55");
        multiTapMap.put('l', "555");
        multiTapMap.put('m', "6");
        multiTapMap.put('n', "66");
        multiTapMap.put('o', "666");
        multiTapMap.put('p', "7");
        multiTapMap.put('q', "77");
        multiTapMap.put('r', "777");
        multiTapMap.put('s', "7777");
        multiTapMap.put('t', "8");
        multiTapMap.put('u', "88");
        multiTapMap.put('v', "888");
        multiTapMap.put('w', "9");
        multiTapMap.put('x', "99");
        multiTapMap.put('y', "999");
        multiTapMap.put('z', "9999");
        multiTapMap.put(' ', "0");
    }

    public static String encode(String text) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toLowerCase().toCharArray()) {
            if (multiTapMap.containsKey(c)) {
                result.append(multiTapMap.get(c)).append(" ");
            }
        }
        return result.toString().trim(); // Trim to remove trailing space
    }

    public static String decode(String code) {
        StringBuilder result = new StringBuilder();
        String[] tokens = code.split(" ");
        for (String token : tokens) {
            for (Map.Entry<Character, String> entry : multiTapMap.entrySet()) {
                if (entry.getValue().equals(token)) {
                    result.append(entry.getKey());
                    break;
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text to encode or decode:");
        String input = scanner.nextLine();
        System.out.println("Do you want to encode (E) or decode (D)?");
        String choice = scanner.nextLine();
        switch (choice.toUpperCase()) {
            case "E":
                System.out.println("Encoded Text: " + encode(input));
                break;
            case "D":
                System.out.println("Decoded Text: " + decode(input));
                break;
            default:
                System.out.println("Invalid choice!");
        }
        scanner.close();
    }
}
