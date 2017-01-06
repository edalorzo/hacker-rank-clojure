(ns project-euler.euler09-test
  (:require [clojure.test :refer :all]
            [project-euler.euler09 :refer :all]))

(deftest test-gdc
  (testing "with positive numbers"
    (is (= 4 (gcd 8 12)))
    (is (= 6 (gcd 54 24)))
    (is (= 14 (gcd 42 56)))
    (is (= 6 (gcd 18 84)))
    (is (= 8 (gcd 8 0)))
    (is (= 8 (gcd 0 8)))
    (is (= 0 (gcd 0 0))))
  (testing "with coprimes"
    (is (= 1 (gcd 3 5)))
    (is (= 1 (gcd 2 3)))
    (is (= 1 (gcd 7 11)))
    (is (= 1 (gcd 13 17))))
  (testing "with negative numbers"
    (is (thrown? AssertionError (gcd -1 2)))
    (is (thrown? AssertionError (gcd 2 -2)))))

(deftest test-coprime
  (testing "with coprimes"
    (is (coprime? 1 3))
    (is (coprime? 3 5))
    (is (coprime? 5 7))
    (is (coprime? 7 11))
    (is (coprime? 11 13))
    (is (coprime? 15 17))
    (is (coprime? 17 19)))
  (testing "with not coprimes"
    (is (not (coprime? 8 12)))
    (is (not (coprime? 54 24)))
    (is (not (coprime? 42 56)))
    (is (not (coprime? 8 12)))
    (is (not (coprime? 8 0)))))

(deftest test-coprimes
  (testing "with coprimes sequence"
    (is (= '([2 1]) (coprimes 3)))
    (is (= '([2 1] [3 2]) (coprimes 4)))
    (is (= '([2 1] [3 2] [4 1] [4 3]) (coprimes 5)))
    (is (= '([2 1] [3 2] [4 1] [4 3] [5 2] [5 4]) (coprimes 6)))
    (is (= '([2 1] [3 2] [4 1] [4 3] [5 2] [5 4] [6 1] [6 5]) (coprimes 7)))
    (is (= '([2 1] [3 2] [4 1] [4 3] [5 2] [5 4] [6 1] [6 5] [7 2] [7 4] [7 6]) (coprimes 8)))))



