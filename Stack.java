
public class Stack<T> {
    private Node<T> head;
    // look into a Deque

    public Stack(){
        this.head = null;
    }

    public void push(T value){
        Node<T> newNode = new Node<>(value);
        newNode.setNext(head);
        head = newNode;
    }

    public T pop(){
        if(head == null) throw new IllegalStateException("Stack is empty");
        T value = head.getValue();
        head = head.getNext();
        return value;
    }


    public boolean empty(){
        return head == null;
    }

    public T peek(){
        if(head == null) throw new IllegalStateException("Stack is empty");
        return head.getValue();
    }

    public void clear(){
        head = null;
    }

    public int search(T value){
        Node<T> current = head;
        int index = 0;
        while(current != null){
            if(current.getValue().equals(value)) return index;
            current = current.getNext();
            index++;
        }
        return -1;
    }
}
