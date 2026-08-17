# JavaDSA — Linked List

A hand-implemented singly linked list with a controller of classic list algorithms.
Part of [JavaDSA](https://github.com/A-Freeo/JavaDSA) (see the `main` branch for the overview).

## Files

- `Node.java` — a generic `Node<T>` (value + next pointer).
- `LinkedList.java` — the list itself, built on `Node<Integer>`.
- `LinkedListController.java` — static algorithms operating on a list's nodes.
- `Map.java` + `Entry.java` — supporting hash map used by `findTwo` (two-sum).

## LinkedListController methods

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

## Build

```
javac *.java
```
