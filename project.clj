(defproject hacker-rank-clojure "1.0.0"
  :description "HackerRank Solutions"
  :url "http://edalorzo.github.io"
  :dependencies [[org.clojure/clojure "1.10.1"]]
  :target-path "target/%s"
  :warn-on-reflection false
  :plugins [[lein-marginalia "0.9.1"]]
  :profiles {:uberjar {:aot :all}}
             ; :repl {:plugins [[venantius/ultra "0.6.0"]]}} 
  :repl-options {:prompt (fn [ns] (str "\u001B[35m[\u001B[34m" ns "\u001B[35m]\u001B[33m cλ:\u001B[m "))})
                 
                 
  
  
  
  
  
