(ns content.basics.intro-vectors)

(def a 1)
(def b 2)
(def c 3)
;; Lists
;; evaluated
;; quoted?
(a b c)
'(a b c)
;; what you had to do in most other lisps
;; in Clojure, generally prefer vectors for a list of values
[a b c]

;; play with it
(def nums [1 2 3])
(conj nums 4)
