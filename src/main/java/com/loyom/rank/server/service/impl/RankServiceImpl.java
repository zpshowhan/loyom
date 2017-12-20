package com.loyom.rank.server.service.impl;

import com.loyom.rank.data.assist.RankAssist;
import com.loyom.rank.data.request.Rank;
import com.loyom.rank.server.dao.RankDao;
import com.loyom.rank.server.service.RankSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RankServiceImpl implements RankSerivce {

    @Autowired
    private RankDao rankDao;
    @Autowired
    private RankAssist rankAssist;

    @Override
    public void create(Rank rank) {
        if (this.check(rank)) {
            rankDao.save(rankAssist.convert(rank));
        }
    }

    private boolean check(Rank rank) {
        return true;
    }
}
