
(ns func-proc.func-check)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;
;; FUNCTION OR NOT
;; https://www.hackerrank.com/challenges/functions-or-not/problem
;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


(require '[clojure.string :as str])

(defn is-function [pairs]
  (loop [[[d r] & more] pairs rel {}]
    (if-let [found (get rel d)]
      (if (= found r) (recur more rel) "NO")
      (if-not more "YES" (recur more (assoc rel d r))))))


(comment
  (let [t (Integer/parseInt (str/trim (read-line)))]
    (dotimes [_ t]
      (letfn [(read-pairs []
               (loop [n (Integer/parseInt (str/trim (read-line))) pairs []]
                 (if (zero? n) pairs
                   (let [pair (str/split (read-line) #" ")]                    
                     (recur (dec n) (conj pairs (vec (map #(Integer/parseInt %) pair))))))))]
       (println (is-function (read-pairs)))))))  
