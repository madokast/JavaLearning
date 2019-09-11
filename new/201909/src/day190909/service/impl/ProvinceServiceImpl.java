package day190909.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import day190909.dao.ProvinceDao;
import day190909.dao.impl.ProvinceDaoImpl;
import day190909.doamin.Province;
import day190909.service.ProvinceService;
import redis.clients.jedis.Jedis;
import util.JedisPoolUtils;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {
    private ProvinceDao provinceDao = new ProvinceDaoImpl();

    @Override
    public List<Province> findAll() {
        return provinceDao.findAll();
    }

    //使用缓存
    @Override
    public String findAllJson() {
        //先从redis查询

        Jedis jedis = JedisPoolUtils.getJedis();
        String province_json = jedis.get("province");

        if(province_json==null||province_json.length()==0){
            System.out.println("sql");

            final List<Province> all = provinceDao.findAll();

            ObjectMapper mapper = new ObjectMapper();

            try {
                province_json = mapper.writeValueAsString(all);

                jedis.set("province",province_json);

                jedis.close();
            }catch (Exception e){e.printStackTrace();}



        }else {
            System.out.println("redis");
        }


        return province_json;

    }
}
