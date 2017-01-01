(ns project-euler.euler09)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;
;; Special Pythagorean
;; https://www.hackerrank.com/contests/projecteuler/challenges/euler009
;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


;; Given N, check if there exists any Pythagorean triplet for which a + b + c = N.  
;; Find maximum possible value of abc among all such Pythagorean triplets, 
;; if there is no such Pythagorean triplet print -1.

(defn gcd [a b]
  (if-not (zero? b)
    (recur b (mod a b))
    a))

(defn coprime? [a b]
  (= 1 (gcd a b)))

(defn triplet [m n k]
  (let [a (* k (- (* m m) (* n n)))
        b (* k 2 m n)
        c (* k (+ (* m m) (* n n)))]
      (list a b c)))

(defn coprimes [x]
  {:pre (> x 1)}
  (for [m (range 2 x)
        n (range (if (even? m) 1 2) (- x m) 2)
        :when (coprime? m n) 
        :while (< n m)]
    [m n]))

(defn triplets [x]
  (let [coprimes (coprimes x)]
    (for [[m,n] coprimes 
          k (range 1 (- (inc x) (+ m n)))
          :let [[a b c] (triplet m n k)]
          :when (= (+ a b c) x)]
    [a b c])))


