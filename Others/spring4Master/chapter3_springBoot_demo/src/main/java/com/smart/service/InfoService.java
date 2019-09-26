package com.smart.service;

import com.smart.dao.InfoDao;
import com.smart.domain.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InfoService {
    private InfoDao infoDao;

    @Autowired
    public void setInfoDao(InfoDao infoDao) {
        this.infoDao = infoDao;
    }

    @Transactional
    public Info getInfo(){
        return infoDao.getInfo();
    }
}
