package com.smart.service;

import com.smart.dao.InfoDao;
import com.smart.domain.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoService {
    private InfoDao infoDao;

    @Autowired
    public void setInfoDao(InfoDao infoDao) {
        this.infoDao = infoDao;
    }

    public Info getInfo(){
        return infoDao.getInfo();
    }
}
