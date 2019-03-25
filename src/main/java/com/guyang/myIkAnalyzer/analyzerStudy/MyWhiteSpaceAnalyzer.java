package com.guyang.myIkAnalyzer.analyzerStudy;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;

/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description 用一句话描述这个类
 * @date 2019/2/28 10:12$
 */
public class MyWhiteSpaceAnalyzer extends Analyzer {

    protected TokenStreamComponents createComponents(String fieldName) {
        Tokenizer tokenizer = new MyWhiteSpaceTokenizer();
        TokenFilter tokenFilter = new MyLowerCaseTokenFilter(tokenizer);
        return new TokenStreamComponents(tokenizer, tokenFilter);
    }


    public static void main(String args[]) {

        String text = "An AttributeSource contains a list of different AttributeImpls, and methods to add and get them.";

        try {

            Analyzer analyzer = new MyWhiteSpaceAnalyzer();

            TokenStream tokenStream = analyzer.tokenStream("aa", text);

            MyCharAttribute myCharAttribute = tokenStream.getAttribute(MyCharAttribute.class);

            tokenStream.reset();

            while (tokenStream.incrementToken()) {
                System.out.print(myCharAttribute.getString() + "|");
            }
            tokenStream.end();
            analyzer.close();
            System.out.println("");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
