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

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            for(String str : x){
                char ch = str.charAt(0);
                if (Character.isLowerCase(ch) || Character.isDigit(ch)){
                    return false;
                }
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {

        return x -> {
            List<Integer> list = new ArrayList<>(x);
            for(Integer i : list){
                if(i % 2 == 0){
                    x.add(i);
                }
            }

        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            for (int i = 0; i < values.size(); i++){
                String str = values.get(i);
                if(str.endsWith(".") && Character.isUpperCase(str.charAt(0))
                   && (str.split(" ").length > 3)){
                    continue;
                }
                values.remove(i);
                i--;
            }
            return values;
        };

    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            HashMap<String, Integer> map = new HashMap<>();
            for(String str : x){
                map.put(str, str.length());
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (first, second) -> {
            List<Integer> list = new ArrayList<>(first);
            list.addAll(second);
            return list;
        };
    }
}
