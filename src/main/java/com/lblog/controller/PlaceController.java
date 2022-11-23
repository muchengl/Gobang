package com.lblog.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lblog.pojo.Place;
import com.lblog.service.PlaceService;
import com.lblog.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlaceController {
    int[][] map=new int[16][16];

    @Autowired
    PlaceService placeService;

    @RequestMapping("/getPlace")
    public String getPlace(@RequestParam("y")int y, @RequestParam("x")int x, Model model) throws JsonProcessingException {

        System.out.println(y+" "+x);

        if(x==0 && y==0){
            for(int i=0;i<=15;i++){
                for(int j=0;j<=15;j++){
                    map[i][j]=0;
                }
            }
            return "{}";
        }
        //此处调用service层，返回最优落子点
        Place place=placeService.getPlace(x,y,map);
        map[place.getY()][place.getX()]=1;

//        for(int i=1;i<=15;i++){
//            for(int j=1;j<=15;j++){
//                System.out.print(map[i][j]+" ");
//            }
//            System.out.println();
//        }

        return JsonUtil.getJson(place);
    }
}
