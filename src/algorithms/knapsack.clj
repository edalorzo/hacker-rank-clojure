(ns algorithms.knapsack)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Hacker Rank Algorithms: Dynamic Programming
;; https://www.hackerrank.com/challenges/unbounded-knapsack/problem
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn- with-array [k arr] (filter #(>= k %1) arr))

(defn- ks [k arr]
  (if-not (or (empty? arr) (<= k 0))
    (loop [[x & xs] (lazy-seq (map #(ks (- k %1) (with-array (- k %1) arr)) arr)) found nil]
      (let [found (if-not found x (min x found))]
        (if-not (or (zero? found) (empty? xs))
          (recur xs found)
          found)))
    k))

(defn unboundedKnapsack [k arr]
  (let [ks (memoize ks)]
    (- k (ks k (with-array k arr)))))

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






