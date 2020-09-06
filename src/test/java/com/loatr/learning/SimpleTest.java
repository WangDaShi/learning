package com.loatr.learning;

import static org.mockito.Mockito.ignoreStubs;
import static org.mockito.Mockito.never;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.assertj.core.util.Lists;
import org.springframework.cglib.core.ReflectUtils;

public class SimpleTest {

    private static ObjectMapper jsonMapper = new ObjectMapper();

    public static void main(String[] args) throws InterruptedException, JsonProcessingException, IOException {
        File jsonFile = new File("D://code/java/excel/setting.json");
        // Transaction tran = new Transaction();
        // tran.setId("123456");
        // tran.setNow(LocalDateTime.now());
        // tran.setNum(100);
        // fill(tran);

    }


    private static JsonNode phase(File file){
        JsonNode node;
        try {
            node = jsonMapper.readTree(file);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return node;
    }

    private static Mapper[] toMapper(JsonNode jsonNode) {
        return null;
    }

    private static Map<String,Object> matchData(Object[] datas,JsonNode node){
        List<String> names = Lists.newArrayList();
        for(JsonNode n : node){
            names.add(n.asText());
        }
        if(datas.length != names.size()){
            throw new IllegalArgumentException("输入数据与json配置不符");
        }
        Map<String,Object> dataMap = new HashMap<>();
        for(int i = 0;i < names.size();i++){
            if(dataMap.containsKey(names.get(i))){
                throw new IllegalArgumentException("存在重复的名字");
            }
            dataMap.put(names.get(i),datas[i]);
        }
        return dataMap;
    }

    public static void fill(File jsonFile,File excelFile,Object... datas) {
        JsonNode node = phase(jsonFile);
        Map<String,Object> dataMap = matchData(datas, node);
        List<Mapper> mappers = extractMapper(node.get("mappers"));
        for(Mapper mapper : mappers){
            mapper.map(dataMap);
        }
    }

    private static List<Mapper> extractMapper(JsonNode jsonNode) {
        return null;
    }

}
