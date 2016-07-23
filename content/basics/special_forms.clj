(ns content.basics.special-forms)

;; def
;; create a binding
(def x 42)
(def lst [42 1024 42])
(def amap {:a :b :c :d})

;; (if test then else)
(if (= 42 x)
  :boo-yeah
  :boo-hooo)

(if (= 42 21)
  (str "x" "what")
  (* 42 42))

;; do
;; returns the value of the last thing
(do "foo" "boo")
