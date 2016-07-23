(ns content.basics.destructuring)

;; let binding
(let [a 1] a)

(let [a 1
      b 2]
  {:a a
   :b b})

(def things ["apple" "orange" "banana"])

(let [a (nth things 0)
      o (nth things 1)
      b (nth things 2)]
  {:a a :o o :b b})

(let [[a o b] things]
  {:a a :o o :b b})

;; destructuring
;; pull things structurally apart
(let [[f s & r :as nums] [1 2 3 4 5 6]]
  {:f f
   :s s
   :r r
   :nums nums})

(let [{:keys [name age] :as person} {:name "srihari" :age 42}]
  {:name name
   :age age
   :person person})
