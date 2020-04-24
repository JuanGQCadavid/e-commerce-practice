package com.ecommercepractice.authentication.service;

import com.ecommercepractice.authentication.model.MobileInfoModel;
import com.ecommercepractice.authentication.repository.MobileInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MobileService {
    @Autowired
    MobileInfoRepository mobileInfoRepository;

    /**
     * Store mobile info onto repository
     * @param mobileInfo
     * @return
     */
    public MobileInfoModel register(MobileInfoModel mobileInfo){
        return mobileInfoRepository.save(mobileInfo);
    }
}
