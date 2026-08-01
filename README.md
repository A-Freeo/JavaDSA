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
| `addTwoLists` | Add two numbers stored as lists |

## Build & run

```
javac Main.java
java Main
```

## Roadmap

Linked-list problems to add next:

- [ ] Reverse a linked list (iterative and recursive)
- [ ] Detect a cycle (fast/slow pointers) and find where it starts
- [ ] Find the middle node
- [ ] Merge two sorted lists
- [ ] Palindrome check

Then branch into new structures:

- [ ] Stack and Queue (built on the linked list)
- [ ] Binary search tree — insert, search, and traversals
- [ ] Hash map from scratch (buckets + collision handling)

## Some constraints

- `removeNthFromEnd` doesn't handle edge cases yet — removing the head (`n` equals the list length) or an out-of-range `n` (larger than the list) will misbehave or throw.
