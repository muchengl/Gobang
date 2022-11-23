package com.lblog.service;

import com.lblog.pojo.Place;

import com.lblog.utils.JudgeUtil;
import com.lblog.utils.ScoreUtil;
import com.lblog.utils.VictoryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PlaceService {
    @Autowired
    AlphaBetaService alphaBetaService;

    public Place getPlace(int x,int y,int[][] map){

        if(map[y][x]==0) {
            map[y][x] = 2; //黑色
        }
        else{
            return new Place(-1,0,0,0);//非法落子，返回-1
        }

        int ans= VictoryUtil.getVictory(map);//首先判断是否结束

//        System.out.println(ans);
        if(ans==1){//白棋赢
            return new Place(ans,0,0,0);
        }
        else if(ans==2){//黑棋yinbg
            return new Place(ans,0,0,0);
        }
        else{//没有分出胜负

            int Mx=0,My=0;
            int min=10000000;
            Place place=null;
            for(int i=1;i<=15;i++) {
                for (int j = 1;j<= 15;j++) {
                    if(JudgeUtil.Judgeutil(j,i,map)) {//可以落子
//                        System.out.println(i+" "+j);
                        place = alphaBetaService.AlphaBeta(map, 1, j, i);//调用函数

                        if (place.getScore() < min) {
//                           System.out.println(place.getScore());
                            min = place.getScore();
                            Mx = j;
                            My = i;
                        }

                    }
                }
            }



//            System.out.println(min);
            if(place==null){
                Mx=x+1;
                My=y+1;
            }


            map[My][Mx]=1;//标记在图中，便于判断


            int ans2= VictoryUtil.getVictory(map);//白棋下后，判断是否结束
            if(ans2==1){
                return new Place(1, Mx, My,0);
            }
            else if(ans2==2){
                return new Place(2, Mx, My,0);
            }
            else {
                return new Place(ans, Mx, My,0);
            }
        }
    }

}


//  System.out.println("=================");
//          for(int k=1;k<=15;k++){
//          for(int l=1;l<=15;l++){
//          System.out.print(map[k][l]+" ");
//          }
//          System.out.println();
//          }
//          System.out.println("=================");
