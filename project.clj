(defproject hacker-rank-clojure "1.0.0"
  :description "HackerRank Solutions"
  :url "http://edalorzo.github.io"
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}
             :user {:plugins [[venantius/ultra "0.5.0"]]}})
  
