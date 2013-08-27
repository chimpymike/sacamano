(ns sacamano.models.sacamano-user
  (:require [korma.core :refer :all]
            [sacamano.models.post :as post-model]))

(defentity users
  (table :sacamano_users)
  (has-many post-model/posts))
