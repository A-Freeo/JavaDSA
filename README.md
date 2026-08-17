# JavaDSA

Data-structures and algorithms practice in Java — each structure hand-implemented from scratch,
with a "controller" of classic algorithms, to practice pointer manipulation, recursion, and
common interview patterns.

This branch (`main`) is the overview. **Each data structure lives on its own branch** with its own
README and a self-contained, compilable set of files.

## Branches

| Branch | Structure | Core files |
|---|---|---|
| [`LinkedList`](../../tree/LinkedList) | Singly linked list + algorithms | `Node`, `LinkedList`, `LinkedListController` |
| [`Stack`](../../tree/Stack) | LIFO stack + algorithms | `Stack`, `StackController` |
| [`Queue`](../../tree/Queue) | FIFO queue + algorithms | `Queue`, `QueueController` |
| [`Map`](../../tree/Map) | Hash map (buckets + chaining) + algorithms | `Map`, `Entry`, `MapController` |
| [`BinarySearchTree`](../../tree/BinarySearchTree) | Binary search tree + algorithms | `TreeNode`, `BinarySearchTree`, `BinarySearchTreeController` |
| [`ArrayList`](../../tree/ArrayList) | Dynamic array (resizing) | `ArrayList` |
| [`legacy`](../../tree/legacy) | Original `Main.java` demo driver (pre-split) | `Main` + supporting files |

Each structure branch also carries any supporting files it needs to compile on its own
(e.g. `Stack` includes `Node`; `BinarySearchTree` includes `Queue` for `levelOrder`).

## Build

Check out a branch and compile it in isolation:

```
git checkout Stack
javac *.java
```

## Roadmap

Done:

- [x] Linked list — reverse (iterative/recursive), cycle detection, middle, merge, palindrome, and more
- [x] Stack (built on the linked list)
- [x] Queue (head + tail pointers)
- [x] Hash map from scratch (buckets + collision handling)
- [x] Binary search tree — insert, search, delete, traversals, and classic queries
- [x] Dynamic array (`ArrayList` from scratch) — raw backing array + resize-on-grow

Next up:

- [ ] Min-heap / priority queue — array-backed, sift-up/sift-down
- [ ] Graph — adjacency list with BFS and DFS
- [ ] Trie — prefix tree for string lookups
- [ ] Self-balancing BST (AVL or red-black) — keep the tree height-balanced on insert/delete
