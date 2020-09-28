(ns algorithms.max-array-sum)


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Hacker Rank - Problem Solving
;; https://www.hackerrank.com/challenges/max-array-sum/problem
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(require '[clojure.set :as set])

(defn get-subsets [arr acc]
	(if (seq arr)
		(let [[x & xs] arr
          ys (rest xs)
          c1 (set (for [y ys] (list x y)))
          zs (take-nth 2 ys)
          c2 (if (seq zs) (conj c1 (list* x zs)) c1)
          acc (set/union acc c2)]
      (recur xs acc))
    acc))

(defn maxSubsetSum [arr]
  (->> (get-subsets arr #{})
         (map #(reduce + %))
         (reduce max)))

(def my-list [-2, 1, 3, -4, 5])
(get-subsets my-list '())
(maxSubsetSum my-list)
