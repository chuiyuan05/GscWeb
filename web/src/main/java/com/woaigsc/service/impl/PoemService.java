package com.woaigsc.service.impl;

import com.woaigsc.entity.Poem;
import com.woaigsc.service.IPoemService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chuiyuan on 16-4-25.
 */
@Service("poemService")
public class PoemService implements IPoemService {

    @Override
    public List<Poem> selectAll() {
        return null;
    }

    @Override
    public Poem selectById(int id) {
        return null;
    }
}
