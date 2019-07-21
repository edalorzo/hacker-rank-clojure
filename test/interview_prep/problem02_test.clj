(ns interview-prep.problem02-test
    (:require [clojure.test :refer :all]            		
            		[interview-prep.problem02 :refer :all]))

(deftest hour-glass-tests

  (testing "Hour Glass Containment"
    (is (belongs-to? [0,0] [0,0]))
    (is (belongs-to? [0,0] [1,0]))
    (is (belongs-to? [0,0] [2,0]))
    (is (not (belongs-to? [0,0] [0,1])))
    (is (belongs-to? [0,0] [1,1]))
    (is (not (belongs-to? [0,0] [2,1])))
    (is (belongs-to? [0,0] [0,2]))    
    (is (belongs-to? [0,0] [1,2]))    
    (is (belongs-to? [0,0] [2,2])))

  (testing "Hour Glass Maximum"
  
    (let [hg1 [[-9 -9 -9  1 1 1] 
               [ 0 -9  0  4 3 2]
               [-9 -9 -9  1 2 3]
               [ 0  0  8  6 6 0]
               [ 0  0  0 -2 0 0]
               [ 0  0  1  2 4 0]]
          hg2 [[ 1  1  1  0 0 0]
               [ 0  1  0  0 0 0]
               [ 1  1  1  0 0 0]
               [ 0  0  2  4 4 0]
               [ 0  0  0  2 0 0]
               [ 0  0  1  2 4 0]]]
               
      (is (= (hourglassSum hg1) 28))
      (is (= (hourglassSum hg2) 19)))))

  

