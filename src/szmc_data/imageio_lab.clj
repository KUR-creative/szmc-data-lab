(ns szmc-data.imageio-lab
  (:refer-clojure :exclude [read])
  (:require [clojure.java.io :as io]
            [clojure.reflect :as r])
  (:import ;[org.imgscalr Scalr Scalr$Method Scalr$Mode]
           [java.awt Image Frame Label Dimension Graphics]
           [javax.swing JLabel JPanel ImageIcon]
           [java.awt.event WindowEvent WindowAdapter]
           ;[java.awt.image RenderedImage BufferedImageOp]
           [javax.imageio ImageIO ImageWriter ImageWriteParam IIOImage]
           [javax.imageio.stream FileImageOutputStream]))

(defn read
  "Reads a BufferedImage from source, something that can be turned into
  a file with clojure.java.io/file"
  [source]
  (ImageIO/read (io/file source)))

(def img (read "a.png"))
(println img)

;(println (r/reflect img))
(println '_width (.getWidth img))
(println 'height (.getHeight img))

;(comment 
(def frame
     (doto (Frame. "Close Operation Frame")
           (.add (JLabel. (ImageIcon. img)))
           ;(.add (Label. "Welcom in Roseindia.net Tutorial" (Label/CENTER)))
           (.setSize (Dimension. (.getWidth img) (.getHeight img)))
           (.setVisible true)
           (.addWindowListener
             (proxy [WindowAdapter] []
               (windowClosing [e] (.dispose frame))))))
;)
