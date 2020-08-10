(ns algorithms.knapsack-test
  (:require [algorithms.knapsack :as ks]
            [clojure.test :refer :all]))

(deftest testing-knapsack
  (testing "HackerRank Basic Examples"
    (is (= 10 (ks/unboundedKnapsack 10 [2 3 4])))
    (is (= 12 (ks/unboundedKnapsack 12 [1 6 9])))
    (is (= 9 (ks/unboundedKnapsack 9 [3 4 4 8])))))
