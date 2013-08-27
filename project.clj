(defproject sacamano "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.5"]
                 [lobos "1.0.0-beta1"]
                 [com.h2database/h2 "1.3.173"]
                 [korma "0.3.0-RC5"]
                 [org.clojure/java.jdbc "0.3.0-alpha4"]]
  :plugins [[lein-ring "0.8.5"]]
  :ring {:handler sacamano.handler/app}
  :profiles
  {:dev {:dependencies [[ring-mock "0.1.5"]]}})
