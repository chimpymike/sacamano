(ns sacamano.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [sacamano.controllers.blog :as blog-controller]))

(defroutes app-routes
  (GET "/" [] (blog-controller/index-page))
  (GET "/:post-slug" [post-slug] (blog-controller/single-post-page post-slug))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
