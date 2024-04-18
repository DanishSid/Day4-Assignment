import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class combinationgenerator{
    private static final Map<Character, char[]> digitToValues = new HashMap<>();

    // Initialize the map
    static {
        digitToValues.put('1', new char[]{'Z', 'Y', 'A'});
        digitToValues.put('2', new char[]{'B', 'O'});
        digitToValues.put('3', new char[]{'U', 'P'});
        digitToValues.put('12', new char[]{'L'});
    }

    public static List<String> generateCombinations(String input) {
        List<String> combinations = new ArrayList<>();
        generate(input, 0, "", combinations);
        return combinations;
    }

    private static void generate(String input, int index, String current, List<String> combinations) {
        if (index == input.length()) {
            combinations.add(current);
            return;
        }

        char digit = input.charAt(index);
        char[] values = digitToValues.get(digit);
        if (values != null) {
            for (char value : values) {
                generate(input, index + 1, current + value, combinations);
            }
        }
    }

    public static void main(String[] args) {
        String input = "123";
        List<String> combinations = generateCombinations(input);
        System.out.println(combinations);
    }
}