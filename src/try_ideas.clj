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

