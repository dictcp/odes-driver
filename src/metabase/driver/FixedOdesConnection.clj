(ns metabase.driver.FixedOdesConnection
  (:gen-class
   :extends com.amazon.opendistroforelasticsearch.jdbc.ConnectionImpl
   :init init
   :constructors {[com.amazon.opendistroforelasticsearch.jdbc.config.ConnectionConfig com.amazon.opendistroforelasticsearch.jdbc.logging.Logger] [com.amazon.opendistroforelasticsearch.jdbc.config.ConnectionConfig com.amazon.opendistroforelasticsearch.jdbc.logging.Logger],
                  [com.amazon.opendistroforelasticsearch.jdbc.config.ConnectionConfig com.amazon.opendistroforelasticsearch.jdbc.transport.TransportFactory com.amazon.opendistroforelasticsearch.jdbc.protocol.ProtocolFactory com.amazon.opendistroforelasticsearch.jdbc.logging.Logger] [com.amazon.opendistroforelasticsearch.jdbc.config.ConnectionConfig com.amazon.opendistroforelasticsearch.jdbc.transport.TransportFactory com.amazon.opendistroforelasticsearch.jdbc.protocol.ProtocolFactory com.amazon.opendistroforelasticsearch.jdbc.logging.Logger]}
   :exposes-methods {prepareStatement parentPrepareStatement}
  )
  (:import [java.sql ResultSet SQLException]
           com.amazon.opendistroforelasticsearch.jdbc.ConnectionImpl))

(defn -init
  "Initializes the connection"
  [connectionConfig log]
  [[connectionConfig log] nil])

(defn -setAutoCommit
  "Sets this connection to read only"
  [^com.amazon.opendistroforelasticsearch.jdbc.ConnectionImpl this autoCommit?]
)

(defn -commit
  "Sets this connection to read only"
  [^com.amazon.opendistroforelasticsearch.jdbc.ConnectionImpl this]
)

(defn -rollback
  "Sets this connection to read only"
  [^com.amazon.opendistroforelasticsearch.jdbc.ConnectionImpl this]
)

;; FIXME ODES does not support "comment in query" yet.
(defn -prepareStatement
  "Sets this connection to read only"
  [^com.amazon.opendistroforelasticsearch.jdbc.ConnectionImpl this, ^java.lang.String sql]
  (.parentPrepareStatement this (clojure.string/replace sql #"--.*\n" ""))
)
