package com.guyang.myIkAnalyzer.analyzerStudy;

import org.apache.lucene.util.AttributeImpl;
import org.apache.lucene.util.AttributeReflector;

/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description 用一句话描述这个类
 * @date 2019/2/28 9:14$
 */
public class MyCharAttributeImpl extends AttributeImpl implements MyCharAttribute {
    private char[] charTerm = new char[255];
    private int length = 0;

    public void setChars(char[] buffer, int length) {
        this.length = length;
        if (length > 0) {
            System.arraycopy(buffer, 0, this.charTerm, 0, length);
        }
    }

    public char[] getChars() {
        return this.charTerm;
    }

    public int getLength() {
        return this.length;
    }

    public String getString() {
        return this.length > 0 ? new String(this.charTerm, 0, this.length) : null;
    }

    public void clear() {
        this.length = 0;
    }

    public void reflectWith(AttributeReflector reflector) {

    }

    public void copyTo(AttributeImpl target) {

    }
}
