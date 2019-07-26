(ns interview-prep.problem04)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Hacker Rank Inteview Preparation: Warm-up Challenges
; https://www.hackerrank.com/challenges/new-year-chaos/problem
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; Alternative Solution 1: O(n)

(defn- distance [x ys]
  (if-let [found (take 3 (take-while #(not= % x) ys))]
   (inc (count found)) 0))

(defn- create-order [y order bribery]
 (if (> bribery 1)
  (concat [y] (take 1 order) (drop 2 order))
  (concat [y] (drop 1 order))))       

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

