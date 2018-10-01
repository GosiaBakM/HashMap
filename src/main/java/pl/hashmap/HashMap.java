package pl.hashmap;

import com.sun.jdi.Value;

import java.util.Optional;
import java.util.Set;

public class HashMap<K,V> {

    private static final int INITIAL_SIZE = 16;
    private static final int INCREASE_SIZE_RATIO = 2;

    private Object table[];

    HashMap(){
        this.table = new Object[INITIAL_SIZE];
    }

    boolean containsKey(K key){
        int hash = key.hashCode();
        int bucket = Math.abs(hash%table.length);

        if (table[bucket] == null)
            return false;

        Set<Entry<K,V>> bucketSet = (Set<Entry<K,V>>)table[bucket];
        bucketSet.stream()
                .anyMatch(a->a.getKey().equals(key));

        return false;
    }

    public void add(K key, V value){
        int hash = key.hashCode();
        int bucket = Math.abs(hash%table.length);

        if (table[bucket] == null){
            table [bucket] = new HashSet<Entry<K,V>>();
        }

        Set<Entry <K,V> > bucketSet= (Set<Entry<K, V>>) table[bucket];

////////////////////////////
        if( this.containsKey(key)){
            getEntry(key).ifPresent(entry -> entry.setValue(value));
        }
        else
        bucketSet.add(new Entry<>(key, value));

    }

    private Optional<Entry<K,V>> getEntry(K key){
        int hash = key.hashCode();
        int bucket = Math.abs(hash % table.length);
        if (table[bucket] == null){
            return Optional.empty();
        }
        Set<Entry <K,V>> buckerSet = (Set<Entry<K, V>>) table[bucket];
        return buckerSet.stream()
                .filter(k->k.getKey().equals(key))
                .findFirst();

    }
}

