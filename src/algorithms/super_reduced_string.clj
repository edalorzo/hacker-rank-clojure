(ns algorithms.super-reduced-string)

(defn superReducedString [s]
  (if (> (count s) 1)
    (let [[a b & c] s]
      (if (empty? c)
        (if (= a b) (superReducedString c) (str a b))
        (if (= a b) (superReducedString c) (str a (superReducedString (apply str b c))))))
    (if-not (empty? s)
      (apply str s)
      "Empty String")))

(superReducedString "baab")



