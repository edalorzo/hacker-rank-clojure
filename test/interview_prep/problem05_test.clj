(ns interview-prep.problem05-test
    (:require [clojure.test :refer :all]
              [interview-prep.problem05 :refer :all]))


(deftest testing-minimum-swaps
 
 (testing "HackerRank Test Cases"
  (is (= (minimumSwaps [7 1 3 2 4 5 6]) 5))
  (is (= (minimumSwaps [4 3 1 2]) 3))
  (is (= (minimumSwaps [2 3 4 1 5]) 3))
  (is (= (minimumSwaps [1 3 5 2 4 6 7]) 3))))



