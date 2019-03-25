package com.guyang.myIkAnalyzer.analyzerStudy;

import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;

import java.io.IOException;

/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description 用一句话描述这个类
 * @date 2019/2/28 9:55$
 */
public class MyLowerCaseTokenFilter extends TokenFilter {

    public MyLowerCaseTokenFilter(TokenStream input) {
        super(input);
    }

    private MyCharAttribute myAttribute = this.addAttribute(MyCharAttribute.class);

    public boolean incrementToken() throws IOException {
        boolean b = this.input.incrementToken();
        if (b) {
            char[] chars = myAttribute.getChars();
            int length = myAttribute.getLength();
            if (length > 0) {
                for (int i = 0; i < length; i++) {
                    chars[i] = Character.toLowerCase(chars[i]);
                }
            }
        }
        return b;
    }
}
