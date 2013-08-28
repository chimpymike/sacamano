(ns sacamano.models.post
  (:require [korma.core :refer :all])
  (:require [sacamano.models.entities :refer :all])
  (:require [clojure.string :as str]))

(defn make-slug
  "Make a slug from a string."
  [s]
  (let [s (str/lower-case s)
        slug-regex #"[^a-z0-9]+"
        trim-dashes-regex #"^-|-$"
        replacement-char "-"]
    (-> s
        (str/replace slug-regex replacement-char)
        (str/replace trim-dashes-regex ""))))
