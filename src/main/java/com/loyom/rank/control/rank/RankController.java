package com.loyom.rank.control.rank;

import com.loyom.rank.control.AbsControl;
import com.loyom.rank.data.request.Rank;
import com.loyom.rank.server.service.RankSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/rank")
public class RankController extends AbsControl {

    @Autowired
    private RankSerivce rankSerivce;

    @RequestMapping(value = "/{AppID}/insert", method = {RequestMethod.POST})
    @ResponseBody
    public String insertRank(@PathVariable String AppID, Rank rank) throws Exception {
        System.out.println("================================================");
        System.out.println(AppID);
        System.out.println(rank.toString());
        rankSerivce.create(rank);
        return "OK";
    }
}
