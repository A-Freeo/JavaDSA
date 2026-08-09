
public class ArrayList<T> {
    private T[] elements;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayList(){
        elements = (T[]) new Object[10];   // start with room for 10
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    // Grow the backing array to double its capacity.
    // Make a bigger array, copy elements[0..size-1] over, swap it in.
    @SuppressWarnings("unchecked")
    private void resize(){
        T[] newElements = (T[]) new Object[elements.length * 2];
        for(int i = 0; i < size; i++){
            newElements[i] = elements[i];
        }
        elements = newElements;
        
    }

    // Append to the end. If full, resize() first, then store and bump size.
    public void add(T value){
        if(size >= elements.length){
            resize();
        }
        elements[size] = value;
        size++;

    }

    // Return elements[index]. Guard against index < 0 || index >= size.
    public T get(int index){
        if(index < 0 || index >= size){
            return null;
        }

        return elements[index];
    }

    // Overwrite elements[index] with value (same bounds check as get).
    public void set(int index, T value){
        if(index < 0 || index >= size){
            return;
        }
        elements[index] = value;

    }

    // Remove elements[index], shift everything after it left by one, drop size.
    public T remove(int index){
        if(index < 0 || index >= size){
            return null;
        }
        T temp = elements[index];
        for(int i = index; i < size-1; i++){
            elements[i] = elements[i+1];
        }
        elements[size-1] = null;

        size--;
        return temp;
    }

    // Linear scan; return the first index whose element .equals(value), else -1.
    public int indexOf(T value){
        for(int i = 0; i < size; i++){
            if(value == null ? elements[i] == null : value.equals(elements[i])){
                return i;
            }
        }
        return -1;
    }
}
