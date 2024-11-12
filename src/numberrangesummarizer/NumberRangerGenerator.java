package numberrangesummarizer;
import java.util.*;

/*
 * @author Londolani 
 * Implement this Interface to produce a comma delimited list of numbers,
 * grouping the numbers into a range when they are sequential.
 * 
 */

public class NumberRangerGenerator implements NumberRangeSummarizer {
    @Override
    public Collection<Integer> collect(String input) {

        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        if (input == "") {
            throw new IllegalArgumentException("Input cannot be empty");
        }
        if (input.length() == 0) {
            return null;
        }

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        String[] inputArray = input.split(",");

        for (int i = 0; i < inputArray.length; i++) {
            int temp = Integer.parseInt(inputArray[i]);
            if(!numbers.contains(temp)){
                numbers.add(temp);
            }
        }

        Collections.sort(numbers);
        System.out.println(numbers);
        return numbers;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {

        List<Integer> numbers = new ArrayList<Integer>(input);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < numbers.size(); i++) {
            int start = numbers.get(i);
            result.append(start);
            while (i < numbers.size() - 1 && numbers.get(i + 1) - numbers.get(i) == 1) {
                i++;
            }
            int end = numbers.get(i);
            if (start != end) {
                result.append("-").append(end);
            }
            if (i < numbers.size() - 1) {
                result.append(", ");
            }
        }
        return result.toString();
    }
}