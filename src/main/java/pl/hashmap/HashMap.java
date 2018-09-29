package pl.hashmap;

import com.sun.jdi.Value;

public class HashMap<K,V> {

    private static final int INITIALSIZE = 16;
    private Object table[];

    HashMap(){
        this.table = new Object[INITIALSIZE];

    }

    public void add(K key, V value){

    }
}

