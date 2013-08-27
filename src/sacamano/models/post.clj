(ns sacamano.models.post
  (:require [korma.core :refer :all]))

(defentity posts
  (belongs-to users created_by)
  (belongs-to users last_updated_by))
