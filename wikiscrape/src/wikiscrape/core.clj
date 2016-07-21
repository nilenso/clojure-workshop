(ns wikiscrape.core
  (require [clojure.java.io :as io])
  (:import [org.jsoup Jsoup]))

(defn fetch-html [url]
  (.get (Jsoup/connect url)))

(defn sanitize-html [url])

(defn write-santized-html-to-file [{:keys [title] :as sanitized-document}]
  (spit (str title ".edn") (pr-str sanitized-document)))

(defn scrape [url]
  (-> url
      fetch-html
      sanitize-html
      write-santized-html-to-file))
