(ns user
  (require [clojure.set :refer :all]))

(defn square [n]
  (* n n))

(defn lazy-primes [max]
  (let [ next-sieve (fn [sieve candidate]
                     (if-let [x (contains? sieve candidate)]
                       (difference sieve (range (square candidate) max candidate))
                       sieve))]
    (conj (reduce next-sieve (set (range 3 max 2)) (range 3 (Math/ceil (Math/sqrt max)) 2)) 2)))
(time (nth (sort (lazy-primes 1000000)) 10000))
