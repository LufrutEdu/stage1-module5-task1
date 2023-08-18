package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            for (String item:
                 x) {
                if(Character.isLowerCase(item.charAt(0)) || Character.isDigit(item.charAt(0))) return false;
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            List<Integer> out = new ArrayList<>();
            for (int item:
                 x) {
                if(item % 2 == 0) out.add(item);
            }
            x.addAll(out);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            return values.stream()
                    .filter(c -> Character.isUpperCase(c.charAt(0)))
                    .filter(c -> '.' == c.charAt(c.length() - 1))
                    .filter(c -> {
                        String[] arr = c.split(" ");
                        return arr.length > 3;
                    }).collect(Collectors.toList());
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> out = new HashMap<>();
            for (String item:
                 x) {
                out.put(item, item.length());
            }
            return out;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return new ArrayList<>(list1);
        };
    }
}
