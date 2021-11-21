(ns data-structures.tree-lca-test
  (:require [clojure.test :refer :all]
            [data-structures.tree-lca :refer :all]))


(defn mktree 
    ([v l r] (->Tree v l r))
    ([v l] (->Tree v l nil))
    ([v] (->Tree v nil nil)))


(def a-tree 
    (mktree 4
        (mktree 2 (mktree 1) (mktree 3))
        (mktree 7 (mktree 6)))
)

(def b-tree 
    (mktree 2
        (mktree 1)
        (mktree 3 
            (mktree 4) 
            (mktree 5 (mktree 6)))))
        
    


(deftest test-tree-addition
  (testing "with paths in tree"
    (is (= (path-to a-tree 6) '(4 7 6)))
    (is (= (path-to b-tree 6) '(2 3 5 6))))

  
  (testing "with proposed scenarios"
    (is (= (lca a-tree 1 7) 4))
    (is (= (lca b-tree 4 6) 3))))
    

        
        


