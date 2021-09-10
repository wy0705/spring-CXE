package com.lmonkey.service;

import com.lmonkey.dao.Basedao;
import com.lmonkey.entity.InFormation_USER;
import com.lmonkey.entity.LMONKEY_USER;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InFormation_USERDao {
    /*
    * 加入数据库
    * */

    public static int insert(InFormation_USER u) {
        String sql = "insert into CustomerInformation values(?, ?, ?,DATE_FORMAT(?, '%Y-%m-%d'), ?, ?, ?, ?, ?)";

        Object[] params = {
                u.getId(),
                u.getName(),
                u.getPhone(),
                u.getBirthday(),
                u.getSex(),
                u.getSalary(),
                u.getAddress(),
                u.getEmail(),
                u.getPermanentAddress()};


        return Basedao.exectuIUD(sql, params);

    }
    public static int selectEmail(String email) {
        int count = 0;
        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;



        try {
            //查询用户的email
            String sql = "select count(*) from CustomerInformation where email=?";
            //执行sql语句
            ps = conn.prepareStatement(sql);
            /*
            第一个参数是该参数在语句中的索引。参数标记具有从 1 开始的编号。 通常指的是第一个“？”
            第二个参数是要对第一个参数设置的值。
            * */
            ps.setString(1, email);
            rs = ps.executeQuery();

            while(rs.next()) {
                count = rs.getInt(1);
            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            Basedao.closeall(rs, ps, conn);
        }



        return count;
    }
    public static int selectname(String id) {
        int count = 0;
        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            //查询用户的id
            String sql = "select count(*) from CustomerInformation where id=?";
            //执行sql语句
            ps = conn.prepareStatement(sql);
            /*
            第一个参数是该参数在语句中的索引。参数标记具有从 1 开始的编号。 通常指的是第一个“？”
            第二个参数是要对第一个参数设置的值。
            * */
            ps.setString(1, id);
            rs = ps.executeQuery();

            while(rs.next()) {
                count = rs.getInt(1);
            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            Basedao.closeall(rs, ps, conn);
        }



        return count;
    }
    /**
     * 删除一个用户
     */
    public static int del(String id) {

        String sql = "delete from lmonkey_user where USER_ID=? and USER_STATUS!=2";

        Object[] params = {id};

        return Basedao.exectuIUD(sql, params);
    }


    public static int update(LMONKEY_USER u) {
        String sql = "update lmonkey_user set USER_NAME=?, USER_PASSWORD=?,USER_SEX=?,USER_BIRTHDAY=DATE_FORMAT(?, '%y-%m-%d'),USER_IDENITY_CODE=?,USER_EMAIL=?,USER_MOBILE=?,USER_ADDRESS=?,USER_STATUS=? where USER_ID = ?";

        Object[] params = {
                u.getUSER_NAME(),
                u.getUSER_PASSWORD(),
                u.getUSER_SEX(),
                u.getUSER_BIRTHDAY(),
                u.getUSER_IDENITY_CODE(),
                u.getUSER_EMAIL(),
                u.getUSER_MOBILE(),
                u.getUSER_ADDRESS(),
                u.getUSER_STATUS(),
                u.getUSER_ID()};

        return Basedao.exectuIUD(sql, params);
    }

    public static int selectByName(String id) {
        int count = 0;
        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;



        try {
            //查询用户的id
            String sql = "select count(*) from lmonkey_user where USER_ID=?";
            //执行sql语句
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();

            while(rs.next()) {
                count = rs.getInt(1);
            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            Basedao.closeall(rs, ps, conn);
        }



        return count;
    }


    /**
     * 获取总记录数和总页数
     */

    public static int[] totalPage(int count, String keyword) {
        // 0 总记录数， 1， 页数
        int arr[] = {0, 1};

        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;



        try {
            String sql = "";

            if(keyword!=null) {
                sql = "select count(*) from lmonkey_user where USER_NAME like ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, "%"+keyword+"%");
            }else{
                sql = "select count(*) from LMONKEY_USER";

                ps = conn.prepareStatement(sql);

            }





            rs = ps.executeQuery();

            while(rs.next()) {
                arr[0]= rs.getInt(1);

                if(arr[0]%count==0){
                    arr[1] = arr[0]/count;
                }else{
                    arr[1] = arr[0]/count+1;
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            Basedao.closeall(rs, ps, conn);
        }



        return arr;
    }


    public static ArrayList<LMONKEY_USER> selectAll(int cpage, int count, String keyword) {
        ArrayList<LMONKEY_USER> list = new ArrayList<LMONKEY_USER>();
        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn = Basedao.getconn();

        PreparedStatement ps = null;



        try {
            String sql = "";

            if(keyword!=null) {
                sql = "select * from lmonkey_user where USER_NAME like ? order by USER_BIRTHDAY desc limit ?, ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, "%"+keyword+"%");
                ps.setInt(2, (cpage-1)*count);
                ps.setInt(3, count);
            }else{

                sql = "select * from lmonkey_user order by USER_BIRTHDAY desc limit ?, ?";
                ps = conn.prepareStatement(sql);

                ps.setInt(1, (cpage-1)*count);
                ps.setInt(2, count);
            }


            rs = ps.executeQuery();

            while(rs.next()) {
                LMONKEY_USER u = new LMONKEY_USER(
                        rs.getString("USER_ID"),
                        rs.getString("USER_NAME"),
                        rs.getString("USER_PASSWORD"),
                        rs.getString("USER_SEX"),
                        rs.getString("USER_BIRTHDAY"),
                        rs.getString("USER_IDENITY_CODE"),
                        rs.getString("USER_EMAIL"),
                        rs.getString("USER_MOBILE"),
                        rs.getString("USER_ADDRESS"),
                        rs.getInt("USER_STATUS")

                );


                list.add(u);

            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            Basedao.closeall(rs, ps, conn);
        }



        return list;
    }

    /**
     * 通过ID查找用户
     */
    public static LMONKEY_USER selectByID(String id) {

        LMONKEY_USER u = null;

        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn = Basedao.getconn();

        PreparedStatement ps = null;



        try {
            String sql = "select m.*, DATE_FORMAT(m.user_birthday, '%Y-%m-%d')birthday  from lmonkey_user m where USER_ID=?";

            ps = conn.prepareStatement(sql);
            ps.setString(1, id);


            rs = ps.executeQuery();

            while(rs.next()) {
                u = new LMONKEY_USER(
                        rs.getString("USER_ID"),
                        rs.getString("USER_NAME"),
                        rs.getString("USER_PASSWORD"),
                        rs.getString("USER_SEX"),
                        rs.getString("birthday"),
                        rs.getString("USER_IDENITY_CODE"),
                        rs.getString("USER_EMAIL"),
                        rs.getString("USER_MOBILE"),
                        rs.getString("USER_ADDRESS"),
                        rs.getInt("USER_STATUS")

                );




            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            Basedao.closeall(rs, ps, conn);
        }



        return u;
    }

    public static int selectByNM(String name, String pwd){
        int count =0;

        Connection conn = Basedao.getconn();
        PreparedStatement ps = null;
        ResultSet rs = null;



        try {
            String sql = "select count(*) from lmonkey_user where USER_ID=? and USER_PASSWORD=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, pwd);
            rs = ps.executeQuery();

            while(rs.next()) {
                count = rs.getInt(1);
            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            Basedao.closeall(rs, ps, conn);
        }


        return count;

    }
    /**
     * 通过用户名和密码查询用户信息
     */

    public static LMONKEY_USER selectAdmin(String name, String pwd) {
        LMONKEY_USER u = null;

        //声明结果集
        ResultSet rs = null;
        //获取连接对象
        Connection conn = Basedao.getconn();

        PreparedStatement ps = null;



        try {
            String sql = "select m.*, DATE_FORMAT(m.user_birthday, '%Y-%m-%d')birthday  from lmonkey_user m where USER_ID=? and USER_PASSWORD=?";

            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, pwd);

            rs = ps.executeQuery();

            while(rs.next()) {
                u = new LMONKEY_USER(
                        rs.getString("USER_ID"),
                        rs.getString("USER_NAME"),
                        rs.getString("USER_PASSWORD"),
                        rs.getString("USER_SEX"),
                        rs.getString("birthday"),
                        rs.getString("USER_IDENITY_CODE"),
                        rs.getString("USER_EMAIL"),
                        rs.getString("USER_MOBILE"),
                        rs.getString("USER_ADDRESS"),
                        rs.getInt("USER_STATUS")

                );




            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            Basedao.closeall(rs, ps, conn);
        }



        return u;


    }

}
