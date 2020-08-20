(ns algorithms.interleaving-strings)

(defn interleave? [s1 s2 t]
  (cond
    (empty? s1) (= s2 t)
    (empty? s2) (= s1 t)
    (empty? t) false
    (not= (count t) (count (concat s1 s2))) false
    :otherwise (let [[x & xs] s1 [y & ys] s2 [z & zs] t]
                 (cond
                   (= z x) (recur xs (seq s2) zs)
                   (= z y) (recur (seq s1) ys zs)
                   :otherwise false))))

;;(interleave? "gtaa" "atc" "gattaca")
