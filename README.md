# JavaDSA

Data-structures and algorithms practice in Java — hand-implemented linked list, stack, queue, hash map, and binary search tree, each with a "controller" of classic algorithms, built to practice pointer manipulation and common interview patterns.

## What's here

Each class is in its own file:

- **Linked list** — `Node.java` (generic `Node<T>`), `LinkedList.java`, and `LinkedListController.java` (static algorithms, table below).
- **Stack** — `Stack.java` (generic, built on `Node`) with `StackController.java` — reverse, valid brackets, next greater element.
- **Queue** — `Queue.java` (generic, head + tail pointers) with `QueueController.java` — reverse, reverseFirstK, interleave.
- **Hash map** — `Map.java` + `Entry.java` — an array of buckets with separate chaining (`put`, `get`, `remove`, `containsKey`, `containsValue`) — with `MapController.java` — twoSum, mostFrequent, containsDuplicate, isAnagram.
- **Binary search tree** — `TreeNode.java` + `BinarySearchTree.java` (core ops: `insert`, `search`, `delete`, `min`, `max`) with `BinarySearchTreeController.java` (static algorithms, table below).
- **`Main.java`** — the driver; runs a labeled demo of the linked-list methods.

### LinkedListController methods

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

### BinarySearchTreeController methods

| Method | Problem |
|---|---|
| `preOrder` / `inOrder` / `postOrder` | Recursive depth-first traversals (in-order prints sorted) |
| `levelOrder` | Breadth-first traversal, level by level (uses the `Queue`) |
| `height` | Height of the tree |
| `size` | Count every node |
| `countLeaves` | Count nodes with no children |
| `invert` | Mirror the tree left-to-right |
| `isValidBST` | Verify the ordering holds via min/max bounds |
| `lowestCommonAncestor` | Lowest node that two values share as an ancestor |
| `kthSmallest` | Kth smallest value (in-order + counter) |

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

New structures:

- [x] Stack (built on the linked list)
- [x] Queue (built on the linked list)
- [x] Hash map from scratch (buckets + collision handling)
- [x] Binary search tree — insert, search, delete, traversals, and classic queries

Next up:

- [ ] Dynamic array (`ArrayList` from scratch) — raw backing array + resize-on-grow
- [ ] Min-heap / priority queue — array-backed, sift-up/sift-down
- [ ] Graph — adjacency list with BFS and DFS
- [ ] Trie — prefix tree for string lookups
- [ ] Self-balancing BST (AVL or red-black) — keep the tree height-balanced on insert/delete
