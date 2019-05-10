package com.dx.dao;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @Author: duanxu
 * @Date: 2019/5/10 9:39
 */
public class GetNow {
    public Timestamp timeNow(){
        Date utilDate = new Date();
        System.out.println(new Timestamp(utilDate.getTime()));
        return new Timestamp(utilDate.getTime());
    }
}
