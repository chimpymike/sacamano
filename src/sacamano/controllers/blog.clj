(ns sacamano.controllers.blog
  (:require [sacamano.models.post :as posts])
  (:require [sacamano.views.blog :as blog-views]))

(defn index-page []
  (blog-views/index-page (posts/get-all-posts)))

(defn single-post-page [post-slug]
  (blog-views/single-post-page (posts/get-post-by-slug post-slug)))
