(ns sacamano.models.post
  (:require [korma.core :refer :all]
            [sacamano.models.sacamano_user :as user-model]))

(defentity posts
  (belongs-to user-model/users created_by)
  (belongs-to user-model/users last_updated_by))
