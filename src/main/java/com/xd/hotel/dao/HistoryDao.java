package com.xd.hotel.dao;

import com.xd.hotel.modol.History;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by jiaqi on 2019/6/13 10:47 PM
 */
public interface HistoryDao extends JpaRepository<History, Integer> {
    List<History> findByIdentityNumber(String identityNumber);
}
