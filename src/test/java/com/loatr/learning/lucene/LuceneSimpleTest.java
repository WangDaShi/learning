package com.loatr.learning.lucene;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LuceneSimpleTest {

    @Test
    @DisplayName("第一个测试")
    public void test(){
        Document doc = new Document();
        doc.add(new TextField("title","这是一个标题", Field.Store.YES));
    }
}
