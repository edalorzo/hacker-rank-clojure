(ns algorithms.grading-students)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Hacker Rank Algorithms: Problem Solving
;; https://www.hackerrank.com/challenges/grading/problem
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn gradingStudents [grades]
  (letfn [(average [g]
            (if (>= g 38)
              (let [r (rem g 5) d (- 5 r)]
                (if (< d 3) (+ g d) g))
              g))
          (map average grades)]))

;; (gradingStudents [73 67 38 33])

