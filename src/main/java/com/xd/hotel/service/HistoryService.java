package com.xd.hotel.service;

import com.xd.hotel.model.History;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by jiaqi on 2019/6/13 9:41 PM
 */
public interface HistoryService {
    List<History> findAll();

    List<History> findAll(Pageable pageable);

    void add(History history);

    List<History> findByIdentityNumber(String identityNumber);

}
