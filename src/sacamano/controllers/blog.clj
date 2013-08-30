(ns sacamano.controllers.blog
  (:require [sacamano.models.post :as posts])
  (:require [sacamano.views.blog :as blog-views]))

(defn index-page []
  (blog-views/index-page (posts/get-all-posts)))
