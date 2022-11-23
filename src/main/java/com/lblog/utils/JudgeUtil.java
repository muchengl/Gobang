package com.lblog.utils;
//判断是否有临近点
public class JudgeUtil {
    public static boolean find(int a,int b,int[][] map,int x,int y){//



        int xx=x,yy=y;
        for(int k=1;k<=2;k++){
            x=x+a;
            y=y+b;
            if(x>=1 && x<=15 && y>=1 && y<=15){
                //这种代码只考虑眼前利益，所以会下在自己方棋子附近，但实际情况中，有时需要围堵对方，因此附近有对方但棋子，也为合法点
//                if(map[y][x]== 1) {//首先遇到白棋，等于白棋，电脑方
//                    return true;
//                }
//                else if(map[y][x]==2){//首先遇到黑棋
//                    return false;
//                }

                //周围有子，就可以下
                if(map[y][x]!= 0) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean Judgeutil(int x,int y,int[][] map){



        if(map[y][x]==2 || map[y][x]==1) return false;
        boolean a1=find(1,1,map,x,y);
        boolean a2=find(0,1,map,x,y);
        boolean a3=find(1,0,map,x,y);

        boolean a4=find(-1,-1,map,x,y);
        boolean a5=find(0,-1,map,x,y);
        boolean a6=find(-1,0,map,x,y);

        boolean a7=find(1,-1,map,x,y);
        boolean a8=find(-1,1,map,x,y);


        if(a1 || a2 || a3 || a4 ||a5 || a6 || a7 || a8){
            return true;
        }
        return false;

    }

}
