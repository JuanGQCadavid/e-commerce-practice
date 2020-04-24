package com.ecommercepractice.authentication.repository;
import com.ecommercepractice.authentication.model.MobileInfoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobileInfoRepository extends CrudRepository<MobileInfoModel,Integer> {

}