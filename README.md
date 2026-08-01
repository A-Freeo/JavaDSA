# JavaDSA

Data-structures and algorithms practice in Java. Currently a hand-implemented singly linked list plus a set of classic linked-list problems, built to practice pointer manipulation and common interview patterns.

## What's here

`Main.java` contains:

- **Node / LinkedList** — a singly linked list with add, print, and head access.
- **LinkedListController** — static algorithms over the list:

| Method | Problem |
|---|---|
| `findTwo` | Two-sum (find a pair adding to a target) |
| `bubbleSort` | Sort the list in place |
| `findMedSorted` | Median of two lists |
| `removeNthFromEnd` | Remove the Nth node from the end |
| `printNthNodeFromEnd` | Print the Nth node from the end |
| `addTwoLists` | Add two numbers stored as lists |
| `wholeInteger` | Read the list's digits as one integer |
| `reverse` | Reverse the list |
| `findCycle` | Detect a cycle (fast/slow pointers) |

## Build & run

```
javac Main.java
java Main
```

## Roadmap

Linked-list problems to add next:

- [x] Reverse a linked list (iterative)
- [ ] Reverse a linked list (recursive)
- [x] Detect a cycle (fast/slow pointers)
- [ ] Find where the cycle starts
- [ ] Find the middle node
- [ ] Merge two sorted lists
- [ ] Palindrome check

Then branch into new structures:

- [ ] Stack and Queue (built on the linked list)
- [ ] Binary search tree — insert, search, and traversals
- [ ] Hash map from scratch (buckets + collision handling)

## Some constraints

- `removeNthFromEnd` handles removing the head and a large out-of-range `n` (returns null), but `n` exactly one past the list length still throws — an off-by-one in the guard.
