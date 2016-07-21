(ns wikiscrape.core
  (:import [org.jsoup Jsoup]))

(defn fetch-html [url]
  (.get (Jsoup/connect url)))

(defn sanitize-html [url])

(defn write-santized-html-to-file [sanitized-document])

(defn scrape [url]
  (-> url
      fetch-html
      sanitize-html
      write-santized-html-to-file))
