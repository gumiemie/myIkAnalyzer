package com.guyang.myIkAnalyzer.test;


import com.guyang.myIkAnalyzer.ikStuday.IkAnalyzer4Lucene7;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description 用一句话描述这个类
 * @date 2019/3/1 13:47$
 */
public class ExtIKAnalyzer4Lucene7Test {

    public static void main(String args[])throws Exception{
        IkAnalyzer4Lucene7 ikAnalyzer4Lucene7 = new IkAnalyzer4Lucene7(true);
        TokenStream tokenStream = ikAnalyzer4Lucene7.tokenStream("hello", "厉害了我的国一经播出，受到各方好评，强烈激发了国人的爱国之情、自豪感！");
        doIncrement(tokenStream);
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
