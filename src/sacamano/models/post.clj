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

(defn add-post
  "Create a new post and save it to the database."
  [title body user-id]
  (let [slug (make-slug title)]
    (insert posts
      (values {:slug slug :title title
               :body body :created_by user-id}))))
