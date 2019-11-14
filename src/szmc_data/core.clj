;map <F5> :wa<CR>:%Eval<CR>
;map <F6> :wa<CR>:!lein test<CR>
;map <F7> :wa<CR>:!lein run<CR>

;------------------------------------------------------------
(comment 
(ns szmc-data.imghash-lab
  (:require [clojure.java.io :as io])
  (:import (java.io File)
           [javax.imageio ImageIO]
           (com.github.kilianB.hashAlgorithms PerceptiveHash)))

(defn read-img
  "Reads a BufferedImage from source, something 
  that can be turned into a file with clojure.java.io/file"
  [source]
  (ImageIO/read (io/file source)))


(def img1 (io/file "1.png"))
(def img2 (io/file "2.png"))
(def hasher (PerceptiveHash. 32))

(println hasher)

(def hash1 (.hash hasher img1))
(def hash2 (.hash hasher img2))

(println hash1)
(def similarity (.normalizedHammingDistance hash1 hash2))
);------------------------------------------------------------

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
