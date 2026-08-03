public class Node<T> {

    private Node<T> next;
    private T value;

    public Node(T value) {
        this.value = value;
        next = null;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public T getValue() {
        return this.value;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void setValue(T value){
        this.value = value;
    }
}
