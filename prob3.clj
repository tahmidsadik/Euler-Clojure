(defn not-multiple-of-x? [x]
  (fn [n]
    (cond
          (= n x) true
          (zero? (rem n x)) false
          :else true)))
(defn factor-of-x? [x]
  (fn [n]
    (zero? (rem x n))))
(defn naive-prime [max]
  (let [next-sieve (fn [sieve candidate]
                     (if-let [x (some #{candidate} sieve)]
                       (filter (not-multiple-of-x? x) sieve)
                       sieve))]
    (conj (reduce next-sieve (range 3 max 2) (range 3 (Math/sqrt max) 2)) 2)))
(first (filter (factor-of-x? 600851475143) (reverse(naive-prime (inc(int (Math/sqrt 600851475143)))))))
