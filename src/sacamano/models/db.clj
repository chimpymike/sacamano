(ns sacamano.models.db
  (:require [korma.db :refer :all]))

(def db-spec (h2 {:db "dev"}))

(defdb db db-spec)
