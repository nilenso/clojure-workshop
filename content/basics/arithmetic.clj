(ns content.basics.arithmetic)

;; Numbers
1
(class 1)

;; arbitrary large
(* 1000 1000)
(* 10000000000000000000000 1000000000000000000)

;; rationals
;; no loss of precision
22/7
(* 7 22/7)
(* 3 (float 1/3))
(* 3 1/3)

;; ASMD
(+)
(+ 1)
(+ 1 2)
(+ 1 2 3 4 5)

(*)
(* 1)
(* 1 2)
(* 1 2 3 4 5)

;; introduce paredit at this point

;; Computation: + - * / inc dec quot rem min max
;; Comparison: == < ⇐ > >= zero? pos? neg?
;; Bitwise operations: bit-and bit-or bit-xor bit-not bit-shift-right bit-shift-left
;; Ratios: numerator denominator
;; Coercions: int bigdec bigint double float long num short

;; java.lang.Math is fully available, and doesn't need to build into clojure
Math/PI
(Math/sin 90)
(Math/pow 3 4)
(Math/sqrt 16)

[127 0x7F 0177 32r3V 2r01111111]
10.7e-3
991778647261948849222819828311491035886734385827028118707676848307166514
;; Excerpt From: Michael Fogus. “The Joy of Clojure, Second Edition, MEAP V08.” iBooks.
