---
layout: docs
title: "Functions"
author: M.C. Oscar Vargas Torres
link-citations: true
bibliography: scala-essentials.bib
pandoc-latex-fontsize:
  - classes: [scala, listing]
    size: footnotesize
pandoc-latex-admonition:
# order is important
  - color: firebrick
    classes: [admonition, danger]
    topline: true
  - color: gray
    classes: [admonition]
    linewidth: 4
header-includes: |
  \usepackage{titling}
  \usepackage{fancyhdr}
  \pagestyle{fancy}
  \fancyfoot[CO,CE]{Intersys Consulting}
  \fancyfoot[LE,RO]{\thepage}
---

# Functions

**Note**: We will use [@sls_212] as much as possible as an authoritative reference.

## Function types

The following is an example of a simple function:

```{.scala .listing}
val triple = (n: Int) => n * 3
```

The *type* of this function literal is: `Int => Int`. We could have used the
*type annotation* to define triple:

```{.scala .listing}
val triple: Int => Int = n => n * 3
```

That can be read like:

> `triple` is a function that accepts an `Int` parameter and returns an `Int`

In general [@sls_212_function_types], to declare a **function type**, write

```{.scala .listing}
(A, B, ...) => C
println("Hello, World!")
```

where

* `A`, `B`, ... are the types of the input parameters; and
* `C` is the type of the result.

::: {.admonition} :::

### Naming conventions

Scala names are case sensitive. You will find naming conventions for constants, values, variables
and methods in @naming_conventions_constants-values-variable-methods.

Can you tell why the following would *not* be a good
name?

```{.scala .listing .admonition .danger}
val Triple = (n: Float) => n * 3.0f
```

::::::

According to [@sls_212_function_types]:

* Function types associate to the right, e.g. `S => T => U` is the same as `S => (T => U)`.
* An argument type of the form `=> T` represents a call-by-name parameter of type `T`.

### Relationship between methods and functions: eta--expansion

There is a close relationship between methods and functions, by means of the eta--expansion. See
[@expressions_method-values]. For example,

```{.scala .listing}
def f1(n: Int): Int = n * 2

# Placeholder syntax
val f2: Int => Int = f1 _

# eta-expansion: equivalent to placeholder syntax
val f3: Int => Int = n => f1(n)
```

Given this close relationship, you will find methods referred to as "functions", although they are
not strictly the same.

### Return value of a block

The last expression of a block becomes the value that the function returns. For example, the
following method returns the value of `r` after the `for` loop (no need for the `return` keyword):

```{.scala .listing}
def fac(n: Int) = {
  var r = 1
  for (i <- 1 to n)
    r = r * i
  r
}
```

### Recursive functions/methods must specify the return type

```{.scala .listing}
def fac(n: Int): Int =
  if (n <= 0) 1
  else n * fac(n - 1)
```

### Varargs syntax

```{.scala .listing}
def sum(args: Int*): Int = {
  var result = 0
  for (arg <- args)
    result += arg
  result

val s = sum(1 to 5: _*)
```

### Procedures have `Unit` return value

```{.scala .listing}
def box(s : String) { // Look carefully: no =
  // contents elided
}

// (Equivalent) Explicit return type
def box(s : String): Unit = {
  // contents elided
}
```

### Scaladoc for `Function1`

Open @scaladoc_standard-library-current and search documentation for trait `Function1`. You should
see documentation for important methods like `apply`, `andThen` and `compose`.

#### `apply`

In the following example (taken from `Function1` scaladoc), the definition of `succ` is a shorthand
for the anonymous class definition `anonfun1`:

```{.scala .listing}
object Main extends App {
   val succ = (x: Int) => x + 1
   val anonfun1 = new Function1[Int, Int] {
     def apply(x: Int): Int = x + 1
   }
   assert(succ(0) == anonfun1(0))
}
```

#### `compose` and `andThen`

It has the following signature

```{.scala .listing}
def compose[A](g: (A) => T1): (A) => R
```

It models the mathematical function composition. For example, if $f(x) = x + 1$ and $g(x) = 2x$,
\begin{align}
(f \cdot g)(x) &= f(g(x)) = 2x + 1 \\
(g \cdot f)(x) &= g(f(x)) = 2(x + 1)
\end{align}

Using Scala:

```{.scala .listing}
val f: Int => Int = x => x + 1
val g: Int => Int = x => 2 * x

// f "after" g, or g "then" f
// fg(x) = 2x + 1
val fg: Int => Int = f compose g

// g "after" f, or f "then" g
// gf1(x) = 2(x + 1)
val gf1: Int => Int = f andThen g
gf1(3)
// equivalently
val gf2: Int => Int = g compose f
gf2(3)
```

## Composition

We have reviewed composition in the mathematical sense. This may seem too theoretical, but is a
wonderful tool to get complex solutions from smaller building blocks. We are going to use `atto`, a
parsing library that has uses `andThen` to build a new parser from smaller parsers. Spend some time
studying [@norris_atto-basic-parsers].

### Exercise

* Discuss your understanding on Basic Parsers with others (based on [@norris_atto-basic-parsers]).
* Following [@norris_atto-parsing-log-entries] tutorial, replicate the example given in your
  development machine.
* TBD: Build a perser for ...

## Currying



## Generics and parametric polymorphism

## Functions and Dependency Injection

# References