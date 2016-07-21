(ns content.sequences.subs)

;; take
(take 2 (range))

;; drop
(drop 2 [1 2 3 4 5])

;; take-*
(take-nth 2 [1 2 3 4 5])
(take-last 2 [1 2 3 4 5])
(take-while #(< % 4) [1 2 3 4 5])

;; drop-*
(drop-last 3 [1 2 3 4 5])
(drop-while #(< % 4) [1 2 3 4 5])

;; split-*
(split-at 7 (range 10))
(split-with #(< % 5) (range 10))

;; filter
(filter odd? [1 2 3 4 5])
(remove even? [1 2 3 4 5])

;; partition
(partition 3 (range 10))
(partition-by #(< 5 %) (range 10))
