(ns content.sequences.transform)

;; map
(map inc [1 2 3])

;; reverse
(reverse [1 2 3])

;; shuffle
(shuffle [1 2 3])

;; multiple lists
(map (fn [thing color] (str thing " is " color))
     ["clock" "shelf" "door"]
     [:white :green :black])

;; map indexed
(map-indexed (fn [i thing] (str thing " is " i))
             ["clock" "shelf" "door"])

;; concat
(concat ["clock" "shelf" "door"]
        [:white :green :black])

;; interleave
(interleave ["clock" "shelf" "door"]
            [:white :green :black])
