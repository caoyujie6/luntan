package main.hj.luntan.seriver.impl;

import main.hj.luntan.dao.impl.MinganciDaoImpl;
import main.hj.luntan.seriver.MinganciSeriver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MinganciSeriverImpl implements MinganciSeriver {
    MinganciDaoImpl minganciDao=new MinganciDaoImpl();
    @Override
    public int du(String file1) {
        Set<String> keyWordSet = new HashSet<String>();  //声明一个set集合
        File file=new File(file1);
        if(!file.exists()){      //文件流是否存在
            return 0;
        }

        BufferedReader reader=null; //创建缓存对象
        String temp=null;
        try{
            reader=new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
            while((temp=reader.readLine())!=null){
                //System.out.println("line"+line+":"+temp);
                keyWordSet.add(temp);//把出来得每行数据添加刀集合里面
                //line++;
            }
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            if(reader!=null){
                try{
                    reader.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        for (Iterator<String> iterator=keyWordSet.iterator();iterator.hasNext();){
            minganciDao.zeng(iterator.next());
        }
        return 1;
    }

    public static void main(String[] args) {
        MinganciSeriverImpl minganciSeriver=new MinganciSeriverImpl();
        int i=minganciSeriver.du("D:\\安装包集合地\\新建文件夹\\网站敏感词库\\百度敏感词\\百度过滤词.txt");
        System.out.println(i);
    }
}
