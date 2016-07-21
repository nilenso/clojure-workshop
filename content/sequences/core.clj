(ns content.sequences.core)

;; car
;; first - the head of a sequence
(first [1 2 3])
(first [1])
(first [])
(first nil)

;; cdr
;; rest - the tail of a sequence
(rest [1 2 3])
(rest [1 2])
(rest [1])
(rest [])
(rest nil)

;; cons(truct)
(cons 1 [])
(cons 1 [2 3])
(cons nil [])

;; All aggregate data structure in Clojure can be viewed as a sequence
;; - Stuart Halloway, Programming Clojure

;; clojure.lang.ISeq

;; maps
(seq {:a :b :c :d})
(first {:a :b :c :d})
(rest {:a :b :c :d})
(cons [:e :f] {:a :b :c :d})

;; sets
(seq #{:a :b :c :d})
(first #{:a :b :c :d})
(rest #{:a :b :c :d})
(cons :e #{:a :b :c :d})

;; lists
(seq '(1 2 3 4))

;; vectors
(seq [1 2 3 4])

;; empty seqs, nil
(seq [])
(seq nil)

;; conj
