package com.springBootPlactice.java11.application.controller;

import com.springBootPlactice.java11.common.utils.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/***
 * TopController用のテストクラスです
 */
@SpringBootTest
@EnableWebMvc
public class TopControllerTest {

    private MockMvc mockMvc;
    @Autowired
    WebApplicationContext webApplicationContext;

    /**
     * テスト対象クラス。InjectMocksアノテーションを使うことでMockが流し込めるようになる。
     */
    @InjectMocks
    private TopController controller;
    /**
     * MockにはMockアノテーションを用いる。
     * モックとはテスト対象のクラス内で呼び出すクラス（依存クラス）の代替として使用するもののこと。
     * 今回はTopControllerからisEmptyを呼び出しているが、その戻り地を引数関係なく操作可能。
     */
    @Mock
    private StringUtils stringUtils;

    @BeforeEach
    void setup() {
        // 各テストの実行前にモックオブジェクトを初期化する
        MockitoAnnotations.initMocks(this);

        // Spring MVCのモックを設定する
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .build();
    }
    /**
     * initメソッドのテスト用メソッド。
     * メソッド名はコーディング規約で定められていることもある。
     * 私にとってはテストメソッド＋Testでメソッド名を作るのが馴染み深いのでそうしている。
     */
    @Test
    void initTest() throws Exception {
        when(stringUtils.isEmpty(any())).thenReturn(false);
        mockMvc.perform(get("/top"))
                .andExpect(status().isOk()) // ステータスコードは200で返っているか？
                .andExpect(view().name("top")); // Viewの名前（この場合はHTMLファイルの名前）はtopか？
        // ※Controllerをテストする際はステータスコードとView名の試験は必ずやること。
        // 必要であれば他の試験もやること。
    }

    /**
     * submitメソッドのテスト用メソッド。
     * 氏名入力があった想定でテストを行う。
     */
    @Test
    void submitTest1() throws Exception {
        // whenメソッドで stringUtils#isEmptyに何らかの引数を持たせて呼ばれた場合、false(氏名に入力あり)を返すように設定。
        when(stringUtils.isEmpty(any())).thenReturn(false);
        mockMvc.perform(post("/top/submit"))
                .andExpect(status().isOk()) // ステータスコードは200で返っているか？
                .andExpect(view().name("top")); // Viewの名前（この場合はHTMLファイルの名前）はtopか？
    }
    /**
     * submitメソッドのテスト用メソッド。
     * 氏名入力がなかった想定でテストを行う。
     */
    @Test
    void submitTest2() throws Exception {
        // whenメソッドで stringUtils#isEmptyに何らかの引数を持たせて呼ばれた場合、false(氏名に入力あり)を返すように設定。
        when(stringUtils.isEmpty(any())).thenReturn(true);
        mockMvc.perform(post("/top/submit"))
                .andExpect(status().isOk()) // ステータスコードは200で返っているか？
                .andExpect(view().name("top")); // Viewの名前（この場合はHTMLファイルの名前）はtopか？
    }


}
