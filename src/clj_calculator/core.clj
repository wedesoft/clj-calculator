(ns clj-calculator.core
    (:require [instaparse.core :as insta]))

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
