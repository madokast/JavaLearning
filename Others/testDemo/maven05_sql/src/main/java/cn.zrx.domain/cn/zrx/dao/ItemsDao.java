package cn.zrx.domain.cn.zrx.dao;

import cn.zrx.domain.Items;

import java.util.List;

public interface ItemsDao {
    public List<Items> findAll() throws Exception;
}
