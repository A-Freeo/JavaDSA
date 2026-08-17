# JavaDSA — Dynamic Array (ArrayList)

A hand-implemented dynamic array — a generic list backed by a raw array that grows itself by
doubling capacity. Part of [JavaDSA](https://github.com/A-Freeo/JavaDSA)
(see the `main` branch for the overview).

## Files

- `ArrayList.java` — generic `ArrayList<T>` with `add`, `get`, `set`, `remove`, `indexOf`, `size`, `isEmpty`.

## Notes

- Starts at capacity 10; when full, `add` allocates a doubled array and copies over — giving
  amortized O(1) appends.
- `remove` shifts later elements left; `indexOf` is null-safe.

## Build

```
javac *.java
```
