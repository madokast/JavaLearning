package day190909.service;

import java.util.List;
import day190909.doamin.Province;

public interface ProvinceService {
    public List<Province> findAll();

    public String findAllJson();
}
