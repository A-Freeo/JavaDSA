import java.util.Vector;

public final class LinkedListController{
    private LinkedListController() {}

    // ---- Sorting ----
    public static void bubbleSort(Node<Integer> head){
        if(head == null || head.getNext() == null) return;

        boolean swap;

        do{
            swap = false;
            Node<Integer> current = head;

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
    public static void reverse(Node<Integer> head){
        Node<Integer> prev = null;
        Node<Integer> current = head;
        Node<Integer> next = null;
        while(current != null){
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;

        }
        head = prev;
    }

    public static Node<Integer> reverseListRecursive(Node<Integer> head){

        if(head == null || head.getNext() == null){
            return head;
        }

        Node<Integer> newHead = reverseListRecursive(head.getNext());

        head.getNext().setNext(head);
        head.setNext(null);

        return newHead;
    }

    // ---- Position (two-pointer) ----
    public static Node<Integer> middleNode(Node<Integer> head){
        Node<Integer> slow = head;
        Node<Integer> fast = head;
        while(fast != null && fast.getNext() != null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    public static void printNthNodeFromEnd(Node<Integer> head, int n){
        Node<Integer> slow = head;
        Node<Integer> fast = head;
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

    public static Node<Integer> removeNthFromEnd(Node<Integer> head, int n){

        Node<Integer> dummy = new Node<>(0);
        dummy.setNext(head);

        Node<Integer> fast = dummy;
        Node<Integer> slow = dummy;

        for(int i = 0; i < n; i++){
            fast = fast.getNext();
            if(fast == null) return dummy.getNext();
        }

        while(fast.getNext() != null){
            fast = fast.getNext();
            slow = slow.getNext();
        }

        // slows next is now the one we want gone
        Node<Integer> nthNode = slow.getNext();
        slow.setNext(nthNode.getNext());

        return dummy.getNext();

    }

    // ---- Cycle detection ----
    public static boolean findCycle(Node<Integer> head){
        Node<Integer> slow = head;
        Node<Integer> fast = head;
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

    public static Node<Integer> findCycleStart(Node<Integer> head){
        Node<Integer> slow = head;
        Node<Integer> fast = head;
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
    public static int wholeInteger(Node<Integer> head){
        Node<Integer> temp = head;
        int sum = 0;
        while(temp != null){
            sum = (sum * 10) + temp.getValue();
            temp = temp.getNext();
        }
        return sum;
    }

    public static void findTwo(Node<Integer> head, int target){
        Map<Integer,Integer> map = new Map<>();
        Node<Integer> temp = head;
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

    public static boolean isPalindrome(Node<Integer> head){
        if(head == null || head.getNext() == null) return true;
        Node<Integer> mid = middleNode(head);
        Node<Integer> secondHalf = reverseListRecursive(mid);
        Node<Integer> firstHalf = head;
        while(secondHalf != null){
            if(firstHalf.getValue() != secondHalf.getValue()) return false;
            firstHalf = firstHalf.getNext();
            secondHalf = secondHalf.getNext();
        }
        return true;
    }

    // ---- Two-list operations ----
    public static Node<Integer> mergeTwoLists(Node<Integer> head1, Node<Integer> head2){
        bubbleSort(head1);
        bubbleSort(head2);

        Node<Integer> dummy = new Node<>(0);
        Node<Integer> tail = dummy;
        Node<Integer> p1 = head1;
        Node<Integer> p2 = head2;

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

    public static Node<Integer> addTwoLists(Node<Integer> head1, Node<Integer> head2){
        Node<Integer> tempHead1 = head1;
        Node<Integer> tempHead2 = head2;

        Node<Integer> head = null;
        Node<Integer> tail = null;
        int carry = 0;

        while(tempHead1 != null || tempHead2 != null || carry != 0){
            int digit1 = tempHead1 != null ? tempHead1.getValue() : 0;
            int digit2 = tempHead2 != null ? tempHead2.getValue() : 0;

            int totalSum = digit1 + digit2 + carry;
            int digitValue = totalSum % 10;
            carry = totalSum / 10;

            Node<Integer> tempNode = new Node<> (digitValue);
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

    public static void findMedSorted(Node<Integer> head1, Node<Integer> head2){
        Node<Integer> i = head1;
        Node<Integer> j = head2;
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

    // --- Printing ---
    public static void printENG(Node<Integer> head) {
        Node<Integer> temp = head;
        int i = 1;
        while (temp != null) {
            System.out.println("Node " + i + " = " + temp.getValue());
            temp = temp.getNext();
            i++;
        }
    }

    public static void print(Node<Integer> head) {
        Node<Integer> temp = head;
        System.out.print("[");

        while (temp != null) {
            System.out.print(temp.getValue());
            temp = temp.getNext();
            if (temp != null) System.out.print(", ");
        }
        System.out.println("]");
    }
}
