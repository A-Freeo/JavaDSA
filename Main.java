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

        System.out.println("=== LinkedList: print / printENG ===");
        LinkedList list = build(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        LinkedListController.print(list.getHead());
        LinkedListController.printENG(list.getHead());

        System.out.println("\n=== LinkedList: wholeInteger ===");
        System.out.println(LinkedListController.wholeInteger(build(1, 2, 3, 4).getHead()));

        System.out.println("\n=== LinkedList: findTwo (target 5) ===");
        LinkedListController.findTwo(build(0, 1, 2, 3, 4, 5).getHead(), 5);

        System.out.println("\n=== LinkedList: bubbleSort ===");
        LinkedList unsorted = build(5, 3, 1, 2, 7);
        LinkedListController.print(unsorted.getHead());
        LinkedListController.bubbleSort(unsorted.getHead());
        LinkedListController.print(unsorted.getHead());

        System.out.println("\n=== LinkedList: reverseListRecursive ===");
        LinkedList toReverse = build(1, 2, 3, 4, 5);
        LinkedListController.print(toReverse.getHead());
        toReverse.setHead(LinkedListController.reverseListRecursive(toReverse.getHead()));
        LinkedListController.print(toReverse.getHead());

        System.out.println("\n=== LinkedList: middleNode ===");
        System.out.println(LinkedListController.middleNode(build(1, 2, 3, 4, 5).getHead()).getValue());

        System.out.println("\n=== LinkedList: printNthNodeFromEnd (n=2) ===");
        LinkedListController.printNthNodeFromEnd(build(1, 2, 3, 4, 5).getHead(), 2);

        System.out.println("\n=== LinkedList: removeNthFromEnd (n=2) ===");
        LinkedList toRemove = build(1, 2, 3, 4, 5);
        toRemove.setHead(LinkedListController.removeNthFromEnd(toRemove.getHead(), 2));
        LinkedListController.print(toRemove.getHead());

        System.out.println("\n=== LinkedList: findCycle ===");
        System.out.println("no cycle -> " + LinkedListController.findCycle(build(1, 2, 3, 4, 5).getHead()));
        LinkedList cyclic = build(1, 2, 3, 4, 5);
        Node<Integer> cHead = cyclic.getHead();
        Node<Integer> cTail = cHead;
        while(cTail.getNext() != null) cTail = cTail.getNext();
        cTail.setNext(cHead.getNext().getNext());          // 5 -> node holding 3, makes a cycle
        System.out.println("with cycle -> " + LinkedListController.findCycle(cHead));

        System.out.println("\n=== LinkedList: findCycleStart ===");
        System.out.println(LinkedListController.findCycleStart(cHead).getValue());

        System.out.println("\n=== LinkedList: mergeTwoLists ===");
        LinkedList merged = new LinkedList();
        merged.setHead(LinkedListController.mergeTwoLists(build(1, 4, 5).getHead(), build(2, 3, 6).getHead()));
        LinkedListController.print(merged.getHead());

        System.out.println("\n=== LinkedList: addTwoLists (342 + 465) ===");
        LinkedList sum = new LinkedList();
        sum.setHead(LinkedListController.addTwoLists(build(2, 4, 3).getHead(), build(5, 6, 4).getHead()));
        LinkedListController.print(sum.getHead());

        System.out.println("\n=== LinkedList: isPalindrome ===");
        System.out.println("1 2 3 2 1 -> " + LinkedListController.isPalindrome(build(1, 2, 3, 2, 1).getHead()));
        System.out.println("1 2 3 4   -> " + LinkedListController.isPalindrome(build(1, 2, 3, 4).getHead()));

        System.out.println("\n=== LinkedList: findMedSorted ===");
        LinkedListController.findMedSorted(build(1, 3, 8).getHead(), build(7, 9, 2).getHead());
    

         System.out.println("\n=== Stack: NextGreaterElements ===");
         int[] nums = {4, 1, 0, 6, 5};
         System.out.print("nums -> ");
         for(int i : nums){
            System.out.print(i + " ");
         }
         System.out.println();
         int[] result = StackController.NextGreaterElements(nums);
         System.out.print("result -> ");
         for(int i : result){
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("\n=== Stack: isValidBrackets ===\n");
        char[] brackets = {'(', ')', '{', '}', '[', ']'};
        for(char c : brackets){
            System.out.print(c + " ");
        }
        System.out.println();
        System.out.println("brackets -> " + StackController.isValidBrackets(brackets));

        brackets = new char[]{'(',']','{','}','[',']'};
        for(char c : brackets){
            System.out.print(c + " ");
        }
        System.out.println();
        System.out.println("brackets -> " + StackController.isValidBrackets(brackets));
    }

}
