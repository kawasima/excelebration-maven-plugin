(with-sheet renderer "表紙"
  (render {:x 1 :y 1} (str (get opts :client-name "上") "様"))
  (render {:x 5 :y 9}
    [:table
     [:tr
      [:td {:data-width 44 :data-height 10
            :style "text-align: center; vertical-align: middle; font-size: 32"}
       (get opts :project-name "ほげプロジェクト\n基本設計書")]]]))
(doseq [source sources]
  (with-sheet renderer "sheet1"
    (render {:x 0 :y 0}
      [:table
       [:tr
        [:td {:data-width 36} "基本設計書"]
               [:td {:data-width 4} "作成日"]
               [:td {:data-width 6} (get opts :created-at (java.util.Date.))]]
       [:tr
        [:td {:rowspan 3 :data-width 12 :style "text-align: center"} "u"]
        [:td {:data-width 4} "システム"]
        [:td {:data-width 8} "ほげシステム"]
        [:td {:data-width 4} "画面ID"]
        [:td {:data-width 8} "PAGE001"]
        [:td {:data-width 4} "作成者"]
        [:td {:data-width 6} (get opts :created-at (java.util.Date.))]]
       [:tr
        [:td {:rowspan 2} "サブシステム"]
        [:td {:rowspan 2} "hoge"]
        [:td {:rowspan 2} "画面名"]
        [:td {:rowspan 2} "A画面"]
        [:td "更新日"]
        [:td ""]]
       [:tr
        [:td "更新者"]
        [:td "kawasima"]]])
    (render {:x 0 :y 5} (wrap-src source))))

