package com.guyang.myIkAnalyzer.analyzerStudy;

import org.apache.lucene.analysis.Tokenizer;

import java.io.IOException;

/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description 用一句话描述这个类
 * @date 2019/2/27 17:30$
 */
public class MyWhiteSpaceTokenizer extends Tokenizer {

    MyCharAttribute attribute = this.addAttribute(MyCharAttribute.class);

    char[] buffer = new char[255];
    int length = 0;
    int c;

    @Override
    public boolean incrementToken() throws IOException {
        clearAttributes();
        length = 0;
        while (true) {
            c = this.input.read();
            if (c == -1) {
                if (length > 0) {
                    this.attribute.setChars(buffer, length);
                    return true;
                } else {
                    return false;
                }
            }
            if (Character.isWhitespace(c)) {
                if (length > 0) {
                    this.attribute.setChars(buffer, length);
                    return true;
                }
            }

            buffer[length++] = (char) c;
        }

    }
}
