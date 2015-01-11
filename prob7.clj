(defn not-multiple-of-x? [x]
  (fn [n]
    (cond
          (= n x) true
          (zero? (rem n x)) false
          :else true)))
(defn factor-of-x? [x]
  (fn [n]
    (zero? (rem x n))))
(defn lazy-primes [max]
  (let [next-sieve (fn [sieve candidate]
                     (if-let [x (some #{candidate} sieve)]
                       (filter (not-multiple-of-x? x) sieve)
                       sieve))]
    (cons 2 (lazy-seq (reduce next-sieve (range 3 (inc max) 2) (range 3 (Math/ceil (Math/sqrt max)) 2))))))
(def almost-all-primes (lazy-primes 9999999))
(time ((vec (lazy-primes 1000000)) 10000))
