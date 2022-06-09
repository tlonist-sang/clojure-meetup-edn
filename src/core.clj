(ns core
  (:require [clojure.edn :as edn]
            [clojure.java.io :as io]))


(comment
  (-> (io/resource "test.edn")
      (slurp)
      (edn/read-string)
      :place
      first
      class))














