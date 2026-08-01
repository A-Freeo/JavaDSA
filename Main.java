import java.util.HashMap;
import java.util.Vector;

// javac Main.java
// java Main


class Node {

    private Node next;
    private int value;

    public Node(int value) {
        this.value = value;
        next = null;
    }

    public Node getNext() {
        return this.next;
    }

    public int getValue() {
        return this.value;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setValue(int value){
        this.value = value;
    }
}

class LinkedList {
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


final class LinkedListController{
    private LinkedListController() {}
    public static void findTwo(Node head, int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        Node temp = head;
        int i = 0;
        while(temp != null){
            int needed = target - temp.getValue();

            if(map.containsKey(needed)){
                System.out.println(map.get(needed) + ", " + i);
            }
            map.put(temp.getValue(), i);
            temp = temp.getNext();
            i++;
        }
    }

    public static int wholeInteger(Node head){
        Node temp = head;
        int sum = 0;
        while(temp != null){
            sum = (sum * 10) + temp.getValue();
            temp = temp.getNext();
        }
        return sum;
    }

    public static void reverse(Node head){
        Node prev = null;
        Node current = head;
        Node next = null;
        while(current != null){
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;

        }
        head = prev;
    }


    public static boolean findCycle(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.getNext() != null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if(slow == fast){
                System.out.println("Cycle detected");
                return true;
            }
        }
        return false;
    }

    public static void printNthNodeFromEnd(Node head, int n){
        Node slow = head;
        Node fast = head;
        if(findCycle(head)) return;
        for(int i = 0; i < n; i++){
            if(fast == null) return;
            fast = fast.getNext();
        }
        while(fast != null){
            // fast.getNext() would be for having slow be one before the target 
            slow = slow.getNext();
            fast = fast.getNext();
        }
        System.out.println(slow.getValue());

    }

    public static void bubbleSort(Node head){
        if(head == null || head.getNext() == null) return;

        boolean swap;

        do{
            swap = false;
            Node current = head;

            while(current.getNext() != null){
                int value1 = current.getValue();
                int value2 = current.getNext().getValue();


                if(value1 > value2){
                    current.setValue(value2);
                    current.getNext().setValue(value1);
                    swap = true;
                }

                current = current.getNext();
            }
        }while (swap);
    }



    public static void findMedSorted(Node head1, Node head2){
        Node i = head1;
        Node j = head2;
        // auto sorts lists
        bubbleSort(i);
        bubbleSort(j);

        Vector<Integer> values = new Vector<>();

        while(i != null && j != null){
            values.add(i.getValue());
            values.add(j.getValue());
            i = i.getNext();
            j = j.getNext();
        }

        while(i != null){
            values.add(i.getValue());
            i = i.getNext();
        }

        while(j != null){
            values.add(j.getValue());
            j = j.getNext();
        }
    
        int n = values.size();
        if(n % 2 == 1){
            System.out.println(values.get(n/2));
        }else{
            double temp = (values.get(n/2 - 1) + values.get(n/2)) / 2.0;
            System.out.println(temp);
        }

    }

    public static Node removeNthFromEnd(Node head, int n){

        Node dummy = new Node(0);
        dummy.setNext(head);

        Node fast = dummy;
        Node slow = dummy;

        for(int i = 0; i < n; i++){
            fast = fast.getNext();
            if(fast == null) return dummy.getNext();   // n is bigger than the list -> nothing to remove
        }

        while(fast.getNext() != null){
            fast = fast.getNext();
            slow = slow.getNext();
        }

        // slows next is now the one we want gone
        Node nthNode = slow.getNext();
        slow.setNext(nthNode.getNext());

        return dummy.getNext();

    }

    public static Node addTwoLists(Node head1, Node head2){
        Node tempHead1 = head1;
        Node tempHead2 = head2;

        Node head = null;
        Node tail = null;
        int carry = 0;

        while(tempHead1 != null || tempHead2 != null || carry != 0){
            int digit1 = tempHead1 != null ? tempHead1.getValue() : 0;
            int digit2 = tempHead2 != null ? tempHead2.getValue() : 0;

            int totalSum = digit1 + digit2 + carry;
            int digitValue = totalSum % 10;
            carry = totalSum / 10;

            Node tempNode = new Node(digitValue);
            if(head == null){
                head = tempNode;
                tail = head;
            }else{
                tail.setNext(tempNode);
                tail = tempNode;
            }

            if(tempHead1 != null){
                tempHead1 = tempHead1.getNext();
            }
            if(tempHead2 != null){
                tempHead2 = tempHead2.getNext();
            }

        }

        return head;
    }
}

public class Main {

    public static void main(String[] args) {
        LinkedList myList = new LinkedList();
        LinkedList myList2 = new LinkedList();

        myList.add(0);
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(6);
        myList.add(7);
        myList.add(8);
        myList.add(9);

        myList2.add(0);
        myList2.add(1);
        myList2.add(2);
        myList2.add(3);
        myList2.add(4);
        myList2.add(5);
        myList2.add(6);
        myList2.add(7);
        myList2.add(8);
        myList2.add(9);


        myList.printENG();
        myList.print();

        LinkedListController.findTwo(myList.getHead(), 5);
        LinkedListController.findMedSorted(myList.getHead(), myList2.getHead());
        myList.setHead(LinkedListController.removeNthFromEnd(myList.getHead(), 2));
        myList.print();

        LinkedList combinedList = new LinkedList();
        combinedList.setHead(LinkedListController.addTwoLists(myList.getHead(), myList2.getHead()));
        myList.print();
        myList2.print();
        combinedList.print();

        System.out.println();

        LinkedList myList3 = new LinkedList();
        myList3.add(5);
        myList3.add(3);
        myList3.add(1);
        myList3.add(2);
        myList3.add(7);

        myList3.print();
        LinkedListController.bubbleSort(myList3.getHead());
        myList3.print();

        System.out.println(LinkedListController.wholeInteger(myList3.getHead()));


        return;
    }

}