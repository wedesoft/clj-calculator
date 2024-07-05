(ns clj-calculator.t-core
  (:require [midje.sweet :refer :all]
            [clj-calculator.core :refer :all]))

(facts "Test parser"
       (calc-parser "-42") => [:START [:NUMBER "-42"]]
       (calc-parser " -42 ") => [:START [:NUMBER "-42"]]
       (calc-parser "1 + 2") => [:START [:SUM [:NUMBER "1"] [:NUMBER "2"]]]
       (calc-parser "5 - 4") => [:START [:DIFF [:NUMBER "5"] [:NUMBER "4"]]]
       (calc-parser "2 * 3") => [:START [:PROD [:NUMBER "2"] [:NUMBER "3"]]])

(facts "Test calculator"
       (calculate "-42") => -42
       (calculate "1 + 2") => 3
       (calculate "5 - 4") => 1
       (calculate "2 * 3") => 6)
