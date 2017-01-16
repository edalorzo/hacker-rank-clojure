(ns week-of-code.lucky-number-eight-test
  (:require [clojure.test :refer :all]
            [week-of-code.lucky-number-eight :refer :all]))

(deftest test-divisibility-by-8
  (testing "with one and two digit numbers"
    (is (divisible-by-eight? "8"))
    (is (divisible-by-eight? "16"))
    (is (divisible-by-eight? "32"))
    (is (divisible-by-eight? "64")))
  (testing "with three digit numbers"
    (is (divisible-by-eight? "128"))
    (is (divisible-by-eight? "256"))
    (is (divisible-by-eight? "512")))
  (testing "with four digit numbers"
    (is (divisible-by-eight? "1024"))
    (is (divisible-by-eight? "2048"))
    (is (divisible-by-eight? "4096"))))

(deftest not-divisible-by-8
  (testing "with one and two digit numbers"
    (is (not (divisible-by-eight? "9")))
    (is (not (divisible-by-eight? "18")))
    (is (not (divisible-by-eight? "36")))
    (is (not (divisible-by-eight? "73"))))
  (testing "with three digit numbers"
    (is (not (divisible-by-eight? "146")))
    (is (not (divisible-by-eight? "292")))
    (is (not (divisible-by-eight? "585"))))
  (testing "with four digit numbers"
    (is (not (divisible-by-eight? "1170")))
    (is (not (divisible-by-eight? "2340")))
    (is (not (divisible-by-eight? "4681")))))
  
  

