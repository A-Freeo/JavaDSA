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

    // ---- Sorting ----
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

    // ---- Reversal ----
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

    public static Node reverseListRecursive(Node head){

        if(head == null || head.getNext() == null){
            return head;
        }

        Node newHead = reverseListRecursive(head.getNext());

        head.getNext().setNext(head);
        head.setNext(null);

        return newHead;
    }

    // ---- Position (two-pointer) ----
    public static Node middleNode(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.getNext() != null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
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

    public static Node removeNthFromEnd(Node head, int n){

        Node dummy = new Node(0);
        dummy.setNext(head);

        Node fast = dummy;
        Node slow = dummy;

        for(int i = 0; i < n; i++){
            fast = fast.getNext();
            if(fast == null) return dummy.getNext();
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

    // ---- Cycle detection ----
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

    public static Node findCycleStart(Node head){
        Node slow = head;
        Node fast = head;
        boolean hasCycle = false;

        while(fast != null && fast.getNext() != null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if(slow == fast){
                hasCycle = true;
                break;
            }
        }

        if(!hasCycle) return null;
        slow = head;
        while(slow != fast){
            slow = slow.getNext();
            fast = fast.getNext();
        }
        return slow;
    }

    // ---- Reading / queries ----
    public static int wholeInteger(Node head){
        Node temp = head;
        int sum = 0;
        while(temp != null){
            sum = (sum * 10) + temp.getValue();
            temp = temp.getNext();
        }
        return sum;
    }

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

    public static boolean isPalindrome(Node head){
        if(head == null || head.getNext() == null) return true;
        Node mid = middleNode(head);
        Node secondHalf = reverseListRecursive(mid);
        Node firstHalf = head;
        while(secondHalf != null){
            if(firstHalf.getValue() != secondHalf.getValue()) return false;
            firstHalf = firstHalf.getNext();
            secondHalf = secondHalf.getNext();
        }
        return true;
    }

    // ---- Two-list operations ----
    public static Node mergeTwoLists(Node head1, Node head2){
        bubbleSort(head1);
        bubbleSort(head2);

        Node dummy = new Node(0);
        Node tail = dummy;
        Node p1 = head1;
        Node p2 = head2;

        while(p1 != null && p2 != null){
            if(p1.getValue() < p2.getValue()){
                tail.setNext(p1);
                p1 = p1.getNext();
            }else{
                tail.setNext(p2);
                p2 = p2.getNext();
            }
            tail = tail.getNext();
        }
        if(p1 != null) tail.setNext(p1);
        if(p2 != null) tail.setNext(p2);
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
}

public class Main {

    // build a list from the given values, in order
    static LinkedList build(int... values){
        LinkedList list = new LinkedList();
        for(int v : values) list.add(v);
        return list;
    }

    public static void main(String[] args) {

        System.out.println("=== print / printENG ===");
        LinkedList list = build(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        list.print();
        list.printENG();

        System.out.println("\n=== wholeInteger ===");
        System.out.println(LinkedListController.wholeInteger(build(1, 2, 3, 4).getHead()));

        System.out.println("\n=== findTwo (target 5) ===");
        LinkedListController.findTwo(build(0, 1, 2, 3, 4, 5).getHead(), 5);

        System.out.println("\n=== bubbleSort ===");
        LinkedList unsorted = build(5, 3, 1, 2, 7);
        unsorted.print();
        LinkedListController.bubbleSort(unsorted.getHead());
        unsorted.print();

        System.out.println("\n=== reverseListRecursive ===");
        LinkedList toReverse = build(1, 2, 3, 4, 5);
        toReverse.print();
        toReverse.setHead(LinkedListController.reverseListRecursive(toReverse.getHead()));
        toReverse.print();

        System.out.println("\n=== middleNode ===");
        System.out.println(LinkedListController.middleNode(build(1, 2, 3, 4, 5).getHead()).getValue());

        System.out.println("\n=== printNthNodeFromEnd (n=2) ===");
        LinkedListController.printNthNodeFromEnd(build(1, 2, 3, 4, 5).getHead(), 2);

        System.out.println("\n=== removeNthFromEnd (n=2) ===");
        LinkedList toRemove = build(1, 2, 3, 4, 5);
        toRemove.setHead(LinkedListController.removeNthFromEnd(toRemove.getHead(), 2));
        toRemove.print();

        System.out.println("\n=== findCycle ===");
        System.out.println("no cycle -> " + LinkedListController.findCycle(build(1, 2, 3, 4, 5).getHead()));
        LinkedList cyclic = build(1, 2, 3, 4, 5);
        Node cHead = cyclic.getHead();
        Node cTail = cHead;
        while(cTail.getNext() != null) cTail = cTail.getNext();
        cTail.setNext(cHead.getNext().getNext());          // 5 -> node holding 3, makes a cycle
        System.out.println("with cycle -> " + LinkedListController.findCycle(cHead));

        System.out.println("\n=== findCycleStart ===");
        System.out.println(LinkedListController.findCycleStart(cHead).getValue());

        System.out.println("\n=== mergeTwoLists ===");
        LinkedList merged = new LinkedList();
        merged.setHead(LinkedListController.mergeTwoLists(build(1, 4, 5).getHead(), build(2, 3, 6).getHead()));
        merged.print();

        System.out.println("\n=== addTwoLists (342 + 465) ===");
        LinkedList sum = new LinkedList();
        sum.setHead(LinkedListController.addTwoLists(build(2, 4, 3).getHead(), build(5, 6, 4).getHead()));
        sum.print();

        System.out.println("\n=== isPalindrome ===");
        System.out.println("1 2 3 2 1 -> " + LinkedListController.isPalindrome(build(1, 2, 3, 2, 1).getHead()));
        System.out.println("1 2 3 4   -> " + LinkedListController.isPalindrome(build(1, 2, 3, 4).getHead()));

        System.out.println("\n=== findMedSorted ===");
        LinkedListController.findMedSorted(build(1, 3, 8).getHead(), build(7, 9, 2).getHead());
    }

}
