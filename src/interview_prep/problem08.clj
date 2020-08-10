(ns interview-prep.problem08)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Hacker Rank Inteview Preparation: Warm-up Challenges
; https://www.hackerrank.com/challenges/coin-change/problem
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn getWays [n c]
 (if (or (zero? n) (empty? c))
  nil))
    
