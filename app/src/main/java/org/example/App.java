package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static <T> List<T> zip(List<T> list1, List<T> list2) {
        List<T> result = new ArrayList<>();
        int maxLength = Math.max(list1.size(), list2.size());
        
        for (int i = 0; i < maxLength; i++) {
            if (i < list1.size()) {
                result.add(list1.get(i));
            }
            if (i < list2.size()) {
                result.add(list2.get(i));
            }
        }
        
        return result;
    }

    public static <V> Map<String, V> hashmapify(List<String> keys, List<V> values) {
        if (keys.size() != values.size()) {
            throw new IllegalArgumentException("Key and value lists must be of the same size");
        }
        
        Map<String, V> map = new HashMap<>();
        for (int i = 0; i < keys.size(); i++) {
            map.put(keys.get(i), values.get(i));
        }
        return map;
    }

    public static void main(String[] args) {
        // Test zip method
        List<Integer> nums1 = List.of(1, 3, 5, 7);
        List<Integer> nums2 = List.of(2, 4, 6, 8);
        List<Integer> mergedNumbers = zip(nums1, nums2);
        System.out.println(mergedNumbers); // [1, 2, 3, 4, 5, 6, 7, 8]
        
        List<String> colors1 = List.of("Red", "Green", "Blue");
        List<String> colors2 = List.of("White", "Black", "Orange", "Pink", "Fuschia");
        List<String> mergedWords = zip(colors1, colors2);
        System.out.println(mergedWords); // ["Red", "White", "Green", "Black", "Blue", "Orange", "Pink", "Fuschia"]

        List<String> colors = List.of("White", "Black", "Orange", "Pink");
        List<Integer> nums = List.of(1, 3, 5, 7);
        
        Map<String, Integer> map = hashmapify(colors, nums);
        System.out.println(map); // {White=1, Pink=7, Black=3, Orange=5}
    }
}