# JavaDSA — Hash Map

A hand-implemented hash map — an array of buckets with separate chaining — plus a controller
of classic hashing problems. Part of [JavaDSA](https://github.com/A-Freeo/JavaDSA)
(see the `main` branch for the overview).

## Files

- `Entry.java` — a key/value pair node used in the buckets' chains.
- `Map.java` — the map: `put`, `get`, `remove`, `containsKey`, `containsValue`.
- `MapController.java` — static algorithms built on the map.

## MapController methods

| Method | Problem |
|---|---|
| `twoSum` | Indices of a pair adding to a target |
| `twoSumValues` | Values of a pair adding to a target |
| `mostFrequent` | Most frequently occurring value |
| `containsDuplicate` | Whether any value repeats |
| `isAnagram` | Whether two strings are anagrams |

## Build

```
javac *.java
```
