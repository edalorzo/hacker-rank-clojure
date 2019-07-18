(ns interview-prep.problems)


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Hacker Rank Inteview Preparation: Warm-up Challenges
; https://www.hackerrank.com/challenges/counting-valleys/problem
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn decode-step [s]
 (case s
  \U 1
  \D -1))

(defn at-sea-level? [level]
 (= level 0))

(defn above-sea-level? [level]
 (> level 0))

(defn below-sea-level? [level]
 (< level 0))

(defn end-of-valley? [level-before level-now]
 (and (below-sea-level? level-before) 
      (at-sea-level? level-now)))

(defn counting-valleys [n s]
 {:pre [(>= n 2)]}
 (let [hike (map decode-step s)]
  (loop [[x & xs] hike level-before 0 rem-steps (dec n) valleys 0]
    (let [level-now (+ level-before x)]
     (if (not= (Math/abs level-now) rem-steps)        
       (if (end-of-valley? level-before level-now)        
        (let [valleys (inc valleys)] 
          (if (empty? xs)
           valleys 
           (recur xs level-now (dec rem-steps) valleys)))
        (if (empty? xs)
         valleys 
         (recur xs level-now (dec rem-steps) valleys)))
       (if (below-sea-level? level-now)
         (inc valleys)
         valleys))))))

    


        
      
   
    
       
  



