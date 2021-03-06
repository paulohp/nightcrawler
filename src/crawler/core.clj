(ns crawler.core
  (:gen-class)
  (:use [org.httpkit.client :as http])
  (:use [clojure.java.io :only [output-stream, writer]])
  (:use pl.danieljanus.tagsoup)
  (:require [hiccup-find.core :refer :all])
  (:require [monger.core :as mg]
            [monger.gridfs :refer [store-file make-input-file filename content-type metadata]]
            )
  (:import [com.mongodb MongoOptions ServerAddress]) 
)

(defn -main
  "I don't do a whole lot ... yet."
  [& args] 
  (let [response1(http/get "http://americanas.com")]
  (def date (java.util.Date.))
  (def fileName (str "/tmp/" date "-americanas.html" ))
  (with-open [wrtr (writer fileName)]
    (.write wrtr (:body @response1))
    )
  (def html-parsed (parse-string (:body @response1))))
  
  (let [conn (mg/connect)
        db   (mg/get-db conn "crawler")
        fs   (mg/get-gridfs conn "crawler")]
        (store-file (make-input-file fs fileName)
              (filename (str date "-americanas.html"))
              (metadata {:format "html"})
              (content-type "text/html")))
)
