(ns interview-prep.problem03)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Hacker Rank Inteview Preparation: Warm-up Challenges
; https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn rotLeft [a d]
 (let [n (count a)
       d (rem d n)
       l (subvec a 0 d)
       r (subvec a d n)]
   (concat r l)))
