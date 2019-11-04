(ns szmc-data.awt-lab
  (:import [java.awt Frame Label Dimension]
           [java.awt.event WindowEvent WindowAdapter]))

(def frame
     (doto (Frame. "Close Operation Frame")
       (.add (Label. "Welcom in Roseindia.net Tutorial" (Label/CENTER)))
       (.setSize (Dimension. 400 400))
       (.setVisible true)
       (.addWindowListener
	(proxy [WindowAdapter] []
	  (windowClosing [e] (.dispose frame))))))

(println frame)

(println
(for [meth (.getMethods java.awt.Frame)
      :let [name (.getName meth)]
      :when (re-find #"Vis" name)]
  name))
