(ns interview-prep.problems)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Hacker Rank Inteview Preparation: Warm-up Challenges
; https://www.hackerrank.com/challenges/counting-valleys/problem
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn- decode-step [s]
 (case s
  \U 1
  \D -1))

(defn- valley? [[x y]]
 (and (= x -1) (= y 0)))

(defn counting-valleys [n s]
 (let [hike (reductions + (map decode-step s))]
  (count (filter valley? (map vector hike (rest hike))))))