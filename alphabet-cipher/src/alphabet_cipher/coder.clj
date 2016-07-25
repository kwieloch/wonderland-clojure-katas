(ns alphabet-cipher.coder)

(def alphabet "abcdefghijklmnopqrstuvwxyz")
(def almap (zipmap alphabet (range (count alphabet))))
(defn pos [char] (almap char))
(defn row [char] (take (count alphabet) (drop (pos char) (cycle alphabet))))

(defn encode [keyword message]
  "encodeme"
  (apply str (map #(nth (row %2) (pos %1)) (cycle keyword) (seq message))))

(defn decode [keyword message]
  "decodeme"
  (apply str (map #(nth alphabet (.indexOf (row %1) %2)) (cycle keyword) (seq message))))

(defn decipher [cipher message]
  "decypherme"
  (let [cipat (apply str (map #(nth alphabet (.indexOf (row %2) %1)) (seq cipher) (seq message)))]
    (if-let [guess (last (re-find #"^(\w+?)\1" cipat))]
       guess
       (if-let [guess (last (re-find #"^(\w+?)\1*$" cipat))]
          guess
          nil))))


