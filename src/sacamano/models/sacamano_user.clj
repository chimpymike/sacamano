(ns sacamano.models.sacamano-user
  (:require [korma.core :refer :all]))

(defentity users
  (table :sacamano_users)
  (has-many posts))
