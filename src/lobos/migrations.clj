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

(defmigration add-posts-table
  (up [] (create
          (tbl :posts
               (varchar :slug 200)
               (varchar :title 200)
               (text :body))))
  (down [] (drop (table :posts))))

(defmigration add-comments-table
  (up [] (create
          (tbl :comments
               (text :content)
               (refer-to :posts))))
  (down [] (drop (table :comments))))
