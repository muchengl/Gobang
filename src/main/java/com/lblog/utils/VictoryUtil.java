package com.lblog.utils;

public class VictoryUtil {
    public static int findVictory(int a,int b,int[][] map){//
        for(int i=1;i<=15;i++){
            for(int j=1;j<=15;j++){
                int flag=0;
                int i_=i,j_=j;
                for(int k=1;k<=4;k++){
                    i_=i_+a;
                    j_=j_+b;
                    if(i_>=1 && i_<=15 && j_>=1 && j_<=15){
                        if(!(map[i_][j_]==map[i][j]) ) {
                            flag = 1;
                            break;
                        }
                    }
                    else{
                        flag=1;
                    }
                }
                if(flag==0){
                    if(map[i][j]==0) flag=0;
                    else if(map[i][j]==1) return 1;
                    else {
//                        System.out.println(i+" "+j+"------");
                        return 2;
                    }
                }
            }
        }
        return 0;
    }
    public static int getVictory(int[][] map){

        int a1=findVictory(1,1,map);
        int a2=findVictory(0,1,map);
        int a3=findVictory(1,0,map);

        int a4=findVictory(-1,-1,map);
        int a5=findVictory(-1,0,map);
        int a6=findVictory(0,-1,map);

        int a7=findVictory(-1,1,map);
        int a8=findVictory(1,-1,map);


        if(a1!=0) return a1;
        if(a2!=0) return a2;
        if(a3!=0) return a3;
        if(a4!=0) return a4;
        if(a5!=0) return a5;
        if(a6!=0) return a6;
        if(a7!=0) return a7;
        if(a8!=0) return a8;


        return 0;//1为白胜利，2为黑胜利，0为无胜负
    }
}
