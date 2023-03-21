package org.example;

/** Реализуйте структуру телефонной книги с помощью HashMap, учитывая,
 * что 1 человек может иметь несколько телефонов.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Task01 {
    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> bookPhone = new HashMap<>();
        addNumber("Петров", 346678, bookPhone);
        addNumber("Сагитов", 45567, bookPhone);
        addNumber("Сидоров", 332211, bookPhone);
        addNumber("Петров", 335678, bookPhone);
        addNumber("Жмуров", 27899, bookPhone);
        addNumber("Котеночкин", 57001, bookPhone);
        addNumber("Сагитов", 27899, bookPhone);

        printBook(bookPhone);
    }
    public static void addNumber(String key, int value,  Map<String, ArrayList<Integer>> map){
        if (map.containsKey(key)) {
            map.get(key).add(value);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
        }

    }
    public static void printBook(Map<String, ArrayList<Integer>> map) {
        for (var item : map.entrySet()) {
            String phones = "";
            for (int el : item.getValue()) {
                phones = phones + el + ", ";
            }
            System.out.printf("%s: %s \n", item.getKey(), phones);
        }
    }
}