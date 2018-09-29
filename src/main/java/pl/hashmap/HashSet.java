package pl.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class HashSet <T> {
    private int INITIAL_SIZE = 16;
    private int INCREASE_SIZE_RATIO = 2;
    private int currentSize = 0;

    Object [] table = new Object[INITIAL_SIZE];

    public void add(T t){
        int hash = t.hashCode();

        int bucket = Math.abs(hash%table.length);
        if(table[bucket] == null){
            table[bucket] = new ArrayList<T>();
        }
        List<T> bucketList = (List<T>) table[bucket];
        for(T t1:bucketList){
           if(t1.equals(t))
            return;
        }
        bucketList.add(t);
        currentSize ++;
    }


    public boolean contains(T t){
        int hash = t.hashCode();
        int bucket = Math.abs(hash%table.length);
        if(table[bucket] == null){
           return false;
        }
        List<T> bucketList = (List<T>) table[bucket];
        for (T t1: bucketList) {
            if(t1.equals(t))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        sb.append(Arrays.stream(table)
            .filter(Objects::nonNull)
            .flatMap(o -> ((List<T>)o).stream())
            .map(T::toString)
            .collect(Collectors.joining(",")));
        sb.append("]");
        return sb.toString();
    }

    public void rearrange(){

        List <T> elements = new ArrayList<T>(currentSize);
        for (Object t: table) {

            if(t != null) {List <T> bucket = (List<T>) t;
                elements.addAll(bucket);
            }
        }

        this.table = new Object[this.table.length*INCREASE_SIZE_RATIO];
        this.currentSize = 0;
        elements.forEach(this::add);
    }
}
