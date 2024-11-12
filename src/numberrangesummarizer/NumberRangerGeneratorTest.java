package numberrangesummarizer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Collection;
import java.util.Collections;

public class NumberRangerGeneratorTest {

    @Test
    public void testCollectWithValidInput() {
        // Test collecting numbers from a valid comma-separated string
        NumberRangerGenerator obj = new NumberRangerGenerator();
        Collection<Integer> numbers = obj.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31");
        assertNotNull(numbers);
        assertEquals(14, numbers.size());
        assertTrue(numbers.contains(1));
        assertTrue(numbers.contains(31));
    }

    @Test
    public void testSummarizeCollectionWithValidInput() {
        // Test summarizing a collection of numbers into a range string with valid input
        NumberRangerGenerator obj = new NumberRangerGenerator();
        Collection<Integer> numbers = obj.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31");
        String summary = obj.summarizeCollection(numbers);
        assertEquals("1, 3, 6-8, 12-15, 21-24, 31", summary);
    }

    @Test
    public void testCollectWithInvalidInput() {
        // Test collecting numbers from an invalid comma-separated string
        NumberRangerGenerator obj = new NumberRangerGenerator();
        assertThrows(NumberFormatException.class, () -> {
            obj.collect("1,3,6,7,8,abc,13,14,15,21,22,23,24,31");
        });
    }

    @Test
    public void testCollectWithEmptyInput() {
        // Test collecting numbers from an empty string
        NumberRangerGenerator obj = new NumberRangerGenerator();
        assertThrows(IllegalArgumentException.class, () -> {
            obj.collect("");
        });
    }

    @Test
    public void testSummarizeCollectionWithEmptyCollection() {
        // Test summarizing an empty collection of numbers
        NumberRangerGenerator obj = new NumberRangerGenerator();
        String summary = obj.summarizeCollection(Collections.emptyList());
        assertEquals("", summary);
    }

    @Test
    public void testCollectWithNullInput() {
        // Test collecting numbers from a null input
        NumberRangerGenerator obj = new NumberRangerGenerator();
        assertThrows(IllegalArgumentException.class, () -> {
            obj.collect(null);
        });
    }

    @Test
    public void testCollectWithSingleNumberInput() {
        // Test collecting numbers from a single number string
        NumberRangerGenerator obj = new NumberRangerGenerator();
        Collection<Integer> numbers = obj.collect("5");
        assertNotNull(numbers);
        assertEquals(1, numbers.size());
        assertTrue(numbers.contains(5));
    }

    @Test
    public void testCollectWithDuplicateNumbers() {
        // Test collecting numbers from a string with duplicate numbers
        NumberRangerGenerator obj = new NumberRangerGenerator();
        Collection<Integer> numbers = obj.collect("1,3,3,6,7,8,12,13,14,15,21,22,23,24,31,31");
        assertNotNull(numbers);
        assertEquals(14, numbers.size());
        assertTrue(numbers.contains(3));
        assertTrue(numbers.contains(31));
    }

    @Test
    public void testSummarizeCollectionWithNonSequentialNumbers() {
        // Test summarizing a collection of non-sequential numbers
        NumberRangerGenerator obj = new NumberRangerGenerator();
        Collection<Integer> numbers = obj.collect("1,3,5,7,9");
        String summary = obj.summarizeCollection(numbers);
        assertEquals("1, 3, 5, 7, 9", summary);
    }
}