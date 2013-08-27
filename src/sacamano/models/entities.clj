(ns sacamano.models.entities
  (:require [korma.core :refer :all]))

(declare users posts)

(defentity users
  (table :sacamano_users)
  (has-many posts))

(defentity posts
  (belongs-to users :created_by)
  (belongs-to users :last_updated_by))
