package com.guyang.myIkAnalyzer.ikStuday;

import org.apache.lucene.analysis.Analyzer;

/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description 用一句话描述这个类
 * @date 2019/3/1 11:10$
 */
public class IkAnalyzer4Lucene7 extends Analyzer {

    public IkAnalyzer4Lucene7(boolean userSmart) {
        this.userSmart = userSmart;
    }

    public IkAnalyzer4Lucene7() {
        this(false);
    }

    private boolean userSmart;

    public boolean isUserSmart() {
        return userSmart;
    }

    public void setUserSmart(boolean userSmart) {
        this.userSmart = userSmart;
    }

    protected TokenStreamComponents createComponents(String fieldName) {
        IKTokenizer4Lucene7 ikTokenizer4Lucene7 = new IKTokenizer4Lucene7(this.userSmart);
        return new TokenStreamComponents(ikTokenizer4Lucene7);
    }


}
