package com.guyang.myIkAnalyzer.analyzerStudy;

import org.apache.lucene.util.Attribute;

/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description 用一句话描述这个类
 * @date 2019/2/27 17:59$
 */
public interface MyCharAttribute extends Attribute {

    void setChars(char[] buffer,int length);

    char[] getChars();

    int getLength();

    String getString();

}
