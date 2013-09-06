(ns sacamano.controllers.blog
  (:require [sacamano.models.post :as posts]
            [sacamano.views.blog :as blog-views]))

(defn index-page []
  (blog-views/index-page (posts/get-all-posts)))

(defn single-post-page [post-slug]
  (if-let [single-post (posts/get-post-by-slug post-slug)]
    (blog-views/single-post-page single-post)))
