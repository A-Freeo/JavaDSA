public class LinkedList {
    private Node<Integer> head;

    public LinkedList() {
        head = null;
    }

    public void setHead(Node<Integer> head){
        this.head = head;
    }

    public Node<Integer> getHead(){
        return head;
    }

    public void add(int value) {
        Node<Integer> temp = head;
        if (temp == null) {
            Node<Integer> newNode = new Node<>(value);
            head = newNode;
            return;
        }

        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        Node<Integer> newNode = new Node<>(value);
        temp.setNext(newNode);
        return;
    }
}
