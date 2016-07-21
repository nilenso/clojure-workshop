(ns content.basics.symkeys)

;; Strings!
;; Are java strings

;; Characters
;; Are java characters. Boxed though.

;; Keywords
;; Identifier that evaluates to itself
;; Like enumerated value. Just a name, but different from other values.
;; Like symbols in ruby
;; Fast comparison
;; Two keywords that are spelt the same are the same object
;; Good to have keys in maps for this reason
:a
:person-name
(= :person-name :person-name)
{:person-name "govind"}
;; evaluates to itself

;; Symbols
;; Identifier that evaluates to something else
x
'x ;; tells the evaluator - do not evaluate it
(quote x)

;; namespaced
'foo/bar
(name 'foo/bar)
(namespace 'foo/bar)

;; most of what the compiler sees are symbols. lists of symbols.

;; support Metadata
;; metadata are arbitrary annotation of data
;; used to give information to compiler about types
;; also used by humans to annotate anything useful
(def ^{:doc "this demonstrates metadata"} foo nil)
(meta #'foo)
(def ^:dynamic foo nil)
(meta #'foo)
(def ^String foo nil)
(meta #'foo)
