(ns interview-prep.problem06)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Hacker Rank Inteview Preparation: Warm-up Challenges
; https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn- count-jumps [[from & to]]
  (if (empty? to) 0
      (let [found (take 2 (take-while #(not= % 1) to))]
        (case (count found)
          2 (+ 1 (count-jumps (drop 1 to)))
          1 (+ 1 (count-jumps to))
          0 (+ 1 (count-jumps (drop 1 to)))))))

(defn jumpingOnClouds [clouds]
  (count-jumps clouds))






