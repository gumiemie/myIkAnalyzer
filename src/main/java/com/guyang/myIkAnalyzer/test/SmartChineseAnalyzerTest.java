package com.guyang.myIkAnalyzer.test;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description 测试lucene提供的SmartChineseAnalyzer
 * @date 2019/3/1 10:24$
 */
public class SmartChineseAnalyzerTest {


    public static void main(String args[])throws Exception{
        String en1 = "Success is getting what you want, happiness is wanting what you get.";
        String cn1 = "张三说的确实在理";

        SmartChineseAnalyzer smartChineseAnalyzer = new SmartChineseAnalyzer();
        TokenStream tokenStream1 = smartChineseAnalyzer.tokenStream("en", en1);

        doIncrement(tokenStream1);

        TokenStream tokenStream2 = smartChineseAnalyzer.tokenStream("cn", cn1);

        doIncrement(tokenStream2);

    }


    private static void doIncrement(TokenStream tokenStream)throws Exception{
        tokenStream.reset();
        CharTermAttribute attribute = tokenStream.getAttribute(CharTermAttribute.class);
        while (tokenStream.incrementToken()){
            System.out.print(attribute.toString()+"|");
        }
        tokenStream.end();
        tokenStream.close();
    }

}
