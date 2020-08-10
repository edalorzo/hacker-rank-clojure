(ns algorithms.knapsack)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Hacker Rank Algorithms: Dynamic Programming
;; https://www.hackerrank.com/challenges/unbounded-knapsack/problem
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn- with-array [k arr] (filter #(>= k %1) arr))

(def ks
  (memoize
   (fn [k arr]
     (if (or (empty? arr) (<= k 0))
       k
       (loop [xs (lazy-seq (map #(ks (- k %1) (with-array (- k %1) arr)) arr)) found nil]
         (let [found (if-not found (first xs) (min (first xs) found))]
           (if (or (zero? found) (empty? (rest xs)))
             found
             (recur (rest xs) found))))))))

(defn unboundedKnapsack [k arr]
  (- k (ks k (with-array k arr))))

(comment
  ;;hacker rank input reading
  (let [t (Integer/parseInt (clojure.string/trim (read-line))) fptr (get (System/getenv) "OUTPUT_PATH")]
    (dotimes [_ t]
      (let [nk (clojure.string/split (read-line) #" ")
            n (Integer/parseInt (clojure.string/trim (nth nk 0)))
            k (Integer/parseInt (clojure.string/trim (nth nk 1)))
            arr (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" ")))
            result (unboundedKnapsack k arr)]
        (spit fptr (str result "\n") :append true)))))






