# JavaDSA

Data-structures and algorithms practice in Java. Currently a hand-implemented singly linked list plus a set of classic linked-list problems, built to practice pointer manipulation and common interview patterns.

## What's here

Each class is in its own file:

- **`Node.java` / `LinkedList.java`** — a singly linked list with add, print, and head access.
- **`LinkedListController.java`** — static algorithms over the list, grouped by category:

| Method | Problem |
|---|---|
| `bubbleSort` | Sort the list in place |
| `reverse` / `reverseListRecursive` | Reverse the list (iterative / recursive) |
| `middleNode` | Find the middle node |
| `printNthNodeFromEnd` | Print the Nth node from the end |
| `removeNthFromEnd` | Remove the Nth node from the end |
| `findCycle` | Detect a cycle (fast/slow pointers) |
| `findCycleStart` | Find where a cycle begins |
| `wholeInteger` | Read the list's digits as one integer |
| `findTwo` | Two-sum (find a pair adding to a target) |
| `isPalindrome` | Check if the list is a palindrome |
| `mergeTwoLists` | Merge two sorted lists |
| `addTwoLists` | Add two numbers stored as lists |
| `findMedSorted` | Median of two lists |

- **`Main.java`** — the driver; runs a labeled demo of each method.

## Build & run

```
javac *.java
java Main
```

## Roadmap

Linked-list problems:

- [x] Reverse a linked list (iterative)
- [x] Reverse a linked list (recursive)
- [x] Detect a cycle (fast/slow pointers)
- [x] Find where the cycle starts
- [x] Find the middle node
- [x] Merge two sorted lists
- [x] Palindrome check

Next, branch into new structures:

- [ ] Stack and Queue (built on the linked list)
- [ ] Binary search tree — insert, search, and traversals
- [ ] Hash map from scratch (buckets + collision handling)
