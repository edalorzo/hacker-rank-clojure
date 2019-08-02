(ns algorithms.birthday-cakes)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Hacker Rank Algorithms: Warm-up Challenges
; https://www.hackerrank.com/challenges/birthday-cake-candles/problem
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn birthdayCakeCandles [ar]
  (get (reduce (fn [max candle]
                 (if (nil? max) [candle 1]
                     (let [[tallest found] max]
                       (cond (= candle tallest) [tallest (inc found)]
                             (> candle tallest) [candle 1]
                             :else max)))) nil ar) 1))
