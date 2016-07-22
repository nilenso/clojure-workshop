(ns content.basics.functions)

;; syntax, defining and calling functions
(defn sqr [x]
  (* x x))

(defn add-one [x]
  (+ 1))

(add-one (sqr 5))

;; multi argument
(defn distance [x y]
  (Math/sqrt
   (+ (sqr x) (sqr y))))

;; docstring
(defn distance
  "finds the distance of the point from the origin"
  [x y]
  (Math/sqrt
   (+ (sqr x) (sqr y))))

;; mutli-arity
(defn full-name
  ([first-name last-name]
   (str first-name " " last-name))
  ([first-name middle-name last-name]
   (str first-name " " middle-name " " last-name)))

;; overloading
(defn full-name
  ([first-name last-name]
   (full-name first-name "" last-name))
  ([first-name middle-name last-name]
   (str first-name " " middle-name " " last-name)))

;; varargs
(defn full-name [first-name & rest-names]
  (str first-name " " (clojure.string/join " " rest-names)))

;; destructuring
(defn distance [[x1 y1] [x2 y2]]
  (Math/sqrt
   (+ (sqr (- x1 x2))
      (sqr (- y1 y2)))))

;; contracts
(defn safe-sqrt [x]
  {:pre [(> x 0)]
   :post [(if (> x 1) (< % x) (> % x))]}
  (Math/sqrt x))

;; recursion
(defn tribonacci [n]
  {:pre [(>= n 0)]}
  (if (<= n 2)
    1
    (+ (tribonacci (dec n))
       (tribonacci (dec (dec n)))
       (tribonacci (dec (dec (dec n)))))))

;; exercise: for a vector
;; - sqr each number
;; - find even numbers
;; - find sum of numbers

;; higher order: map, filter, reduce

;; anonymous functions

;; functional data type - set, map, etc

;; partial functions
(defn log [level msg]
  (println (format "[%s] %s" (clojure.string/upper-case level) msg)))

(def debug (partial log "debug"))

(def info (partial log "info"))

;; composing functions - comp, juxt
(defn mk-msg [n]
  (str "I have " n " sticks"))

(def info-tribonacci
  (comp info mk-msg tribonacci))

(def j-info
  (juxt info mk-msg tribonacci))

;; closures
(defn log [level]
  (fn [msg]
    (println
     (format "[%s] %s" (clojure.string/upper-case level) msg))))

(def warn (log "warn"))

;; data > functions > macros
