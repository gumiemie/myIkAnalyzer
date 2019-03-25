package com.guyang.myIkAnalyzer.ikStuday;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.util.TokenizerFactory;
import org.apache.lucene.util.AttributeFactory;

import java.util.Map;

/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description 用一句话描述这个类
 * @date 2019/3/1 14:26$
 */
public class IKTokenizer4Lucene7Factory extends TokenizerFactory {

    public IKTokenizer4Lucene7Factory(Map<String, String> args) {
        super(args);
    }

    private boolean userSmart;

    public boolean isUserSmart() {
        return userSmart;
    }

    public void setUserSmart(boolean userSmart) {
        this.userSmart = userSmart;
    }

    public Tokenizer create(AttributeFactory attributeFactory) {
        return new IKTokenizer4Lucene7(this.userSmart);
    }
}
