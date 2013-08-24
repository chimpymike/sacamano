(ns lobos.config
  (:use lobos.connectivity))

(def db
  {:classname "org.h2.Driver"
   :subprotocol "h2"
   :subname "./dev"})

(open-global db)
