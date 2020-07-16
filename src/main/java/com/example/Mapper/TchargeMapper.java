package com.example.Mapper;

import com.example.Damain.Tcharge;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TchargeMapper {

    public List<Tcharge> ListCharge();

    public Tcharge selectDataByOrderNumber(String orderNumber);

    public List<Tcharge> FilterData(@Param("carNo") String carNo);

    public void insertChargeData(String orderNumber ,String ownerName ,String ownerPhone ,String totalAmount ,String payType ,String payStatus,
                                 String carNo ,String carType ,String registrTime ,String operater , String operatTime , String remark);

    public void updateChargeData(String ownerName , String ownerPhone , String payType , String carNo , String carType , String operater ,
                                 String operatTime ,String payStatus,String remark ,String totalAmount ,String registrTime ,String orderNumber);

}
