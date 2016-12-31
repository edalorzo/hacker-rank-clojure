(ns func-proc.fibonacci-test
  (:require [clojure.test :refer :all]
            [func-proc.fibonacci :refer :all]))

(deftest test-fibonacci-numbers
  (testing "with provided use cases"
    (is (= 1 (fibonacci 3)))
    (is (= 2 (fibonacci 4)))
    (is (= 3 (fibonacci 5)))))