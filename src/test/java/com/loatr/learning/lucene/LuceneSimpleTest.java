package com.loatr.learning.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class LuceneSimpleTest {

    @Test
    @DisplayName("第一个测试")
    public void test() throws IOException {
        Document doc = new Document();
        doc.add(new TextField("title", "这是一个标题", Field.Store.YES));
        doc.add(new StringField("id", "1", Field.Store.YES));
        //2 索引目录类,指定索引在硬盘中的位置
        Directory directory = FSDirectory.open(Path.of("D://code/Lucene/index"));
        //3 创建分词器对象
        Analyzer analyzer = new StandardAnalyzer();
        //4 索引写出工具的配置对象
        IndexWriterConfig conf = new IndexWriterConfig(analyzer);
        //5 创建索引的写出工具类。参数：索引的目录和配置信息
        IndexWriter indexWriter = new IndexWriter(directory, conf);
        //6 把文档交给IndexWriter
        indexWriter.addDocument(doc);
        //7 提交
        indexWriter.commit();
        //8 关闭
        indexWriter.close();
    }

    public void test1(){

    }

    public void test2(){

    }

    public void test3(){

    }

    public void test4()
    {

    }

    public void test5()
    {

    }

//one, two, three, four    ,

////    one two three four five six         Directory directory = FSDirectory.open(Path.of("D://code/Lucene/index"));
//    one two three four five six         Directory directory = FSDirectory.open(Path.of("D://code/Lucene/index"));
//    one two three four five six         Directory directory = FSDirectory.open(Path.of("D://code/Lucene/index"));
//    one two three four five six         Directory directory = FSDirectory.open(Path.of("D://code/Lucene/index"));
//    one two three four five six         Directory directory = FSDirectory.open(Path.of("D://code/Lucene/index"));
//    one two three four five six         Directory directory = FSDirectory.open(Path.of("D://code/Lucene/index"));
//    one two three four five six         Directory directory = FSDirectory.open(Path.of("D://code/Lucene/index"));


//    one two three four five six
//    one two three four five six}
//    one two three four five six
//    one two three (four five six)
//    one two three four five six
//    one two three four five six one
//    one two three four five six
//    one two three four) five six
//    one two three four five six

}