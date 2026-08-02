// javac *.java
// java Main

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
