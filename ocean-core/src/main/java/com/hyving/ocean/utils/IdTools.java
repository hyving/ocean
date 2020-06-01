package com.hyving.ocean.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author: Hyving 黄瀚
 * @date: 2019/7/8
 * han.huang@sioeye.com
 */
public class IdTools {

    public static String getUUID(){

        String uuid =UUID.randomUUID().toString().replace("-", "").toLowerCase();
//        System.out.println(uuid);
        return uuid;

    }


    public static List<String> getUUIDList(int number){

        List<String> uuidList =new ArrayList<>();

        if(number<1){
            return null;

        }else{
            for(int i=0;i<number;i++){
                uuidList.add(getUUID());

            }
        }

        return uuidList;
    }


    public static void  main(String[] args) {

        getUUIDList(154);

    }

}
