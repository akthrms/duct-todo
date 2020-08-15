(ns duct-todo.boundary.articles-test
  (:require [clojure.test :as t]
            [duct-todo.boundary.articles :as articles]
            [duct-todo.test-utils :as u]))

(t/use-fixtures :each u/db-cleanup)

(t/deftest boundary-articles-test
  (t/testing "create article"
    (let [article-id (articles/create-article u/db {:content "foo"})]
      (t/is (int? article-id))))

  (t/testing "index articles"
    (let [results (articles/index-articles u/db)]
      (t/is (= 1 (count results)))
      (t/is (= "foo" (:content (first results)))))))
