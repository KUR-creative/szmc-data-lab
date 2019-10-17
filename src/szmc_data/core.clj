;map <F5> :wa<CR>:%Eval<CR>
;map <F6> :wa<CR>:!lein test<CR>
;map <F7> :wa<CR>:!lein run<CR>
(ns szmc-data.core
  (:require [clojure.java.jdbc :as j]
            [honeysql.core :as sql]
            [honeysql.helpers :as h]
            )
  (:gen-class))

(defn foo [] (println "Hello, World!"))
(println 'ppap)

;; it can open szmc.db
;; it can create szmc.db
;; it can insert row
;; it offer good cli 

;; inputs: images directories and their metadata
;;  only images directories
;;  Danbooru dataset(images directories + metadata(from json))
;;  

;; image cutter
;; generate snet dataset(yml + images folder) for training some nn
;; generate cnet dataset(flist + images folder) for training some nn

;; data manager (this) -> learner(snet,cnet) -> evaluator (?)


;; prototype 1

;; Create db first. (with simple schema)

;; Save image-only, image-named(old dset) directory.

;; Get all image paths.

;; Create image hash for ID<hash, h, w>
;; Save to DB with metadata: <hash, source, height, width, path, format, file_size>
;; `source` is 'where are images from'. In this case, source="old-dataset"

(comment 
(def db
  {:classname   "org.sqlite.JDBC"
   :subprotocol "sqlite"
   :subname     "database.db"
   })

(defn create-db
  "create db and table"
  []
  (try (db-do-commands db
                       (create-table-ddl :news
                                         [[:timestamp :datetime :default :current_timestamp ]
                                          [:url :text]
                                          [:title :text]
                                          [:body :text]]))
       (catch Exception e
         (println (.getMessage e)))))

(create-db)

(def db
  {:classname   "org.sqlite.JDBC"
   :subprotocol "sqlite"
   :subname     "szmc.db"
   })

;(jdbc/with-db-connection [
(j/query db ["SELECT 3*5 AS result"])
(j/query db ["SELECT count(*) FROM data"])
;(j/query db [k
(sql/build :select :* :from :foo :where [:= :f.a "bar"])

;(println select)
;(j/query db (sql/format 

(j/query db (sql/format (-> (h/select :%COUNT.*) (h/from :data))))
)
