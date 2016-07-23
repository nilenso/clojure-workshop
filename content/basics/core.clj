(ns content.basics.core)

;; Join Gitter
;; Start your REPLs!

;; REPL
;; - Reader => Independent thing. Reads strings, returns data structures
;; - Eval => Evaluate. Also an indpedent functionality. Both of these are accessible in regular clojure code.

;; Numbers, Strings, Characters, Keywords
;; evaluate to themselves
1
42
"hello"
\a
:ka-boom

;; Symbols
;; name for something
;; Evaluator tries to interpret the meaning of this thing
a

;; Other literals
[1 2 3]
["vector"]

;; Lists are special
;; Evaluator tries to call it.
(1 2 3)
;; 1 is not a functional thing. Or, not a function.

;; Map
;; Hash-map
{:a 1 :b 2}
{"a" 1 "b" 2}
{a 1 b 2} ;; doesn't work because it tries to find out what these symbols mean, and they don't mean anything yet.

(def a 1)
(def b 2)
(def c 3)
{a 1 b 2 c 3}
[a b c]

;; Important to note that the reader is an independent thing.
;; We can use it in our programs a la carte
;; THe language is defined in terms of datastructures, not characters and strings

;; lot richer in terms of datastructures than lisps traditionally
;; more like ruby/python/javascript in that sense

;; All clojure datastructures are
;; 1. immutable
;; 2. readable
;; 3. equatable/comparable by value. Given immutability, we can guarrantee that comparing by value is sensible. Conversly, if we were comparing mutable objects by value, that would be incorrect. A lot of languages do this by comparing identity, allowing you to define equality, etc. In rich's opinions, that is broken.

;; 1. immutable
(let [nums [1 2 3 4 5]]
  {:consd (cons 0 nums)
   :nums nums})

;; 2. readable
(read-string "[1 2 3 4 5]")
(read-string "(inc 1)")
(read-string "{:hello :there}")

;; Collections
;; Are manipulated via interfaces.
;; -> abstractions
;; -> anything that manipulated a map, can manipulate all maps
;; -> anything that manipulated a vector type, can manipulate all vector types

;; Sequences
;; -> Huge part of Clojure
;; -> All clojure collections are sequences. We can walk through them.
;; -> java.lang.Iterable
;; -> read part of java.util.Collection

;; nil
;; nothing
nil
;; Same as Java null
;; conditionals like if build on top of this
;; nil and false represent logical falsity. anything else is logically true.
;; sequence functions indicate nothing by nil -> nil punning
