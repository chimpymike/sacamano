(ns lobos.helpers
  (:refer-clojure :exclude [bigint boolean char double float time])
  (:use [lobos schema]))

(defn surrogate-key [table]
  (integer table :id :auto-inc :primary-key))

(defn timestamps [table]
  (-> table
      (timestamp :last_update_date)
      (timestamp :creation_date (default (now)))))

(defn userstamps [table]
  (-> table
      (integer :created_by [:refer :sacamano_users :id :on-delete :set-null])
      (integer :last_updated_by [:refer :sacamano_users :id :on-delete :set-null])))

(defn refer-to [table ptable]
  (let [cname (-> (->> ptable name butlast (apply str))
                  (str "_id")
                  keyword)]
    (integer table cname [:refer ptable :id :on-delete :set-null])))

(defmacro tbl [name & elements]
  `(-> (table ~name)
       (timestamps)
       (userstamps)
       ~@(reverse elements)
       (surrogate-key)))
