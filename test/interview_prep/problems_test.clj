(ns interview-prep.problems-test
    (:require [clojure.test :refer :all]
            [interview-prep.problems :refer :all]))

(deftest test-valleys)

(deftest test-valley-count
 (testing "Counting Valleys"
  (is (= (counting-valleys 4 "DDUU") 1))  
  (is (= (counting-valleys 16 "DDDDUUUUDDDDUUUU") 2))
  (is (= (counting-valleys 6 "DDDUUU") 1))))  

  

