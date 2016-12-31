(ns project-euler.euler10-test
  (:require [clojure.test :refer :all]
            [project-euler.euler10 :refer :all]))

(deftest test-lowert-divisors
  (testing "with prime number"
    (is (= 1 (lowest-divisor 1)))
    (is (= 2 (lowest-divisor 2)))
    (is (= 3 (lowest-divisor 3)))
    (is (= 5 (lowest-divisor 5)))
    (is (= 7 (lowest-divisor 7)))
    (is (= 11 (lowest-divisor 11)))
    (is (= 13 (lowest-divisor 13)))
    (is (= 17 (lowest-divisor 17))))
  (testing "with composite numbers"
    (is (= 2 (lowest-divisor 4)))
    (is (= 2 (lowest-divisor 6)))
    (is (= 2 (lowest-divisor 8)))
    (is (= 3 (lowest-divisor 15)))))


(deftest test-prime-numbers
  (testing "with prime numbers"
    (is (prime? 2))
    (is (prime? 3))
    (is (prime? 5))
    (is (prime? 7))
    (is (prime? 11))
    (is (prime? 13))
    (is (prime? 17))
    (is (prime? 23))
    (is (prime? 29)))
  (testing "with composite numbers"
    (is (not (prime? 1)))
    (is (not (prime? 4)))
    (is (not (prime? 6)))
    (is (not (prime? 8)))
    (is (not (prime? 9)))
    (is (not (prime? 10)))
    (is (not (prime? 12)))
    (is (not (prime? 14)))
    (is (not (prime? 16))))
  (testing "contents of prime infinite sequence"
    (is (= '(2 3 5 7 11 13 17 19 23 29) (take 10 primes)))))

(deftest test-problem-solution
  (testing "with provided use cases"
    (is (= '(10 17) (get-prime-sum [5 10])))))





