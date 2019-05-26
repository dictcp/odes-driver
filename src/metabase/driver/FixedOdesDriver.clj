(ns metabase.driver.FixedOdesDriver
  (:gen-class
   :extends com.amazon.opendistroforelasticsearch.jdbc.Driver
   :init init
   :prefix "driver-"
   :constructors {[] []})
  (:import clojure.lang.Reflector
           java.util.Properties
           com.amazon.opendistroforelasticsearch.jdbc.Driver
           com.amazon.opendistroforelasticsearch.jdbc.logging.NoOpLogger
           com.amazon.opendistroforelasticsearch.jdbc.config.ConnectionConfig
           com.amazon.opendistroforelasticsearch.jdbc.ConnectionImpl
           metabase.driver.FixedOdesConnection))

(defn driver-init
  "Initializes the Hive driver, fixed to work with Metabase"
  []
  [[] nil])

(defn driver-connect
  "Connects to a Hive compatible database"
  [^com.amazon.opendistroforelasticsearch.jdbc.Driver this, ^String url, ^java.util.Properties info]
  (Reflector/invokeConstructor (Class/forName "metabase.driver.FixedOdesConnection") (to-array [
    (.build (doto (ConnectionConfig/builder) (.setUrl url) (.setProperties info)))
    NoOpLogger/INSTANCE
  ]))
)
