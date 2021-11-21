(ns interview-prep.route-interview
  (:require [clojure.string :refer :all]))

(defn can-sum? [l amount]
  (if (= amount 0)
    true
    (if (or (< amount 0) (empty? l))
      false
      (or
       (can-sum? (rest l) amount)
       (can-sum? (rest l) (- amount (first l)))))))


(comment
  (can-sum? [1 10 20 30] 40)
  (can-sum? [1 10 20 30] 41)
  (can-sum? [10 30] 40)
  (can-sum? [100 90 80] 40)
  (can-sum? [100 90 80 30 10] 40))