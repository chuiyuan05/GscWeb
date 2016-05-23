package com.woaigsc.dao.impl;

import com.woaigsc.dao.PoemDao;
import com.woaigsc.db.DBHelper;
import com.woaigsc.entity.Poem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by chuiyuan on 16-4-25.
 */
public class PoemDaoImpl implements PoemDao{
    @Override
    public void add(Poem poem) throws SQLException {

    }

    @Override
    public void update(Poem poem) throws SQLException {

    }

    @Override
    public void delete(Poem poem) throws SQLException {

    }

    @Override
    public Poem selectById(int id) throws SQLException {
        Connection conn = null ;
        PreparedStatement ps = null ;
        ResultSet rs = null;
        Poem poem  = null ;

        String sql = "select id,dynasty,category,title,author,content,"+
                "href from poemtable where id=?" ;
        try{
            conn = DBHelper.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery() ;
            if(rs.next()){
                poem = new Poem();
                poem.setId(rs.getInt(1));
                poem.setDynasty(rs.getString(2));
                poem.setCategory(rs.getString(3));
                poem.setTitle(rs.getString(4));
                poem.setAuthor(rs.getString(5));
                poem.setContent(rs.getString(6));
                poem.setHref(rs.getString(7));
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw new SQLException("select by id failed");
        }finally {
            DBHelper.close(rs,ps,conn);
        }
        return poem ;
    }

    @Override
    public List<Poem> selectAll() throws SQLException {
        return null;
    }
}
