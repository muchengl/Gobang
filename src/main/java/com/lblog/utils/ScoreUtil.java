package com.lblog.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//取得这个点的最大分数
public class ScoreUtil {
    private static int[][] position = {
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
        {0,1,2,2,2,2,2,2,2,2,2,2,2,1,0},
        {0,1,2,3,3,3,3,3,3,3,3,3,2,1,0},
        {0,1,2,3,4,4,4,4,4,4,4,3,2,1,0},
        {0,1,2,3,4,5,5,5,5,5,4,3,2,1,0},
        {0,1,2,3,4,5,6,6,6,5,4,3,2,1,0},
        {0,1,2,3,4,5,6,7,6,5,4,3,2,1,0},
        {0,1,2,3,4,5,6,6,6,5,4,3,2,1,0},
        {0,1,2,3,4,5,5,5,5,5,4,3,2,1,0},
        {0,1,2,3,4,4,4,4,4,4,4,3,2,1,0},
        {0,1,2,3,3,3,3,3,3,3,3,3,2,1,0},
        {0,1,2,2,2,2,2,2,2,2,2,2,2,1,0},
        {0,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};



    public static String getAScore(int a,int b,int[][] map,int x,int y,int deep){

        String s="";
        for(int i=1;i<=9;i++){
            if(deep%2==1){//电脑先手，因此奇数
                if(x>=1 && x<=15 && y>=1 && y<=15) {
                    s = s + map[y][x];
                }

            }
            else{//玩家层，反转玩家和电脑，便于下边的字符串匹配
                if(x>=1 && x<=15 && y>=1 && y<=15) {
                    if (map[y][x] == 1) {
                        s = s + 2;
                    } else if (map[y][x] == 2) {
                        s = s + 1;
                    }
                    else{
                        s = s + 0;
                    }

                }
            }
            x = x + a;
            y = y + b;
        }
        return s;
    }
    public static int Scoreutil(int x,int y,int[][] map,int deep) {


        Map<String, Integer> scoreList = new HashMap<>();
        scoreList.put("11111", 5000000);

        scoreList.put("010", 40);

        scoreList.put("0110", 400);

        scoreList.put("01110", 3000);

        scoreList.put("011110", 1000000);

        scoreList.put("012", 20);
        scoreList.put("210", 20);

        scoreList.put("0112", 200);
        scoreList.put("2110", 200);

        scoreList.put("21110", 500);
        scoreList.put("01112", 500);

        scoreList.put("211110", 2000);
        scoreList.put("011112", 2000);

        int max = 0;
        String s1 = getAScore(1, 1, map, x - 4, y - 4, deep);
        String s2 = getAScore(1, 0, map, x - 4, y, deep);
        String s3 = getAScore(0, 1, map, x, y - 4, deep);
        String s4 = getAScore(1, -1, map, x - 4, y + 4, deep);


        Set<String> mapSet = scoreList.keySet();    //获取所有的key值 为set的集合
        Iterator<String> itor = mapSet.iterator();//
        while (itor.hasNext()) {//存在下一个值
            String key = itor.next();//当前key值

            if (s1.contains(key)) {
                if (scoreList.get(key) > max) {
                    max = scoreList.get(key);
                }
            }
            else if (s2.contains(key)) {
                if (scoreList.get(key) > max) {
                    max = scoreList.get(key);
                }
            }
            else if (s3.contains(key)) {
                if (scoreList.get(key) > max) {
                    max = scoreList.get(key);
                }
            }
            else if (s4.contains(key)) {

                if (scoreList.get(key) > max) {
                    max = scoreList.get(key);
//                    System.out.println(max);
                }
            }


        }

        if (deep % 2 == 1) {//电脑先手

            return -max - position[y - 1][x - 1];//电脑层，得分尽可能小
        } else {
//            System.out.println(max + position[y - 1][x - 1]+14);
            return max + position[y - 1][x - 1]+14;//模拟玩家，尽可能大
        }
    }




//    public static void main(String[] args) {
//        int[][] map =new int[16][16];
//        map[3][3]=1;
//        map[3][4]=1;
//        map[3][5]=1;
//        map[3][2]=1;
//
//        System.out.println(Scoreutil(15,15,map,2));
//    }
//public static void main(String[] args) {
//    String s1="00011111";
//    String s2="11111";
//    System.out.println(s1.contains(s2));
//}
}
