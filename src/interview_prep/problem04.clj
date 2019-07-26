(ns interview-prep.problem04)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Hacker Rank Inteview Preparation: Warm-up Challenges
; https://www.hackerrank.com/challenges/new-year-chaos/problem
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; Alternative Solution 1: O(n)

(defn- distance [x ys]
  (if-let [found (take 3 (take-while #(not= % x) ys))]
   (inc (count found)) 0))

;; Interestingly the use of concat function here
;; caused stack overflow errors when the input was 10^5
;; which forced me to spend hackos to figure it out.

(defn- create-order [y [o & os :as order] bribery] 
 (if (> bribery 1)
  (cons y (cons o (drop 2 order)))
  (cons y os)))

(defn- find-bribes

  ([queue]
   (let [size (count queue) 
         order (range 1 (inc size))]
    (find-bribes queue order 0)))

  ([queue order bribes]
   (if-not queue
    bribes
    (let [[x & xs] queue [y & ys] order]
     (if (= x y)
      (recur xs ys bribes)    
      (let [bribed (distance x ys)]     
       (if (> bribed 2)
         "Too chaotic"
         (let [ys (create-order y ys bribed)
               bribes (+ bribes bribed)]
           (recur xs ys bribes)))))))))

(defn minimumBribes [q]
  (find-bribes q))

(with-open [r (clojure.java.io/reader "/Users/edalorzo/Desktop/input06.txt")]
  (binding [*in* r] 
    (let [t (Integer/parseInt (clojure.string/trim (read-line)))]
      (doseq [t-itr (range t)]
        (let [n (Integer/parseInt (clojure.string/trim (read-line)))]
          (let [q (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" ")))]
            (println (minimumBribes q))))))))


