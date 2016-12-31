(ns project-euler.euler89-test
  (:require [clojure.test :refer :all]
            [project-euler.euler89 :refer :all]))


(deftest test-roman-to-decimal
  (testing "with good roman numbers"
    (is (= 1978 (roman-to-dec "MCMLXXVIII")))
    (is (= 369 (roman-to-dec "CCCLXIX")))
    (is (= 2751 (roman-to-dec "MMDCCLI")))
    (is (= 3999 (roman-to-dec "MMMCMXCIX")))
    (is (= 16 (roman-to-dec "XVI"))))
  (testing "with bad roman numbers"
    (is (= 16 (roman-to-dec "IIIIIIIIIIIIIIII")))
    (is (= 16 (roman-to-dec "VIIIIIIIIIII")))
    (is (= 16 (roman-to-dec "VVIIIIII")))
    (is (= 16 (roman-to-dec "XIIIIII")))
    (is (= 16 (roman-to-dec "VVVI")))))

(deftest test-decimal-to-roman
  (testing "decimal conversion"
    (is (= "MCMLXXVIII" (dec-to-roman 1978)))
    (is (= "CCCLXIX" (dec-to-roman 369)))
    (is (= "MMDCCLI" (dec-to-roman 2751)))
    (is (= "MMMCMXCIX" (dec-to-roman 3999)))
    (is (= "XVI" (dec-to-roman 16)))))

(deftest test-problem-solution
  (testing "with provided use cases"
    (let [solution (comp dec-to-roman roman-to-dec)]
      (is (= "V" (solution "V")))
      (is (= "XLV" (solution "VVVVVVVVV")))
      (is (= "MMMMMMMMMMMMMIV" (solution "MMMMMMMMMMMMMIIII")))
      (is (= "CC" (solution "LLLXXXXX")))
      (is (= "CCXX" (solution "CCXX"))))))


