//package numberrangesummarizer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

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
        System.out.println("Hello World from summarizer method");
        System.out.println(input);
        return null;
    }

    public static void main(String[] args) {
        NumberRangerGenerator obj = new NumberRangerGenerator();
        obj.collect("1,2,3");
        obj.summarizeCollection(null);
    }
}