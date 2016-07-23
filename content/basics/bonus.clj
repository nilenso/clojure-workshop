(ns content.basics.bonus)

(def frame (java.awt.Frame.))
(.isVisible frame)
(.setVisible frame true)
(.setSize frame (java.awt.Dimension. 200 200))

(def gfx (.getGraphics frame))
(.fillRect gfx 100 100 50 75)
(.setColor gfx (java.awt.Color. 255 128 0))
(.fillRect gfx 100 150 75 50)

;; Excerpt From: Michael Fogus. “The Joy of Clojure, Second Edition, MEAP V08.” iBooks.
