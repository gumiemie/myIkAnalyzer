package com.guyang.myIkAnalyzer.ikStuday;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.wltea.analyzer.IKSegmentation;
import org.wltea.analyzer.Lexeme;

import java.io.IOException;

/**
 * @author 顾洋 <guyang@ebnew.com>
 * @description 用一句话描述这个类
 * @date 2019/3/1 11:15$
 */
public class IKTokenizer4Lucene7 extends Tokenizer {


    //ik分词器实现
    private IKSegmentation _IKImplement;
    //词元文本属性
    private final CharTermAttribute termAtt = this.addAttribute(CharTermAttribute.class);
    //词元位移属性
    private final OffsetAttribute offsetAtt = this.addAttribute(OffsetAttribute.class);
    // 词元分类属性（该属性分类参考org.wltea.analyzer.core.Lexeme中的分类常量）
    private final TypeAttribute typeAtt = this.addAttribute(TypeAttribute.class);
    // 记录最后一个词元的结束位置
    private int endPosition;

    public IKTokenizer4Lucene7(boolean userSmart) {
        super();
        this._IKImplement = new IKSegmentation(input,userSmart);
    }

    public final boolean incrementToken() throws IOException {
        this.clearAttributes();
        Lexeme nextLexeme = this._IKImplement.next();
        if (nextLexeme != null) {
            // 将Lexeme转成Attributes
            // 设置词元文本
            this.termAtt.append(nextLexeme.getLexemeText());
            // 设置词元长度
            this.termAtt.setLength(nextLexeme.getLength());
            // 设置词元位移
            this.offsetAtt.setOffset(nextLexeme.getBeginPosition(), nextLexeme.getEndPosition());
            // 记录分词的最后位置
            this.endPosition = nextLexeme.getEndPosition();
            // 记录词元分类
            typeAtt.setType(nextLexeme.getLexemeText());
            // 返会true告知还有下个词元
            return true;
        } else {
            return false;
        }
    }

    public void reset() throws IOException {
        super.reset();
        this._IKImplement.reset(input);
    }

    public final void end() {
        int offset = correctOffset(endPosition);
        this.offsetAtt.setOffset(offset, offset);
    }
}
