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

(defn get-combinations [head tail]
  (if (> (count tail) 1)
    (let [[x & xs] tail h (str head x)]
      (lazy-seq (concat [(cons h xs)] (get-combinations head xs))))))

(defn get-sequences
  ([tail] 
   (get-sequences "" tail))
  ([head tail] 
   (if-let [seed (get-combinations head tail)]
    (let [subseqs (filter #(> (count (rest %)) 1) seed)
          subseqs (mapcat #(get-sequences (first %) (rest %)) subseqs)]
      (lazy-seq (concat seed subseqs))))))
  
(defn expand-sequence [tail]
  (let [expand-seq (fn [head tail] (map #(str head %) tail))
        sequences (get-sequences tail)
        combinations (mapcat #(expand-seq (first %) (rest %)) sequences)
        combinations (concat (map str (vec tail)) combinations)
        divisible? (memoize divisible-by-eight?)]
    (filter #(divisible? (take-last 3 %)) combinations)))

(defn solve [tail]
  (let [results (expand-sequence tail)]
    (reduce (fn [a b] (sum a 1)) 0 results)))
