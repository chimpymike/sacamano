(ns sacamano.models.entities
  (:require [korma.core :refer :all]))

(defn clob-to-string [clob]
  (with-open [rdr (java.io.BufferedReader. (.getCharacterStream clob))]
    (apply str (line-seq rdr))))

(declare users posts)

(defentity users
  (table :sacamano_users)
  (has-many posts {:fk :created_by}))

(defentity posts
  (belongs-to users {:fk :created_by}))
