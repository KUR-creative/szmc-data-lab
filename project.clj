(defproject szmc-data "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :repositories [["JCenter" "https://jcenter.bintray.com/"]] ;;https://github.com/milankinen/cuic/commit/b7fcc0d76fda4ff47c8da93597715a5be4532a1f
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/java.jdbc "0.7.9"]
                 [org.xerial/sqlite-jdbc "3.28.0"]
                 [honeysql "0.9.5"]
                 [com.github.kilianB/JImageHash "3.0.0"] ;; https://mvnrepository.com/artifact/com.github.kilianB/JImageHash
                 ]
  :repl-options {:init-ns szmc-data.core}
  :main szmc-data.core)
