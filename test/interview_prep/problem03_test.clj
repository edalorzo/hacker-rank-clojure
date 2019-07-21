(ns interview-prep.problem03-test
    (:require [clojure.test :refer :all]
              [interview-prep.problem03 :refer :all]))
                

(deftest testing-rotations
 (testing "Array Rotations"
   (is (= (rotLeft [1 2 3 4 5] 1) [2 3 4 5 1]))   
   (is (= (rotLeft [1 2 3 4 5] 2) [3 4 5 1 2]))   
   (is (= (rotLeft [1 2 3 4 5] 3) [4 5 1 2 3]))  
   (is (= (rotLeft [1 2 3 4 5] 4) [5 1 2 3 4]))   
   (is (= (rotLeft [1 2 3 4 5] 5) [1 2 3 4 5]))
   (is (= (rotLeft [1 2 3 4 5] 6) [2 3 4 5 1])))) 