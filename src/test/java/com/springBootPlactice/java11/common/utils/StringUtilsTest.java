package com.springBootPlactice.java11.common.utils;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

/***
 * StringUtils用のテストクラスです
 */
@SpringBootTest
public class StringUtilsTest {
    /**
     * テスト対象クラス。InjectMocksアノテーションを使うことでMockが流し込めるようになる。
     */
    @InjectMocks
    private StringUtils utils;

    @BeforeEach // テストメソッド（@Testをつけたメソッド）実行前に都度実施
    public void initmocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void isEmptyTest(){
         assertTrue(utils.isEmpty(null));
    }


}
