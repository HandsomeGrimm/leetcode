package 递归遍历一个文件夹下所有文件;

import java.io.File;

public class Solution {

    public static void getFiles(File[] files){
        if (files==null){
            return;
        }
        for (File f:files){
            if (f.isFile()){
                System.out.println(f.getName());
            }else if (f.isDirectory()){
                getFiles(f.listFiles());
            }
        }

    }

    public static void main(String[] args) {
        String path="D:/";
        File file=new File(path);
        File[] files=file.listFiles();
        getFiles(files);
    }


}
