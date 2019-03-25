package com.guyang.myIkAnalyzer.test;

import com.guyang.myIkAnalyzer.ikStuday.IkAnalyzer4Lucene7;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description 用一句话描述这个类
 * @date 2019/3/1 11:46$
 */
public class IKAnalyzer4Lucene7Test {

    public static void main(String args[]) throws Exception {
        String context = "张三说的确实在理";
        IkAnalyzer4Lucene7 ikAnalyzer4Lucene7 = new IkAnalyzer4Lucene7();
        TokenStream tokenStream = ikAnalyzer4Lucene7.tokenStream("hello",context);
        doIncreament(tokenStream);

        ikAnalyzer4Lucene7 = new IkAnalyzer4Lucene7(true);
        tokenStream = ikAnalyzer4Lucene7.tokenStream("haha",context);
        doIncreament(tokenStream);

    }

    private static void doIncreament(TokenStream tokenStream) throws Exception {

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
