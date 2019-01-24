package com.zhaowei.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhaowei.constant.Constant;
import com.zhaowei.entity.Word;
import com.zhaowei.util.ImageHandleHelper;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: wei.zhao
 * @Date: Create in  2018/12/3 16:40
 * @Description:
 * @Modified By:
 */
@RestController
public class ImgController {

    @RequestMapping(value = "/cutImage", method = RequestMethod.POST)
    public void cutImage(String srcFile, String targetFile, int startAcross, int startEndlong, int width, int hight){
        try {
            ImageHandleHelper.cutImage(srcFile,targetFile,startAcross,startEndlong,width,hight);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/mergeImage", method = RequestMethod.POST)
    public void mergeImage( String[] files, int type, String targetFile) {
        ImageHandleHelper.mergeImage(files,type,targetFile);
    }

    @RequestMapping(value = "/drawStringForImage", method = RequestMethod.POST)
    public void drawStringForImage(String srcFile, String content1, String content2, String targetFile) {
        ImageHandleHelper.drawStringForImage(srcFile,content1,content2,targetFile);
    }

    @RequestMapping(value = "/overlapImage", method = RequestMethod.POST)
    public void overlapImage(String bigPath, String smallPath, String outFile) {
        ImageHandleHelper.overlapImage(bigPath,smallPath,outFile);
    }

    @RequestMapping(value = "/demo", method = RequestMethod.POST)
    public void demo(String message) {
        String descStr = "";
        try {
            descStr = URLDecoder.decode(message, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(descStr);
        JSONObject json = JSONObject.parseObject(descStr);
        String charArr=json.getString("charArr");
        List<Word> wordList = JSONArray.parseArray(charArr, Word.class);
        List<String> fileList = new ArrayList<>();
        Word word = new Word("","",0);
        if(wordList.size()%2!=0){
            wordList.add(word);
        }
        String[] fileStr = new String[wordList.size()];
        for (int i = 0;i<wordList.size();i++) {
            String srcFile = Constant.PICTURE_URL+"love.jpg";
            //添加文字生成新图片
            String file = ImageHandleHelper.drawStringForImage(srcFile,wordList.get(i).getSingle(),wordList.get(i).getWord(),null);
            fileStr[i] = file;
            fileList.add(file);
        }
        //每2张先进行横向拼接
        String[] fileStr2 = new String[fileStr.length/2];
        for(int i = 0;i<fileStr.length-1;i=i+2){
            String[] arr = new String[2];
            arr[0]=fileStr[i];
            arr[1]=fileStr[i+1];
            String file1 = ImageHandleHelper.mergeImage(arr,1,null);
            fileStr2[i/2] = file1;
            fileList.add(file1);
        }
        //最后纵向拼接
        ImageHandleHelper.mergeImage(fileStr2,2,Constant.PICTURE_URL+"result.jpg");
        for (String f:fileList) {
            try {
                FileUtils.forceDelete(new File(f));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public void test(String content, String targetFile) {
        String srcFile = Constant.PICTURE_URL+"love.jpg";
        System.out.println(srcFile);
        String[] str = content.split(",");
        List<String> fileList = new ArrayList<>();
        if(str.length>0){
            if(str.length%2==0){
                String[] fileStr = new String[str.length];
                //添加文字生成新图片
                for(int i = 0;i<str.length;i++){
                    String file = ImageHandleHelper.drawStringForImage(srcFile,str[i],"2",null);
                    fileStr[i] = file;
                    fileList.add(file);
                }
                //每2张先进行横向拼接
                String[] fileStr2 = new String[fileStr.length/2];
                for(int i = 0;i<fileStr.length-1;i=i+2){
                    String[] arr = new String[2];
                    arr[0]=fileStr[i];
                    arr[1]=fileStr[i+1];
                    String file1 = ImageHandleHelper.mergeImage(arr,1,null);
                    fileStr2[i/2] = file1;
                    fileList.add(file1);
                }
                //最后纵向拼接
                ImageHandleHelper.mergeImage(fileStr2,2,Constant.PICTURE_URL+"result.jpg");

            }
            else {
                String[] fileStr = new String[str.length+1];
                for(int i = 0;i<str.length;i++){
                    String file = ImageHandleHelper.drawStringForImage(srcFile,str[i],"1",null);
                    fileStr[i] = file;
                    fileList.add(file);
                }
                fileStr[fileStr.length-1]=srcFile;
                //每2张先进行横向拼接
                String[] fileStr2 = new String[fileStr.length/2];
                for(int i = 0;i<fileStr.length-1;i=i+2){
                    String[] arr = new String[2];
                    arr[0]=fileStr[i];
                    arr[1]=fileStr[i+1];
                    String file1 = ImageHandleHelper.mergeImage(arr,1,null);
                    fileStr2[i/2] = file1;
                    fileList.add(file1);
                }
                //最后纵向拼接
                ImageHandleHelper.mergeImage(fileStr2,2,Constant.PICTURE_URL+"result.jpg");
            }
            for (String f:fileList) {
                try {
                    FileUtils.forceDelete(new File(f));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
