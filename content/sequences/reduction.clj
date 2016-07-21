(ns content.sequences.reduction)

;; frequencies
(frequencies [:a :b :a :a :b])


;; group-by
(group-by odd? [1 2 3 4 5])

;; reduce
(reduce + [1 2 3 4])

;; into
(into {} [[:a 2] [:b 3]])
