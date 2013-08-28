(ns sacamano.models.entities
  (:require [korma.core :refer :all]))

(declare users posts)

(defentity users
  (table :sacamano_users)
  (has-many posts {:fk :created_by}))

(defentity posts
  (belongs-to users {:fk :created_by}))
