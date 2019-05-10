package com.dx.action;

import com.dx.dao.Excute;

import java.sql.SQLException;

/**
 * @Author: duanxu
 * @Date: 2019/5/9 22:53
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        Excute excute = new Excute();
        excute.queryAll();
        //excute.add();
        //excute.queryAll();
        //excute.deleteByName();
    }
}
