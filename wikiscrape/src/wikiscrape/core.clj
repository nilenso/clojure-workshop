(ns wikiscrape.core
  (require [clojure.java.io :as io]
           [clojure.string :as s])
  (:import [org.jsoup Jsoup]
           [org.jsoup.nodes Document Element]))

(def url-prefix
  "https://en.wikipedia.org")

(defn text [^Element e]
  (.text e))

(defn title [^Document doc]
  #_ (-> doc (.select "#firstHeading") .text)
  #_(.. doc (select "#firstHeading") text)
  (.text (.select doc "#firstHeading")))

(defn table-of-contents [^Document doc]
  (first (.select doc "#toc")))

(defn description [^Document doc]
  (->> (.select doc "#mw-content-text")
       first
       (.children)
       (take-while #(not= "toc" (.id %)))
       (filter #(= "p" (.tagName %)))
       (map text)
       (s/join "\n")))

(defn links-to-follow [^Document doc num-links]
  (->> (.select doc "#mw-content-text a")
       (map #(.attr % "href"))
       (filter #(.startsWith % "/wiki"))
       (distinct)
       (take num-links)
       vec))

(defn fetch-html [url]
  (.get (Jsoup/connect (str url-prefix url))))

(defn info [^Document doc num-links]
  {:title (title doc)
   :table-of-contents (table-of-contents doc)
   :description (description doc)
   :links-to-follow (links-to-follow doc num-links)})

(defn write-page [{:keys [title] :as page}]
  (let [filename (s/replace title #"\s|/" "_")]
    (spit (str "scraped/" filename ".edn") (pr-str page))))

(defn scrape [start-url depth num-links]
  (let [page (info (fetch-html start-url) num-links)]
    (write-page page)
    (when (pos? depth)
      (doall
       (map (fn [url]
              (scrape url (dec depth) num-links))
            (:links-to-follow page))))))

(comment
  (scrape "/wiki/Clojure" 1 5))
