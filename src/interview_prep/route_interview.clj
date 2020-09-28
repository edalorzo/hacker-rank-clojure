(ns interview-prep.route-interview
  (:require [clojure.string :refer :all])
  )

(defn can-sum? [l amount]
  (if (= amount 0)
    true
    (if (or (< amount 0) (empty? l))
      false
      (or
       (can-sum? (rest l) amount)
       (can-sum? (rest l) (- amount (first l)))))))


(can-sum? [1 10 20 30] 40)
(can-sum? [1 10 20 30] 41)
(can-sum? [10 30] 40)
(can-sum? [100 90 80] 40)
(can-sum? [100 90 80 30 10] 40)


(defn primes-to
  "Computes a prime numbers up to n using the sieve of Eratosthenes"
  [n]
  (let [root (-> n Math/sqrt long),
        primality (boolean-array (inc n)),
        sieve (fn [p]
                (loop [i (* p p)]
                  (when (<= i n)
                    (aset primality i true)
                    (recur (+ i p)))))]

    (dorun (->> (range 2 (inc root))
                (filter #(not (aget primality %)))
                (map #(sieve %))))

    (filter #(not (aget primality %)) (range 2 (inc n)))))

(time (take 20 (primes-to 100)))


(defn divides? [x y] (= (rem y x) 0))


(defn sieve [stream]
  (lazy-seq
   (let [[x & xs] stream]
     (cons x (sieve (filter #(not (divides? x %1)) xs))))))

(def primes (cons 2 (sieve (iterate #(+ % 2) 3))))

(defn sieve [stream]
  (lazy-seq
   (let [x (first stream) xs (if (= x 2)
                               (rest stream)
                               (loop [[p' & ps :as xs] (rest stream) p (* x x) found []]
                                 (if (> p' p)
                                   (concat found xs)
                                   (recur ps p (conj found p')))))]
     (cons x (sieve (filter #(not (divides? x %1)) xs))))))

(defn sieve [stream]
  (lazy-seq
   (let [[p & ps] stream pp (* p p)]
     (println p)
     (loop [[p' & ps'] ps primes []]
       (if (< p' pp)
         (recur ps' (conj primes p'))
         (cons p (sieve (filter #(not (divides? p %1)) (concat primes ps')))))))))

(defn sieve [stream]
  (lazy-seq
   (let [[p & ps] stream pp (* p p)]
     (loop [[p' & ps'] ps primes []]
       (apply println [p' primes])
       (if (< p' pp)
         (recur ps' (conj primes p'))
         (concat [p] primes (sieve (filter (fn [x] (not-any? #(divides? x %1) primes)) ps'))))))))


;;(def primes (cons 2 (sieve (iterate #(+ % 2) 3))))
;;(def primes (cons 2 (sieve (iterate #(+ % 1) 2))))

(def primes (sieve (iterate #(+ % 1) 2)))

(take 5 primes)
(take-last 1 (take 1000 primes))

(take 1 (drop-while #(zero? (rem % 2)) [2 3 4 5 6 7 8 9 10]))



(defn integers-from [f n]
  (lazy-seq (cons n (integers-from f (f n)))))


(def odd-numbers (integers-from #(+ % 2) 3))
(def primes (cons 2 (sieve odd-numbers)))


(take 10 primes)
