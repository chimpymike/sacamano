(ns lobos.migrations
  (:refer-clojure :exclude [alter drop bigint boolean char
                            double float time])
  (:use (lobos [migration :only [defmigration]] core schema
               config helpers)))

(defmigration add-users-table
  (up [] (create
          (tbl :sacamano_users
               (varchar :name 100 unique)
               (varchar :email 100 unique)
               (check :name (> (length :name) 1)))))
  (down [] (drop (table :sacamano_users))))
