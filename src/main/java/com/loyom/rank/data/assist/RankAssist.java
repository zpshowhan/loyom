package com.loyom.rank.data.assist;

import com.loyom.rank.data.entity.RankPO;
import com.loyom.rank.data.request.Rank;
import org.springframework.stereotype.Component;

@Component
public class RankAssist {

    public RankPO convert(Rank r) {
        RankPO o = new RankPO();
        o.setUid(r.getUid());
        o.setNick(r.getNick());
        o.setPoint(r.getPoint());
        o.setBelong(r.getBelong());
        o.setCategory(r.getCategory());
        o.setArea(r.getArea());
        return o;
    }
}
