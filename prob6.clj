(defn square [n]
  (* n n))
(- (reduce + (map #(* %1 %1) (range 1 101))) (square (reduce + (range 1 101))))
