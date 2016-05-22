package com.woaigsc.controller;

import com.woaigsc.dao.PoemDao;
import com.woaigsc.dao.impl.PoemDaoImpl;
import com.woaigsc.entity.Poem;
import com.woaigsc.utils.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by chuiyuan on 16-4-25.
 */
@Controller
public class PoemController {

    @RequestMapping(value = "/poem/{id}",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String selectById(@PathVariable("id")int id){
        PoemDao poemDao = new PoemDaoImpl();
        Poem poem = null;
        try {
            poem = poemDao.selectById(id);
        }catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println(JsonUtil.toJson(poem));
        return JsonUtil.toJson(poem) ;
    }

    @RequestMapping("/poem1/{id}")
    public void testSelectById(@PathVariable("id") int id, HttpServletResponse resp){
        PoemDao poemDao = new PoemDaoImpl();
        Poem poem = null;
        try {
            poem = poemDao.selectById(id);
        }catch (SQLException e){
            e.printStackTrace();
        }
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        try {
            PrintWriter writer = resp.getWriter() ;
            writer.print(JsonUtil.toJson(poem));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
