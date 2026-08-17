# JavaDSA — Queue

A hand-implemented FIFO queue (head + tail pointers) with a controller of classic queue problems.
Part of [JavaDSA](https://github.com/A-Freeo/JavaDSA) (see the `main` branch for the overview).

## Files

- `Node.java` — supporting generic `Node<T>` the queue is built on.
- `Queue.java` — generic `Queue<T>` with `enqueue`, `dequeue`, `peek`, `size`, `isEmpty`, `contains`, `clear`.
- `Stack.java` — supporting stack used by `reverse`.
- `QueueController.java` — static algorithms operating on a queue.

## QueueController methods

| Method | Problem |
|---|---|
| `reverse` | Reverse a queue (via a stack) |
| `reverseFirstK` | Reverse only the first k elements |
| `interleave` | Interleave the front and back halves |

## Build

```
javac *.java
```
