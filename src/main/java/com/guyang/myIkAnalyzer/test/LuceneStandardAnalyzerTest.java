package com.guyang.myIkAnalyzer.test;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.IOException;

/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description 测试lucene提供的标准分词器
 * @date 2019/3/1 10:07$
 */
public class LuceneStandardAnalyzerTest {


    public static void main(String args[]) throws Exception{

        StandardAnalyzer standardAnalyzer = new StandardAnalyzer();
        String en1 = "Success is getting what you want, happiness is wanting what you get.";
        String cn1 = "张三说的确实在理";
        TokenStream tokenStream = standardAnalyzer.tokenStream("hello", en1);

        doIncrement(tokenStream);

        TokenStream tokenStream1 = standardAnalyzer.tokenStream("hello", cn1);

        doIncrement(tokenStream1);


    }

    private static void doIncrement(TokenStream tokenStream) throws IOException {
        tokenStream.reset();
        CharTermAttribute attribute = tokenStream.getAttribute(CharTermAttribute.class);
        while (tokenStream.incrementToken()) {
            System.out.print(attribute.toString() + "|");
        }
        System.out.println();
        tokenStream.end();
        tokenStream.close();
    }

}
