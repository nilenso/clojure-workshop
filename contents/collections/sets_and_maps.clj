(ns sets-and-maps)

;; SETS
;; unordered collections
;; literal
#{}

#{:a :b :c}

;; use set function to make set out of any collection
(set [1 2 3])

;; or use into
(into #{} [1 2 3 4])

;; use hash-set
(hash-set [1 2 3])

;; sorted-set
(sorted-set [1 4 3])

;; to get them sorted
(sort #{:a :b :c})

;; no duplicates
#{:a :a :a}

;; add elements
(conj #{:a :a :a} :b)

;; remove elements
(disj #{:a :b :c} :a)

;; contains?
(contains? #{1 2 3} 2)

;; get
(get #{1 2 3} 2)

;; or use set as a function to get values
(#{1 2 3} 2)

;; sets can be used as functions/predicate for collections
(every? #{0 1} [0 1 0 1 1 1 0 0 1 1 0])


;; MAPS
;; Maps are collections in clojure
;; Essentially Key Value pairs

;; Literal
;; Empty map
{}

;; Maps support hetrogenous keys
;; keywords as keys - the norm
{:name "Foo" :age 20}

;; string as keys
{"name" "Foo" "age" 20}

;; even vectors / integers as keys
{[1 2] "Foo" 1 20}

;; use into to construct maps from a sequence
(into {} [[:name "Foo"] [:age 20]])

;; Def a maps
(def person {:name "Foo"
             :age 20
             :profile {:username "foobar"
                       :address {:house 100
                                 :city "Bangalore"
                                 :pincode 560038}} })

;; Are persistant data structures - immutable in nature
(let [a {:name "Foo" :age 20}]
  (assoc a :occupation "bar")
  a)

;; contains?
;; check if a key exists in a map
(contains? {:a 1} :a)

;; keys
;; returns a list of keys
(keys person)

;; vals
;; returns a list of vals
(vals person)

;; how to check if a map contains a set of keys ?
(every? person #{:name :age})

;; check if it atleast contains one key

;; Lookup
;; As a key value pair - you need to get values for various keys
;; use the get function to get value from the map
(get person :name)

;; keywords can be used as functions too. Idiomatic
(:name person)

;; alternatively, maps can be used as function to get values.
(person :name)

;; in case of nested maps ?
(get-in person [:profile :address :city])

;; so can we do it with map as function ?
(person :profile :address :city) ;; NO
;; alternatively, you can use threading macro to get this done
(->> person :profile :address :city)
;; which essentially translates to
(:city (:address (:profile person)))

;; get-in comes with a not-found parameter that can be passed
(get-in person [:profile :alternate-address] "NA")

;; assoc - assoc[iate]
;; returns a new map with supplied kvs
(assoc {} :a 10 :b 20)

(assoc person :alternate-address {:house 110
                                  :city "Delhi"})

;; but what if you want to add to nested maps ?
(assoc-in person [:profile :alternate-address] {:house 110
                                                :city "Delhi"})

;; dissoc - dissoc[iate]
;; returns a new map without the supplied keys
(dissoc person :address)

;; dissoc multiples keys
(dissoc {:a 1 :b 2 :c 3} :a :c)

;; update
;; returns a new map with the values updated for given keys
(update person :age inc)

;; (update map key function & args)
(update person :age + 20)

;; update-in
;; update - but nested
(update-in person [:profile :address :house] + 100)

;; select-keys
;; returns a map with only the selected keys
(select-keys person [:profile])

;; merge
;; returns a new map after merging the given maps
(merge {:a 1} {:b 2} {:c 3})

(merge {:a 1} nil)

;; doseq
;; loop over key-value pairs
(doseq [[k v] person]
  (println "key:" (name k) " value:" v))

;; destructuring
;; destructuring into a map, like in vectors if a key is not found
;; the symbol is bound to nil
;; use :as keyword to bind the symbol to the whole map
(let [{fname :name
       age :age
       work :work
       :as user} person]
  (println fname)
  (println age)
  (println work)
  (println user))

;; incase not found, you can use the :or keyword to set default
(let [{fname :name
       age :age
       work :work
       :or {work "NA"}} person]
  (println fname)
  (println age)
  (println work))

;; destructure nested maps
(let [{{address :address} :profile} person]
  (println address))

;; when you are using the same symbol as the keywords
(let [{:keys [name age]} person]
  (println name age))

;; nested maps
(let [{:keys [name age]
       {:keys [username address]} :profile} person]
  (println username address))

;; destructuring in fn arguments
(defn connect-db [{:keys [host port db-name username password]
                   :or   {host     "localhost"
                          port     5671
                          db-name  "clojure-workshop"
                          username "db-user"
                          password "password"}
                   :as cfg}]
  (println "connecting to:" host "port:" port "db-name:" db-name
            "username:" username "password:" password))

(connect-db {:host "server"})

(connect-db {:host "server" :username "user2" :password "Passowrd1"})

;; different kinds of maps
;; array-map
;; use array-maps if insert order is important
(array-map :z "Z" :a "A" :b "B")

;; hash-map
;; generic maps in clojure, better access time
(hash-map :a "A" :b "B" :c "C")

;; sorted-map
(sorted-map :a "A" :b "B")

;; when using literal to create maps
;; for a small sizes clojure creates array-map
;; for larger sizes clojure creats hash-map
(defn make-map [count]
  (zipmap (range count) (range count)))

;; makes a map of 9 key value pairs
;; array-map
(type (make-map 9))

;; makes a map of 10 key value pairs
;; hash-map
(type (make-map 10))

;; https://github.com/clojure/clojure/blob/master/src/jvm/clojure/lang/PersistentArrayMap.java#L33

;; used in config edn files

;; useful set of functions
;; https://github.com/weavejester/medley
