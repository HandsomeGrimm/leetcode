package 原始数组转稀疏数组;

import java.io.*;

/**
 * @author HandsomeGrimm
 * @Date: 2020/3/30 09:34
 * @Description:
 */
public class Solution {

    public static int[][]  arrToSparse(int [][] arr ){

        //有效数总数
        int sum=0;
        //几行
        int row=arr.length;
        //几列
        int col=arr[0].length;

        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if (arr[i][j]!=0){
                    sum++;
                }
            }
        }

        int[][] sparseArr=new int[sum+1][3];
        sparseArr[0][0]=row;
        sparseArr[0][1]=col;
        sparseArr[0][2]=sum;

        //稀疏数组的行数
        int m=0;
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if (arr[i][j]!=0){
                    m++;
                    sparseArr[m][0]=i;
                    sparseArr[m][1]=j;
                    sparseArr[m][2]=arr[i][j];
                }
            }
        }



        return sparseArr;
    }

    public static int[][] sparseToArr(int [][] sparse){
        int row=sparse[0][0];
        int col=sparse[0][1];
        int [][] arr=new int[row][col];

        //从第二行开始赋值
        for (int i=1;i<sparse.length;i++){
            arr[sparse[i][0]][sparse[i][1]]=sparse[i][2];
        }
        return arr;
    }

    public static void saveArrToDisk(int[][] arr ,String path) throws IOException {
        File file=new File(path);
        FileWriter out=new FileWriter(file);
        //将数组中的数据写入到文件中。每行各数据之间TAB间隔
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[i].length;j++){
                out.write(arr[i][j]+"\t");
            }
            out.write("\r\n");
        }
        out.close();
    }

    public static int[][] readFromDisk(String path) throws IOException {
        BufferedReader in=new BufferedReader(new FileReader(new File(path)));
        //一行数据
        String line;
        //数组总行数
        int row=0;
        //数组总列数
        int col=0;
        while ((line=in.readLine())!=null){
            String[] temp = line.split("\t");
            row++;
            col=temp.length;
        }
        in.close();

        BufferedReader readIn=new BufferedReader(new FileReader(new File(path)));
        int[][] arr=new int[row][col];
        int m=0;
        String readLine;
        while ((readLine=readIn.readLine())!=null){
            String[] temp=readLine.split("\t");
            for (int n=0;n<temp.length;n++){
                arr[m][n]=Integer.parseInt(temp[n]);
            }
            m++;
        }
        readIn.close();
        return arr;
    }

    public static void main(String[] args) throws IOException {
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        System.out.println("原始的二维数组：");
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                System.out.print(chessArr[i][j]+"\t");
            }
            System.out.println();
        }

        int [][] sparse=arrToSparse(chessArr);
        System.out.println();
        System.out.println("稀疏数组：");
        for (int[] row : sparse) {
            for (int data : row) {
                System.out.print(data+"\t");
            }
            System.out.println();
        }
        String path="d:\\\\array.txt";
        saveArrToDisk(sparse,path);

        int[][] ints = readFromDisk(path);
        System.out.println();
        System.out.println("读取数组：");
        for (int[] row : ints) {
            for (int data : row) {
                System.out.print(data+"\t");
            }
            System.out.println();
        }

        int[][] arr=sparseToArr(sparse);
        System.out.println();
        System.out.println("恢复后的二维数组：");
        for (int[] row : arr) {
            for (int data : row) {
                System.out.print(data+"\t");
            }
            System.out.println();
        }

    }



}
