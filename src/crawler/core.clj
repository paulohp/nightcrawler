(ns crawler.core
  (:gen-class)
  (:use [org.httpkit.client :as http])
  (:use clojure.java.io) 
  )

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [response1(http/get "http://americanas.com")]
  (with-open [wrtr (writer "/tmp/americanas.html")]
    (.write wrtr (:body @response1))
    )
  )
)
