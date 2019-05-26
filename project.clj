(defproject metabase/odes-driver "1.0.1-odes-jdbc-2.3.0"
  :min-lein-version "2.5.0"

  :dependencies
  [[com.amazon.opendistroforelasticsearch.client/opendistro-sql-jdbc "0.9.0.0"]]

  :profiles
  {:provided
   {:dependencies
    [[org.clojure/clojure "1.10.0"]
     [metabase-core "1.0.0-SNAPSHOT"]]}

  :aot [metabase.driver.FixedOdesConnection
        metabase.driver.FixedOdesDriver]

   :uberjar
   {:auto-clean    true
    :aot           :all
    :omit-source   true
    :javac-options ["-target" "1.8", "-source" "1.8"]
    :target-path   "target/%s"
    :uberjar-name  "odes.metabase-driver.jar"}})
