(ns interview-prep.problem02)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Hacker Rank Inteview Preparation: Warm-up Challenges
; https://www.hackerrank.com/challenges/2d-array/problem
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn belongs-to? 
  [[x1 y1] [x y]]  
  "Determines if the given coordinates [x y] belog to the hour glass [x1 y1]"
  (let [x3 (+ x1 2) y2 (inc y1)  y3 (+ y1 2)]
   (and (>= x x1) (<= x x3)
        (>= y y1) (<= y y3)
        (not (and (= y y2) (or (= x x1) (= x x3)))))))
  
(defn hourglassSum [arr]
 (let [hour-glasses (for [x (range 4) y (range 4)] [x y])
       coordinates (for [x (range 6) y (range 6)] [x y])
       by-hg (for [hour-glass hour-glasses]
               (for [[x,y :as coordinate] coordinates 
                     :when (belongs-to? hour-glass coordinate)
                     :let [value (get (get arr y) x)]] value))]
  (apply max (map #(reduce + 0 %) by-hg))))  
