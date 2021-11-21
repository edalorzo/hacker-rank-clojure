(ns data-structures.tree-lca)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Hacker Rank Algorithms: Data Structures - Trees
; https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor/problem
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defprotocol BinaryTree
    (lca [tree v1 v2])
    (path-to [tree v]))

(defrecord Tree [data left right])

(extend-protocol BinaryTree

 Tree
 (path-to [this x]
   (let [y (:data this)]
     (if (= x y)
       (cons y '())
       (let [found (or (path-to (:left this) x) (path-to (:right this) x))]
         (if (empty? found) 
           found  
           (cons y found))))))

 (lca [this v1 v2]
   (->> (map #(vec [%1 %2]) (path-to this v1) (path-to this v2))
       (filter #(apply = %))
       (map #(get %1 0))
       last))

 nil
 (path-to [this x] nil)
 (lca [this v1 v2] nil))

