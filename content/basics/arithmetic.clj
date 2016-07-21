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

;; Computation: + - * / inc dec quot rem min max
;; Comparison: == < ⇐ > >= zero? pos? neg?
;; Bitwise operations: bit-and bit-or bit-xor bit-not bit-shift-right bit-shift-left
;; Ratios: numerator denominator
;; Coercions: int bigdec bigint double float long num short

;; java.lang.Math is fully available, and doesn't need to build into clojure
