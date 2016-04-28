package com.woaigsc.service;

import com.woaigsc.entity.Poem;

import java.util.List;

/**
 * Created by chuiyuan on 16-4-25.
 */
public interface IPoemService {
    public List<Poem> selectAll();

    public Poem selectById(int id );
}
