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
(println similarity)
;(def similarity (.normalizedHammingDistance hash1 hash2))

;(.normalizedHammingDistance hash1)
