public class Map<K, V> {
    private Entry<K, V>[] buckets;
    private int size;

    @SuppressWarnings("unchecked")
    public Map(){
        this.buckets = (Entry<K, V>[]) new Entry[16];
        this.size = 0;
    }

    public int size(){
        return size;
    }

    public void put(K key, V value){
        int index = Math.abs(key.hashCode()) % buckets.length;

        Entry<K, V> current = buckets[index];
        while(current != null){
            if(current.getKey().equals(key)){
                current.setValue(value);
                return;                      
            }
            current = current.getNext();
        }

        Entry<K, V> newEntry = new Entry<>(key, value);
        newEntry.setNext(buckets[index]);
        buckets[index] = newEntry;
        size++;
    }

    public V get(K key){
        int index = Math.abs(key.hashCode()) % buckets.length;
        Entry<K, V> current = buckets[index];
        while(current != null){
            if(current.getKey().equals(key)){
                return current.getValue();
            }
            current = current.getNext();
        }
        return null;
    }

    public void remove(K key){
        int index = Math.abs(key.hashCode()) % buckets.length;
        Entry<K, V> current = buckets[index];
        Entry<K, V> prev = null;
        while(current != null){
            if(current.getKey().equals(key)){
                if(prev == null){
                    buckets[index] = current.getNext();
                } else {
                    prev.setNext(current.getNext());
                }
                size--;
                return;
            }
            prev = current;
            current = current.getNext();
        }
    }

    @SuppressWarnings("unchecked")
    public void clear(){
        buckets = new Entry[16];
        size = 0;
    }

    public boolean containsKey(K key){
        int index = Math.abs(key.hashCode()) % buckets.length;
        Entry<K, V> current = buckets[index];

        while(current != null){
            if(current.getKey().equals(key)){
                return true;                      
            }
            current = current.getNext();
        }
        return false;


    }

    public boolean containsValue(V value){
        for(int i = 0; i < buckets.length; i++){     
            Entry<K, V> current = buckets[i];
            while(current != null){
                if(current.getValue().equals(value)){
                    return true;
                }
                current = current.getNext();
            }
        }
        return false;
    }
    public boolean isEmpty(){
        if(size == 0){
            return true;
         }else {
            return false;
         }
    }




}
