(ns interview-prep.problem07)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Hacker Rank Inteview Preparation: Warm-up Challenges
; https://www.hackerrank.com/challenges/ctci-making-anagrams/problem
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(require '[clojure.set :as set])

(defn makeAnagram [a b]
  (let [left (frequencies a)
        right (frequencies b)
        keys (set/union (set (keys left)) (set (keys right)))]
    (reduce (fn [acc key]
              (let [l (get left key 0)
                    r (get right key 0)
                    diff (- l r)]
                (+ acc (Math/abs diff)))) 0 keys)))
