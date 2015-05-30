(ns crawler.core
  (:gen-class)
  (:use [org.httpkit.client :as http])
  (:use clojure.java.io)
  (:require [monger.core :as mg]
            [monger.gridfs :refer [store-file make-input-file filename content-type metadata]]
            )
  (:import [com.mongodb MongoOptions ServerAddress]) 
)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [conn (mg/connect)
        db   (mg/get-db conn "crawler")
        fs   (mg/get-gridfs conn "crawler")
        ])
  (let [response1(http/get "http://americanas.com")]
  (def date (java.util.Date.))
  (def fileName (str "/tmp/" date "-americanas.html" ))
  (with-open [wrtr (writer fileName)]
    (.write wrtr (:body @response1))
    )
  )
  
)
