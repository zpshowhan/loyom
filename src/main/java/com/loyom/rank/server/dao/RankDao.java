package com.loyom.rank.server.dao;

import com.loyom.rank.data.entity.RankPO;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RankDao extends PagingAndSortingRepository<RankPO, Long> {

}
