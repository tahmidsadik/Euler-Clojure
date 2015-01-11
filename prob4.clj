(defn palindrome? [n]
  "Takes a number n and returns true if n is palindrome"
  (= n (Integer/parseInt (apply str(reverse(str n))))))
;solution 1
(defn product-of-three-digitis [n]
  (loop [x 999 coll []]
    (if (= x 99) coll (recur (dec x) (conj coll (* n x))))))
(def collection-of-nums (map product-of-three-digitis (range 100 1000)))

(time (first (filter palindrome? (product-of-three-digitis 101))))

(apply max(remove #(= % nil) (for [x collection-of-nums]
  (first (filter palindrome? x)))))
;solution 2
(defn highest-palin-in-product-range [lower upper n]
  (loop [x upper product (* n x)]
    (if (palindrome? product)
      product
      (if (< x lower)
        nil
        (recur (dec x) (* (dec x) n))))))
(time (highest-palin-in-product-range 100 999 101))

(time(apply max (remove #(= % nil) (map (partial highest-palin-in-product-range 100 999) (range 999 99 -1)))))
