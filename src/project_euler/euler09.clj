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

(defn gcd 
  "Obtains the greatest common divisor of two numbers a and b"
  [a b]
  {:pre [(every? #(>= % 0) [a b])]}
  (if-not (zero? b)
    (recur b (mod a b))
    a))

(defn coprime? 
  "Determine if two numbers a and b are coprime"
  [a b]
  (= 1 (gcd a b)))

(defn coprimes 
  "Gets a lazy sequence of comprimes up to x"
  [x]
  {:pre (> x 0)}
  (for [m (range 2 x)
        n (range (if (even? m) 1 2) m 2)
        :when (coprime? m n) 
        :while (< n m)]
    [m n]))

(defn get-triple 
  "Creates a new Pythagorean triple using Euclid's formula for two integers m and n"
  ([m n] 
   (get-triple m n 1))
  
  ([m n k]
   (let [a (* k (- (* m m) (* n n)))
         b (* k 2 m n)
         c (* k (+ (* m m) (* n n)))]
     (list a b c))))


;; The solution consists in finding if the sum S of a given primitive triples is a 
;; factor of X, if so, depending on the quotient, we can calcualate a non-primitive
;; Pythagorean triple that represent X perfectly.

(defn get-triples-for 
  "Gets a sequence with all Pythagorean triples of x"
  [x]
  (let [size (inc (int (Math/sqrt x)))
        coprimes (coprimes size)]
    (for [[m,n] coprimes 
          :let [[a b c] (get-triple m n) 
                s (+ a b c) 
                q (quot x s) 
                r (rem x s)]
          :when (and (<= s x) (>= q 1) (zero? r))]
      (map #(* % q) [a b c]))))


;; finds the solution to the problem
(defn find-highest-triple-product [xs]
  (letfn [(get-product [x] (map #(apply * %) (get-triples-for x)))]
    (->> xs
         (map get-product)
         (flatten)
         (sort))))
  
  
(comment  
;; Reads HackerRank input data
(defn get-input []
  (let [total-lines (Integer/parseInt (read-line))]
    (for [line (range 0 total-lines)]
      (Integer/parseInt (read-line)))))

;; Solves the algorithm
(let [input (get-input) 
      results (find-highest-triple-product input)]
  (doseq [result results]
    (println result)))
)