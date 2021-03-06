package com.springBootPlactice.java11.application.controller;

import com.springBootPlactice.java11.application.form.TopForm;
import com.springBootPlactice.java11.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/top")
public class TopController {
    /** 文字列操作ユーティリティ（フィールドインジェクションは推奨されてないのであまり使わないこと） */
    @Autowired
    StringUtils stringUtils;
    /**
     * 初期表示用のメソッド。
     * {URL}/topで呼び出される。
     * @return トップ画面html
     */
    @GetMapping
    public String init(Model model) {
        model.addAttribute("topForm",new TopForm());
        return "top";
    }

    /**
     * サブミットボタン押下時用のメソッド。
     * {URL}/top/submitで呼び出される。
     * @return トップ画面html
     */
    @PostMapping(value = "/submit")
    public String submit(Model model, /** @Validated */TopForm form, BindingResult result) {
        // コメントアウトされているValidatedアノテーションを使うとBindingResultにエラーがバインドされる。
        // 下のコメントアウトを解除すると早期returnできる。
        // if(result.hasErrors()) return "top";

        // 名前取得
        String name = form.getName();

        // 本当は画面に表示したいけど時間がないのでコンソールで許して
        if (stringUtils.isEmpty(name)){
            System.out.println("エラーだよ");
        } else {
            System.out.println("正常だよ");
        }

        // 時間が足りないので自画面遷移
        return "top";
    }
}
