package com.xd.hotel.service.impl;

import com.xd.hotel.dao.HistoryDao;
import com.xd.hotel.model.History;
import com.xd.hotel.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jiaqi on 2019/6/14 12:01 AM
 */

@Service
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    private HistoryDao historyDao;

    @Override
    public List<History> findAll() {
        return historyDao.findAll();
    }

    @Override
    public List<History> findAll(Pageable pageable) {
        return historyDao.findAll(pageable).getContent();
    }

    @Override
    public void add(History history) {
        historyDao.save(history);
    }

    @Override
    public List<History> findByIdentityNumber(String identityNumber) {
        return historyDao.findByIdentityNumber(identityNumber);
    }
}
