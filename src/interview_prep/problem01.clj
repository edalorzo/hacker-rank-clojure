(ns interview-prep.problem01)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Hacker Rank Inteview Preparation: Warm-up Challenges
; https://www.hackerrank.com/challenges/counting-valleys/problem
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn- decode-step [s]
 (case s
  \U 1
  \D -1))

(comment

   ;; Solution #1: Using high-order functions

  (defn- valley? [[x y]]
   (and (= x -1) (= y 0)))

  (defn counting-valleys [n s]
   (let [hike (reductions + (map decode-step s))]
    (count (filter valley? (map vector hike (rest hike)))))

   ;; Alternatively
   (defn counting-valleys [n s]
     (let [hike (reductions + (map decode-step s))]
       (count (filter #(= % '(-1 0)) (partition 2 (interleave hike (rest hike)))))))))

(comment

 ;; Solution #2: Using a for-loop equivalency

  (defn- valley? [altitude step]
      (and (zero? altitude) (pos? step)))

  (defn counting-valleys [n s]
   (loop [i 0 altitude 0 valleys 0]
      (if (= i n)
       valleys
        (let [step (decode-step (get s i))
              altitude (+ altitude step)
              valleys (if (valley? altitude step) (inc valleys) valleys)]
             (recur (inc i) altitude valleys))))))

(comment 

  ;; Solution 3: Using a for-each loop equivalency

  (defn- valley? [altitude step]
      (and (zero? altitude) (pos? step)))

  (defn counting-valleys [n s]
   (loop [[step & xs] (map decode-step s) altitude 0 valleys 0]
     (let [altitude (+ altitude step)
           valleys (if (valley? altitude step) (inc valleys) valleys)]
          (if-not xs
             valleys
             (recur xs altitude valleys)))))) 


;; Solution 3: Reduces complexity by half.
;; Note: it holds that n % 2 = 0 so steps can be read in pairs.

(defn- valley? [altitude step]
  (and (zero? altitude) (neg? step)))

(defn counting-valleys [n s]
 (loop [[x y & xs] (map decode-step s) altitude 0 valleys 0]   
   (let [valleys (if (valley? altitude x) (inc valleys) valleys)
         altitude (+ altitude x y)]                  
        (if-not xs
           valleys
           (recur xs altitude valleys))))) 


(comment

 ;; Solution 4: Failed optimization
 ;; I thought that if |altitude| = remaining-steps then there is no
 ;; need to count the rest of the steps, which could reduce the number of
 ;; iterations of the algorithm in the worst case scenario.
 ;; However, in order to do so I introduce at least two new operations:
 ;; an or, an additional condition in the or, the aritmetic calculation of steps
 ;; and the calculation of the absolute value of altitude.
 ;; All these new operations ended up making the algorithm much more expensive
 ;; and this version does not even passes all the tests.

  (defn- valley? [altitude step]
    (and (zero? altitude) (neg? step)))

  (defn counting-valleys [n s]
   (loop [[x y & xs] (map decode-step s) altitude 0 valleys 0 rem-steps (- n 2)]   
     (let [valleys (if (valley? altitude x) (inc valleys) valleys)
           altitude (+ altitude x y)]                  
          (if (or (not xs) (= rem-steps (Math/abs altitude)))
             valleys
             (recur xs altitude valleys (- rem-steps 2))))))) 


