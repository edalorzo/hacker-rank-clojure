(ns func-proc.super-digits)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; SUPER DIGITS
;; https://www.hackerrank.com/challenges/super-digit
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn- explode-num [n]
  {:pre (>= n 0)}
  (loop [n n digits '()]
    (let [m (mod n 10)
          n (quot n 10)
          digits (conj digits m)]
      (if-not (zero? n)
        (recur n digits)
        digits))))

(defn- explode-str [number]
  (map #(- (long %) 48) number))

(defn super-digit
  ([n]
    {:pre (>= n 0)}
    (let [n (reduce + 0 (explode-num n))]
      (if-not (< n 10)
        (recur n)
        n)))

  ([s k]
    (let [n (* (reduce + 0 (explode-str s)) k)]
      (super-digit n))))

(comment 
  ;; Reads input from HackerRank
  (let [[s k] (re-seq #"\d+" (read-line))]
    (println (super-digit s (Long/parseLong k))))
)
