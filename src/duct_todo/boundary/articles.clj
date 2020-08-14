(ns duct-todo.boundary.articles
  (:import [duct.database.sql Boundary])
  (:require [clojure.java.jdbc :as jdbc]))

(defprotocol Articles
  (index-articles [db])
  (create-article [db params]))

(extend-protocol Articles
  Boundary

  (index-articles [{:keys [spec]}]
    (jdbc/query spec ["SELECT * FROM articles"]))

  (create-article [{:keys [spec]} {:keys [content]}]
    (let [result (jdbc/insert! spec :articles {:content content})]
      (-> result first :id))))
