(ns duct-todo.test-utils
  (:require [clojure.java.jdbc :as jdbc]
            [duct.core.env :as e]
            [duct.database.sql :as sql]))

(def db-spec
  {:connection (jdbc/get-connection {:connection-uri (e/env "TEST_DB_URL")})})

(def db
  (sql/->Boundary db-spec))

(defn drop-all-tables []
  (let [table-names (map :relname (jdbc/query db-spec ["SELECT relname
                                                        FROM pg_stat_user_tables
                                                        WHERE relname <> 'ragtime_migrations'"]))]
    (doseq [t table-names]
      (jdbc/delete! db-spec t []))))

(defn db-cleanup [test-fn]
  (test-fn)
  (drop-all-tables))
