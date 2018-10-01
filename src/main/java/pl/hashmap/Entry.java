package pl.hashmap;

import java.util.Objects;

public class Entry<K,V> {

    private K key;
    private V value;

    Entry(K key, V value){
        this.key = key;
        this.value = value;
    }

   public void setKey(K key){
        this.key = key;
    }
    public void setValue(V value){
        this.value = value;
    }

    public K getKey(){
        return key;
    }
    public V getValue(){
        return value;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
