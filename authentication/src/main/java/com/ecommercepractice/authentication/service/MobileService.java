package com.ecommercepractice.authentication.service;

import com.ecommercepractice.authentication.dao.MobileDao;
import com.ecommercepractice.authentication.model.MobileInfoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MobileService {
    @Autowired
    MobileDao mobileDao;

    public MobileInfoModel register(MobileInfoModel mobileInfo){
        return mobileDao.save(mobileInfo)
                .get();
    }
}
