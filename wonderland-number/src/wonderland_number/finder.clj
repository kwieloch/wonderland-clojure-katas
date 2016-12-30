(ns wonderland-number.finder)

(defn wonderland-number []
  (let [
    hasAllTheSameDigits? (fn [n1 n2]
                          (let [s1 (set (str n1))
                                s2 (set (str n2))]
                            (= s1 s2)))
    wonder? (fn [n] (every? #(hasAllTheSameDigits? n (* n %1)) [2 3 4 5 6]))
    ]
    (first (filter wonder? (range 100000 999999)))

  )
)