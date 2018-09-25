---
layout: docs
title: "Functions"
---

# Functions

**Note**: We will use the [Scala Language Specification version 2.12](https://www.scala-lang.org/files/archive/spec/2.12/) as much as possible as an authoritative reference.

## Function types

The following is an example of a simple function:

```tut
val triple = (n: Int) => n * 3
```

The *type* of this function literal is: `Int => Int`. We could have used the *type annotation* to define triple:

```tut
val triple: Int => Int = n => n * 3
```

That can be read like:
> `triple` is a function that accepts an `Int` parameter and returns an `Int`

In general (see [Function Types]), to declare a **function type**, write

```scala
(A, B, ...) => C
```

where

* `A`, `B`, ... are the types of the input parameters; and
* `C` is the type of the result.

## References

### From the Scala Language Specification (SLS) 2.12

[Function Types]: https://www.scala-lang.org/files/archive/spec/2.12/03-types.html#function-types "SLS 2.12, section 3.2.9 Function Types"