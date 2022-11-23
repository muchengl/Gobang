package com.lblog.service;

import com.lblog.pojo.Place;
import com.lblog.utils.JudgeUtil;
import com.lblog.utils.ScoreUtil;
import org.springframework.stereotype.Service;

@Service
public class AlphaBetaService {

    public Place AlphaBeta(int[][] map, int deep, int x, int y) {//按deep判断

        if (deep == 3) {//层数
            return new Place(0, 0, 0, 0);
        }

        if (deep % 2 == 1) {//单数，落白子
            map[y][x] = 1;
        }
        else {//偶数，落黑子
            map[y][x] = 2;
        }



        int score = ScoreUtil.Scoreutil(x, y, map, deep);//这个点的分数

        boolean flag = true;
        int min = 1000000;
        int MinX = 0, MinY = 0;
        int max = -1000000;
        int MaxX=0, MaxY=0;

        for (int i = 1; i <= 15; i++) {
            for (int j = 1; j <= 15; j++) {


                if (JudgeUtil.Judgeutil(j, i, map)) {
                    flag = false;//找到了一个落子点

                    int childScore = AlphaBeta(map, deep + 1, j, i).getScore();


                        if (deep % 2 == 1) {//单数，电脑下一层是玩家

                            if (childScore > max) {//设想玩家聪明，因此要取大值
                                max = childScore;
                                MinX = j;
                                MinY = i;
                            }
                        } else {//偶数，玩家尽可能取得大值

                            if (childScore < min) {
                                min = childScore;
                                MaxX = j;
                                MaxY = i;
                            }
                        }

                }
            }
        }




        map[y][x]=0;

        if (flag) {//先手首次落子，按设定下
            return null;
        }

        if (deep % 2 == 1) {//单数，电脑尽可能取得小值
            return new Place(0, MinX, MinY, score+max);

        } else {//偶数，玩家尽可能取得大值
            return new Place(0, MaxX, MaxY, score+min);

        }
    }
}
