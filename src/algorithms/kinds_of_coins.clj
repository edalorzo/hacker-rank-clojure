(ns algorithms.kinds-of-coins)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Hacker Rank Algorithms: Dynamic Programming
;; https://www.hackerrank.com/challenges/coin-change/problem
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


(comment
  ;; Version of Structure and Interpretation of Computer Programs
  (defn cc [amount kinds-of-coins]
    (cond
      (= amount 0) 1
      (or (< amount 0) (= kinds-of-coins 0)) 0
      :else (+ (cc amount (- kinds-of-coins 1))
               (cc (- amount (first-denomination kinds-of-coins)) kinds-of-coins))))

  (defn first-denomination [kinds-of-coins]
    (cond
      (= kinds-of-coins 1) 2
      (= kinds-of-coins 2) 3
      (= kinds-of-coins 3) 5
      (= kinds-of-coins 4) 6)))

(def cc
  (memoize
   (fn [amount kinds-of-coins]
    (cond
      (= amount 0) 1
      (or (< amount 0) (empty? kinds-of-coins)) 0
      :else (+ (cc amount (pop kinds-of-coins))
               (cc (- amount (peek kinds-of-coins)) kinds-of-coins))))))

(defn getWays [n c]
  (cc n (vec (sort c))))

;; (count-change 10 '(2 5 3 6))
;;(getWays 166 '(5 37 8 39 33 17 22 32 13 7 10 35 40 2 43 49 46 19 41 1 12 11 28))




