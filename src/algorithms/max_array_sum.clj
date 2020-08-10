(ns algorithms.max-array-sum)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Hacker Rank - Problem Solving
;; https://www.hackerrank.com/challenges/max-array-sum/problem
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; [-2, 1, 3, -4, 5]

;; 2:: ss([3, -4, 5])
;; 2::ss(3::ss([5]))
;; [2,3,5]

;; [-2, 3, 5]
;; [-2, 3]
;; [-2, -4]
;; [-2, 5]
;; [1, -4]
;; [1, 5]
;; [3, 5]


;; [2 3 4 5]
;; [2 3]  (4 5)
;;     [2 3 4] (5)
;;     [2 3 4 5) ()
;; [2 4] (5)
;;     [2 4 5] ()
;; [2 5]

(defn combine [n array]
  (if (empty? array) array
      (loop [[x & xs] array result []]
        (let [ys (conj n x)]
          (if (empty? xs)
            (concat result ys)
            (recur xs (concat result (cons ys (combine ys xs)))))))))

(defn get-subsets [arr]
  )

(defn maxSubsetSum [arr]
  (->> (get-subsets arr)
       (map #(reduce + %))
       (reduce max)))
