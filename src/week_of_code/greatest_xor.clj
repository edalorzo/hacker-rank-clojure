(ns week-of-code.greatest-xor)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Hacker Rank Week of Code 28: Great XOR
; https://www.hackerrank.com/contests/w28/challenges/the-great-xor
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;(map #(vec [% (bit-xor % 26)]) (range 1 26))

(defn- expand [a n]
  (let [limit (* a 2)]
    (loop [k a total 0]
      (if (< k limit)
        (let [x (bit-xor k n) k (inc k)]
          (if (> x n)
            (recur k (inc total))
            (recur k total)))
        total))))

(defn max-xor [n]
  (loop [k 0 answer 0]
    (let [a (bit-shift-left 1 k)]
      (if (< a n)
        (let [x (bit-xor a n) k (inc k)]
          (if (> x n)
            (recur k (+ answer (expand a n)))
            (recur k answer)))
        answer))))

