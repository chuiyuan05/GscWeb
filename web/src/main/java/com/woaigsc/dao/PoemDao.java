package com.woaigsc.dao;

import com.woaigsc.entity.Poem;
import org.apache.ibatis.jdbc.SQL;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by chuiyuan on 16-4-25.
 */
public interface PoemDao {
    public void add(Poem poem) throws SQLException ;

    public void update(Poem poem) throws SQLException ;

    public void delete(Poem poem) throws SQLException ;

    public Poem selectById(int id) throws SQLException ;

    public List<Poem> selectAll() throws SQLException ;
}
