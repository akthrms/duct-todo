(ns duct-todo.handler.articles
  (:require [ataraxy.response :as response]
            [integrant.core :as ig]
            [duct-todo.boundary.articles :as articles]))

(defmethod ig/init-key ::index [_ {:keys [db]}]
  (fn [_]
    (let [articles (articles/index-articles db)]
      [::response/ok articles])))

(defmethod ig/init-key ::create [_ {:keys [db]}]
  (fn [{:keys [body-params]}]
    (let [article-id (articles/create-article db body-params)]
      [::response/created (str "/articles/" article-id)])))
