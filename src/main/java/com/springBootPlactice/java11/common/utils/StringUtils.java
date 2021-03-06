package com.springBootPlactice.java11.common.utils;

import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 文字列操作に関するユーティリティクラス
 */
@Component
public class StringUtils {
    /**
     * 文字列を受け取り、空白かどうかを判定します。
     * Nullも空白だと判定されます。
     * @param value 判定対象
     * @return 判定結果
     */
    public boolean isEmpty(String value){
        // Nullの場合は空白判定
        if (Objects.isNull(value)) return true;

        // String標準のisEnptyで評価した結果をreturn
        return value.isEmpty();
    }
}
