(ns content.sequences.build)

;; lazy and infinite sequences
(class (range))

;; range
(take 10 (range))

;; iterate
(take 10 (iterate inc 0))

;; repeat
(take 10 (repeat :x))

;; repeatedly
(take 10 (repeatedly rand))

;; cycle
(take 10 (cycle [:a :b :c]))
