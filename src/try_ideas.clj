(ns try-ideas
  (:import [java.text SimpleDateFormat]
           [java.util Calendar]))


(defrecord Tree [value left right])
(defprotocol BinarySearchTree
  (insert [tree v])
  (lookup [tree v])
  (to-list [tree]))

(extend-protocol BinarySearchTree

  Tree
  (insert [this x]
    (let [y (:value this) left (:left this) right (:right this)]
      (cond
        (< x y) (->Tree y (insert left x) right)
        (> x y) (->Tree y left (insert right x))
        :otherwise this)))

  (lookup [this x]
    (let [y (:value this) left (:left this) right (:right this)]
      (cond
        (< x y) (recur left x)
        (> x y) (recur right x)
        :otherwise true)))

  (to-list [this]
    (let [value (:value this) left (:left this) right (:right this)]
      (if (empty? left)
        (cons value (to-list right))
        (concat (to-list left) (list value) (to-list right)))))

  nil
  (insert [this v] (->Tree v nil nil))
  (lookup [this v] false)
  (to-list [this] nil))


(def my-tree (insert (insert (insert (insert (insert (insert (insert (insert (insert nil 5) 4) 8) 2) 7) 9) 1) 3) 6))
;;(def my-tree (insert (insert (insert nil 5) 4) 8))
(lookup my-tree 5)
;;my-tree
(to-list my-tree)

(defn qs [X]
  (when-not (empty? X)
    (let [x (first X)
          L (filter #(< %1 x) X)
          R (filter #(> %1 x) X)]
      (lazy-cat (qs L) (list x) (qs R)))))


(qs [0 9 8 7 6 5 4 3 2 1])

(defn split [X]
  (if (empty? X)
    (list nil nil)
    (let [[x & xs] X]
      (if (empty? xs)
        (list (list x) nil)
        (let [[y & ys] xs
              [X' Y'] (split ys)]
          [(cons x X') (cons y Y')])))))

(split [0 1 2 3 4 5 6 7 8 9])

(defn merge [L R]
  (cond
    (empty? L) R
    (empty? R) L
    :else (let [[x & xs] L
                [y & ys] R
                M (merge xs ys)]
            (if (< x y)
              (cons x (cons y M))
              (cons y (cons x M))))))

(merge '(0 2 4 6 8) '(1 3 5 7 9))

(defn merge-sort [X]
  (when-not (empty? X)
    (let [[x & xs] X]
      (if (empty? xs)
        (list x)
        (let [[L R] (split X)
              L' (merge-sort L)
              R' (merge-sort R)]
          (lazy-seq (merge L' R')))))))

(split [9 8 7 6 5 4 3 2 1 0])
(split '(9 7 5 3 1)) (split '(8 6 4 2 0))
(split '(9 5 1)) (split '(7 3))  (split '(8 4 2)) (split '(6 0))
(split '(9 1)) (split '(5))
(split '(9)) (split '(1)) 

(merge-sort '(9 8 7 6 5 4 3 2 1 0))







