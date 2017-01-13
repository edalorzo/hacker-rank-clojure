(ns week-of-code.lucky-number-eight)

(defn get-subseqs [x xs n]
    (loop [xs xs found []]
        (if (>= (count xs) n)
          (let [sub (apply str (concat x (take n xs)))]
            (recur (rest xs) (conj found sub)))
          found)))

(defn get-seqs [xs n]
  (loop [[x & xs] xs found []]
    (if (not-empty xs)
      (recur xs (concat found (get-subseqs [x] xs n)))
      found)))

(defn solve [s]
  (let [xs (map str (vec s)) size (count xs)]
    (loop [n 1 found []]
      (if (<= n size)
        (let [found (concat found (get-seqs xs n))]
          (recur (inc n) found))
        (concat xs found)))))
      
    
    
    
    
    
    
    
    
      
  
  
  