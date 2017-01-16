(ns week-of-code.lucky-number-eight)

(use '[clojure.string :as str :only (join)])

;(def big-num (vec (map str (apply str (repeat 200000 "968")))))
;(defn my-reload [] (require '[week-of-code.lucky-number-eight :as woc] :reload))

(defn sum [a b]
  (let [a (mod a 1000000007)
        b (mod b 1000000007)
        c (mod (+ a b) 1000000007)]
    c))

(defn divisible-by-eight? [xs]
  (if (not-empty xs)
    (let [divides? (fn [x y] (zero? (mod y x)))]
      (->> xs
           (str/join)
           (Integer/parseInt)
           (divides? 8)))
    false))

(defn get-combinations [tail n]
  {:pre [(> n 0)]}
  (let [sub (str/join (take n tail))]
    (when (= (count sub) n)
      (lazy-seq (cons sub (get-combinations (rest tail) n))))))


(defn get-subsequence [head tail size]
  {:pre [(>= (count tail) size)]}
  (if (> size 0)
    (let [combs (get-combinations (rest tail) size)
          seqs (map #(str/join (concat head %)) combs)
          head (str head (first tail))
          tail (rest tail)]
        (lazy-seq (concat seqs (get-subsequence head tail (dec size)))))
    (lazy-seq (cons head nil))))

(defn get-sequence 
  
  ([tail] 
   (let [head (str (first tail))
         tail (rest tail)
         size (count tail)]
     (get-sequence head tail size)))
  
  ([head tail size]
   (when (>= size 0)
     (let [this (get-subsequence head tail size)
           that (get-sequence head tail (dec size))]
       (concat this that)))))


