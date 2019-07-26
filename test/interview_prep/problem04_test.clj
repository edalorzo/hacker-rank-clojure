(ns interview-prep.problem04-test
    (:require [clojure.test :refer :all]
              [interview-prep.problem04 :refer :all]))


(deftest testing-briberies
 (testing "HackerRank Test Cases"
  (is (= (minimumBribes [5 1 2 3 7 8 6 4]) "Too chaotic"))
  (is (= (minimumBribes [2 5 1 3 4]) "Too chaotic"))
  (is (= (minimumBribes [1 2 5 3 7 8 6 4]) 7))
  (is (= (minimumBribes [1 2 5 3 4 7 8 6]) 4))
  (is (= (minimumBribes [1 2 5 6 3 4 7 8]) 4))
  (is (= (minimumBribes [2 1 5 3 4]) 3))))
