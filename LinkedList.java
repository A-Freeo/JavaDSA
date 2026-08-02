public class LinkedList {
    private Node head;

    public LinkedList() {
        head = null;
    }

    public void setHead(Node head){
        this.head = head;
    }

    public Node getHead(){
        return head;
    }

    public void add(int value) {
        Node temp = head;
        if (temp == null) {
            Node newNode = new Node(value);
            head = newNode;
            return;
        }

        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        Node newNode = new Node(value);
        temp.setNext(newNode);
        return;
    }

    public void printENG() {
        Node temp = head;
        int i = 1;
        while (temp != null) {
            System.out.println("Node " + i + " = " + temp.getValue());
            temp = temp.getNext();
            i++;
        }
    }

    public void print() {
        Node temp = head;
        System.out.print("[");

        while (temp != null) {
            System.out.print(temp.getValue());
            temp = temp.getNext();
            if (temp != null) System.out.print(", ");
        }
        System.out.println("]");
    }
}
