public class Queue<T>{
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public Queue(){
        head = null;
        tail = null;
        size = 0;
    }


    public void enqueue(T value){
        if(head == null){
            head = new Node<>(value);
            tail = head;
            size++;
            return;
        }
        Node<T> newNode = new Node<>(value);
        tail.setNext(newNode);
        tail = newNode;
        size++;
        return;
    }

    public T dequeue(){
        if(head == null) return null;
        Node<T> temp = head;
        head = head.getNext();
        if(head == null) tail = null;
        size--;
        return temp.getValue();
    }

    public T peek(){
        return head.getValue();
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public boolean contains(T value){
        Node<T> temp = head;
        while(temp != null){
            if(temp.getValue().equals(value)){ return true; }
            temp = temp.getNext();
        }
        return false;

    }

    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }

}
