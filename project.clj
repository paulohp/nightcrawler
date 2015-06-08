(defproject crawler "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [
    [org.clojure/clojure "1.6.0"],
    [http-kit "2.1.18"],
    [clj-tagsoup/clj-tagsoup "0.3.0" :exclusions [org.clojure/clojure]],
    [com.novemberain/monger "2.1.0"],
    [hiccup-find  "0.4.0"]
  ]
  :main ^:skip-aot crawler.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
