(ns sacamano.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [sacamano.controllers.blog :as blog-controller]))

(defroutes app-routes
  (GET "/" [] (blog-controller/index-page))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
