# JavaDSA — Stack

A hand-implemented LIFO stack (built on `Node`) with a controller of classic stack problems.
Part of [JavaDSA](https://github.com/A-Freeo/JavaDSA) (see the `main` branch for the overview).

## Files

- `Node.java` — supporting generic `Node<T>` the stack is built on.
- `Stack.java` — generic `Stack<T>` with `push`, `pop`, `peek`, `isEmpty`, `search`, `clear`.
- `StackController.java` — static algorithms operating on a stack.

## StackController methods

| Method | Problem |
|---|---|
| `reverse` | Reverse a stack |
| `isValidBrackets` | Check a string of brackets is balanced |
| `NextGreaterElements` | Next greater element for each entry |

## Build

```
javac *.java
```
