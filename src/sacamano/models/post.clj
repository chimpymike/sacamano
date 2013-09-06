(ns sacamano.models.post
  (:require [korma.core :refer :all])
  (:require [sacamano.models.entities :refer :all])
  (:require [sacamano.models.db :only db])
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

(defn get-all-posts
  "Return all the posts from the database."
  []
  (select posts))

(defn get-post-by-id
  "Return a single post from the database based on id."
  [post-id]
  (first (select posts (where {:id post-id}))))

(defn get-post-by-slug
  "Return a single post from the database based on slug."
  [post-slug]
  (first (select posts (where {:slug post-slug}))))
