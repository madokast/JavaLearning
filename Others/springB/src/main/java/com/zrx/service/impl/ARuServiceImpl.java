package com.zrx.service.impl;

import com.zrx.service.IARuService;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.MediaSize;

@Service("aRuService")
public class ARuServiceImpl implements IARuService {
    public int methodNeedEnhance() {
        System.out.println("需要增强的方法");
        return 1;
    }

    public void methodNotNeedEnhance() {
        System.out.println("不需要增强的方法");
    }

    public void methodNeedAroundEnhance() {
        System.out.println("需要环绕增强的方法");
    }
}
