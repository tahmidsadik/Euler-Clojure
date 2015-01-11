(defn multiple-of-x? [x]
  (fn [n]
    (zero? (rem n x))))
(def pred (apply every-pred (map #(multiple-of-x? %1) (range 3 21))))
(first (filter pred (range 2 999999999999 2)))
