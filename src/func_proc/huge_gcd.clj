(ns func-proc.huge-gcd)

(require '[clojure.string :as str])

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;
;; HUGE GCD
;; https://www.hackerrank.com/challenges/huge-gcd-fp/problem
;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn gcd [a b]
  (if-not (zero? b)
    (recur b (mod a b))
    a))

(defn solve [a b]
  (let [pa (reduce * a)
        pb (reduce * b)]
    (long (mod (gcd pa pb) 1000000007))))

(let [n (Integer/parseInt (str/trim (read-line)))
      a (vec (map #(bigint %) (str/split (read-line) #" ")))
      m (Integer/parseInt (str/trim (read-line)))
      b (vec (map #(bigint %) (str/split (read-line) #" ")))]
  (println (solve a b)))
