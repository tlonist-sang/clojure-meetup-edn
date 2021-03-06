(ns core2)

(comment
  (str (java.util.UUID/randomUUID))
  (-> (io/resource "test.edn")
      (slurp)
      (edn/read-string)
      :time
      class)

  (-> (io/resource "tagged.edn")
      (slurp)
      (edn/read-string)
      :time
      class)

  (-> (io/resource "test.edn")
      (slurp)
      (edn/read-string)
      :ids
      first
      uuid?)

  (-> (io/resource "test.edn")
      (slurp)
      (edn/read-string)
      :time)

  (edn/read-string
    {:readers {'number/even #(filter even? %)}}
    (slurp (io/resource "tagged.edn")))

  (edn/read-string
    {:readers {'req/name #(if (> (count %) 100)
                            (throw (Exception. "이름이 너무 깁니다.")) %)
               'req/age  #(if (or (> % 100)
                                  (not (number? %)))
                            (throw (Exception. "숫자가 너무 큽니다.")) %)}}
    (slurp (io/resource "request.edn")))

  (-> (io/resource "try.edn")
      slurp
      (edn/read-string)
      :sum
      eval)

  (take 10 (-> (io/resource "try.edn")
               slurp
               (edn/read-string)
               :fibonacci
               eval)))
