(ns func-proc.super-digits-test
  (:require [clojure.test :refer :all]
            [func-proc.super-digits :refer :all]))

(deftest test-super-digits
  (testing "with provided use cases"
    (is (= 2 (super-digit 9875)))
    (is (= 3 (super-digit "148" 3)))))