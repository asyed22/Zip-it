package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

class AppTest {
    @Test
    void testZipWithEqualLengthLists() {
        List<Integer> list1 = List.of(1, 3, 5);
        List<Integer> list2 = List.of(2, 4, 6);
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
        assertEquals(expected, App.zip(list1, list2));
    }

    @Test
    void testZipWithFirstListLonger() {
        List<String> list1 = List.of("A", "B", "C", "D");
        List<String> list2 = List.of("1", "2");
        List<String> expected = List.of("A", "1", "B", "2", "C", "D");
        assertEquals(expected, App.zip(list1, list2));
    }

    @Test
    void testZipWithSecondListLonger() {
        List<String> list1 = List.of("A", "B");
        List<String> list2 = List.of("1", "2", "3", "4");
        List<String> expected = List.of("A", "1", "B", "2", "3", "4");
        assertEquals(expected, App.zip(list1, list2));
    }

    @Test
    void testHashmapifyWithValidInput() {
        List<String> keys = List.of("a", "b", "c");
        List<Integer> values = List.of(1, 2, 3);
        Map<String, Integer> expected = new HashMap<>();
        expected.put("a", 1);
        expected.put("b", 2);
        expected.put("c", 3);
        
        assertEquals(expected, App.hashmapify(keys, values));
    }

    @Test
    void testHashmapifyWithDifferentSizes() {
        List<String> keys = List.of("a", "b", "c");
        List<Integer> values = List.of(1, 2);
        
        assertThrows(IllegalArgumentException.class, () -> {
            App.hashmapify(keys, values);
        });
    }
}