(ns sacamano.views.blog
  (:require [hiccup [core :refer :all] [page :refer :all]]))

(defn post-partial [post]
  (let [{:keys [title body]} post]
    (html [:h1 title] [:h2 body])))

(defn index-page [posts]
  (apply str (mapcat post-partial posts)))
