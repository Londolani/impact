//package numberrangesummarizer;

import java.util.Collection;

/*
 * @author Londolani 
 * Implement this Interface to produce a comma delimited list of numbers,
 * grouping the numbers into a range when they are sequential.
 * 
 */

public class NumberRangerGenerator implements NumberRangeSummarizer {
    @Override
    public Collection<Integer> collect(String input) {
        System.out.println("Hello World from collection method");
        return null;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        System.out.println("Hello World from summarizer method");
        return null;
    }

    public static void main(String[] args) {
        NumberRangerGenerator obj = new NumberRangerGenerator();
        obj.collect("1,2,3");
        obj.summarizeCollection(null);
    }
}