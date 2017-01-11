(ns week-of-code.greatest-xor)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Hacker Rank Week of Code 28: Great XOR
; https://www.hackerrank.com/contests/w28/challenges/the-great-xor
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;(map #(vec [% (bit-xor % 26)]) (range 1 26))

(defn expand [a n]
  (for [k (range a (* a 2)) 
        :let [x (bit-xor k n)]
        :while (> x n)]
    k))

(defn max-xor [n]
  (loop [k 0 answer []]
    (let [a (bit-shift-left 1 k)]
      (if (< a n)
        (let [x (bit-xor a n)]
          (if (> x n)
            (recur (inc k) (into answer (expand a n)))
            (recur (inc k) answer)))
        answer))))