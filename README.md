# JavaDSA — Binary Search Tree

A hand-implemented binary search tree with a controller of classic tree algorithms.
Part of [JavaDSA](https://github.com/A-Freeo/JavaDSA) (see the `main` branch for the overview).

## Files

- `TreeNode.java` — a tree node (value + left/right children).
- `BinarySearchTree.java` — core ops: `insert`, `search`, `delete`, `min`, `max`.
- `BinarySearchTreeController.java` — static tree algorithms.
- `Node.java` + `Queue.java` — supporting classes; `levelOrder` uses the `Queue`.

## BinarySearchTreeController methods

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

## Build

```
javac *.java
```
