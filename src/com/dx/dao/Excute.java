package com.dx.dao;

import com.dx.model.BeautyInfoEntity;
import com.dx.util.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 对数据库的增删查改操作
 * @Author: duanxu
 * @Date: 2019/5/9 22:22
 */
public class Excute {

    private JdbcUtil jdbcUtil ;
    private Statement statement ;
    /**
     *    增
     */
    public void add()throws SQLException{
        jdbcUtil =new JdbcUtil();
        BeautyInfoEntity beautyInfoEntity = new BeautyInfoEntity();
        Scanner in = new Scanner(System.in);
        GetNow getNow = new GetNow();
        Timestamp now=getNow.timeNow();

        String sql = "insert into beauty_info "+
                "(name, telphone, email, create_Time)"+
                "values "+
                "(?,?,?,current_timestamp );";

        System.out.println("输入用户信息：");
        System.out.println("姓名：");
        beautyInfoEntity.setName(in.next());
        System.out.println("邮箱：");
        beautyInfoEntity.setEmail(in.next());
        System.out.println("电话：");
        beautyInfoEntity.setTelphone(in.next());

        PreparedStatement prepareStatement = jdbcUtil.getConnection().prepareStatement(sql);
        prepareStatement.setString(1,beautyInfoEntity.getName());
        prepareStatement.setString(2,beautyInfoEntity.getTelphone());
        prepareStatement.setString(3,beautyInfoEntity.getEmail());
        prepareStatement.execute();
    }
    /**
     *    删
     */
    public void deleteByName() throws SQLException {
        System.out.println("请输入要删除的姓名：");
        Scanner in = new Scanner(System.in);
        String name=in.next();
       Connection connection=jdbcUtil.getConnection();
       String sql="delete from beauty_info where name = ?";
       PreparedStatement preparedStatement =connection.prepareStatement(sql);
        preparedStatement.setString(1,name);
        preparedStatement.execute();
    }
    /**
     *    改
     */
    public void update(){

    }
    /**
     *    查
     *  查询所有数据并返回到集合Arraylist
     */
    public void queryAll() throws SQLException {
        jdbcUtil =new JdbcUtil();
        statement =jdbcUtil.getConnection().createStatement();
        ArrayList<BeautyInfoEntity>  beautyInfoEntityArrayList = new ArrayList<>();
        String sql="select * from beauty_info";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                BeautyInfoEntity beautyInfoEntity = new BeautyInfoEntity();

                beautyInfoEntity.setId(resultSet.getInt("id"));
                beautyInfoEntity.setName(resultSet.getString("name"));
                beautyInfoEntity.setEmail(resultSet.getString("email"));
                beautyInfoEntity.setCreateTime(resultSet.getTimestamp("create_Time"));
                beautyInfoEntity.setUpdateTime(resultSet.getTimestamp("update_Time"));

                beautyInfoEntityArrayList.add(beautyInfoEntity);
            }
            for (BeautyInfoEntity beautyInfoEntity:beautyInfoEntityArrayList){
                System.out.println(beautyInfoEntity.toString());
            }
        statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
