(ns tag
  (:require [clojure.edn :as edn]
            [clojure.java.io :as io]))

;; tagged element parser
(defn even-filter [input]
  (filter even? input))

(defn odd-filter [input]
  (filter odd? input))

(defn prime-filter [input]
  (letfn [(prime? [n] (.isProbablePrime (BigInteger/valueOf n) 5))]
    (filter prime? input)))

(comment
  (edn/read-string
    {:readers {'number/even  even-filter
               'number/odd   odd-filter
               'number/prime prime-filter}}
    (slurp (io/resource "tagged.edn"))))