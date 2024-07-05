(ns clj-calculator.core
    (:require [instaparse.core :as insta])
    (:gen-class))

(def calc-parser
  (insta/parser
    (slurp "resources/clj_calculator/calculator.bnf")))

(defn calculate
  [string]
  (instaparse.transform/transform
    {:START  identity
     :NUMBER #(Integer/parseInt %)
     :SUM    +
     :DIFF   -
     :PROD   *}
    (calc-parser string)))

(defn -main
  [& _args]
  (loop [line (read-line)]
        (when line
          (println (calculate line))
          (recur (read-line))))
  (System/exit 0))
