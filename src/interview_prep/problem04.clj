(ns interview-prep.problem04)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Hacker Rank Inteview Preparation: Warm-up Challenges
; https://www.hackerrank.com/challenges/new-year-chaos/problem
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn- distance [x ys]
  (if-let [found (take-while #(not= % x) ys)]
   (inc (count found))
   0)) 

(defn- create-expectation [y expected bribery]
 (if (> bribery 1)
  (concat [y] (take 1 expected) (drop 2 expected))
  (concat [y] (drop 1 expected))))       

(defn- find-bribes [actual expected last-briber briberies] 
 (if-not actual
  briberies
  (let [[x & xs] actual [y & ys] expected]
   (if (= x y)
    (recur xs ys last-briber briberies)    
    (let [bribery (distance x ys)]     
     (if (> bribery 2) 
       "Too chaotic"
       (let [ys (create-expectation y ys bribery)
             briberies (+ briberies bribery)]         
         (recur xs ys x briberies))))))))

(defn minimumBribes [q]
 (let [size (count q)
       actual q
       expected (range 1 (inc size))]
   (find-bribes actual expected 0 0)))
