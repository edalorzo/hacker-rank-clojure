(ns project-euler.euler35)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;
;; Circular Primes
;; https://www.hackerrank.com/contests/projecteuler/challenges/euler035/problem
;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn- divides? [k n] (zero? (rem n k)))

(declare prime?)
(declare lowest-prime-div)

(defn prime? [n]
  {:pre [(> n 1)]}
  (if (> n 1)
    (= (lowest-prime-div n) n)
    false))

(def primes1
  (let [prime? (memoize prime?)]
    (cons 2 (filter prime? (iterate #(+ %1 2) 3)))))

(defn lowest-prime-div
  ([n] (lowest-prime-div primes1 n))
  ([primes n]
   (let [[p & ps] primes]
     (cond
       (divides? p n) p
       (> (* p p) n) n
       :otherwise (recur ps n)))))

(defn- explode [n]
  (if-not (zero? n)
    (let [q (quot n 10) r (rem n 10)]
      (conj (explode (quot (- n r) 10)) r))
    []))

(defn- implode [xs]
  (let [size (count xs) pow10 (fn ([[i n]] (int (* n (Math/pow 10 i)))))]
    (apply + (map pow10 (zipmap (range (dec size) -1 -1) xs)))))

(defn rotations [n]
  (let [prime? (memoize prime?)]
    (loop [[d & ds :as ns] (explode n) xs [n] i (dec (count ns))]
      (if (zero? i)
        (distinct xs)
        (let [r (concat ds [d]) n (implode r)]
          (if (prime? n)
            (recur r (conj xs n) (dec i))
            []))))))

(comment
  ;;HackerRank input reading:
  (let [N (Integer/parseInt (read-line))]
    (->> (take-while #(< %1 N) primes1)
         (map rotations)
         (filter #(every? prime? %1))
         (flatten)
         (distinct)
         (reduce +)
         (println))))

