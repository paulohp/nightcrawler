(ns crawler.core
  (:gen-class)
  (:use [org.httpkit.client :as http])
  (:use [pl.danieljanus.tagsoup :as parse])
  )

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [response1(http/get "http://paulopires.me")]
  (parse (@response1))
  )
)
