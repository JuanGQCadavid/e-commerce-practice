package com.ecommercepractice.authentication.dao;

import com.ecommercepractice.authentication.model.MobileInfoModel;
import com.ecommercepractice.authentication.repository.MobileInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MobileDao {
    @Autowired
    MobileInfoRepository mobileInfoRepository;

    /**
     * Save on the platform the mobile information
     * it's used when Ath proceeds to login.
     * @param mobileInfo
     * @return
     */
    public Optional<MobileInfoModel> save(MobileInfoModel mobileInfo){
        return Optional.ofNullable(mobileInfoRepository.save(mobileInfo));
    }
}
