package org.example;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/** Вариант 2. Пусть дан список сотрудников. Написать программу, которая найдёт и выведет повторяющиеся имена
 * с количеством повторений. Отсортировать по убыванию популярности.
 */
public class Task03 {
    public static void main(String[] args) {
        Map<String, Integer> nameMap = new HashMap<>();
        String employees = "Иван Иванов " + "Светлана Петрова " + "Кристина Белова " + "Анна Мусина " +
                "Анна Крутова " + "Иван Юрин " + "Петр Лыков " + "Павел Чернов " +
                "Петр Чернышов " + "Мария Федорова " + "Марина Светлова " + "Мария Савина " +
                "Мария Рыкова " + "Марина Лугова " + "Анна Владимирова " + "Иван Мечников " +
                "Петр Петин " + "Иван Ежов ";
        String[] listOfNames = employees.split(" ");
        for (int i = 0; i < listOfNames.length; i += 2) {
            if (nameMap.containsKey(listOfNames[i])) {
                nameMap.replace(listOfNames[i], nameMap.get(listOfNames[i]) + 1);
            } else {
                nameMap.put(listOfNames[i], 1);
            }
        }
        System.out.println("Список повторяющихся имен: ");
        System.out.println(nameMap);
        Map<String, Integer> sortedNameMap = new LinkedHashMap<>();
        int max = 1;
        for (int value : nameMap.values()) {
            if (value > max) {
                max = value;
            }
        }
        for (int i = max; i > 0; i--) {
            for (Map.Entry<String, Integer> entry : nameMap.entrySet()) {
                String key = entry.getKey();
                if (nameMap.get(key) == i) {
                    sortedNameMap.put(key, nameMap.get(key));
                }
            }
        }
        System.out.println("Список имен по убыванию и популярности: ");
        System.out.println(sortedNameMap);
    }
}
