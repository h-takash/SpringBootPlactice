package com.springBootPlactice.java11.application.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Top画面で使用するためのフォームです。
 */
@Data
public class TopForm {
    /** 氏名 */
    @NotBlank
    private String name;

}
