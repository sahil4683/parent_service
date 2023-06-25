package com.ms.utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionUtils {
	
	public static void main(String[] args) {
        List<String> names = List.of("John",  "Jane", "Bob");

        boolean isNullOrEmpty = CollectionUtils.isNullOrEmpty(names);
        System.out.println("Is names list null or empty? " + isNullOrEmpty);

        List<String> nonNullNames = CollectionUtils.filterNonNull(names);
        System.out.println("NonNullNames: " + nonNullNames);

        List<String> upperCaseNames = CollectionUtils.map(names, String::toUpperCase);
        System.out.println("UpperCaseNames: " + upperCaseNames);
        
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");
        String result = arrayListToString(list);
        System.out.println(result);
        
        String str = "Apple, Banana, Orange";
        ArrayList<String> list1 = stringToArrayList(str);
        System.out.println(list1);
    }

    public static boolean isNullOrEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static <T> List<T> filterNonNull(List<T> list) {
        return list.stream()
                .filter(element -> element != null)
                .collect(Collectors.toList());
    }

    public static <T> List<T> map(List<T> list, Mapper<T> mapper) {
        return list.stream()
                .map(mapper::map)
                .collect(Collectors.toList());
    }

    public interface Mapper<T> {
        T map(T element);
    }
    
    public static String arrayListToString(ArrayList<String> list) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));

            if (i != list.size() - 1) {
                sb.append(", ");
            }
        }

        return sb.toString();
    }
    
    public static ArrayList<String> stringToArrayList(String str) {
        String[] elements = str.split(",\\s*");
        ArrayList<String> list = new ArrayList<>(Arrays.asList(elements));
        return list;
    }
}
