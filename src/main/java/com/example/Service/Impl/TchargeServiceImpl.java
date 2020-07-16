package com.example.Service.Impl;

import com.example.Damain.Tcharge;
import com.example.Mapper.TchargeMapper;
import com.example.Service.TchargeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TchargeServiceImpl implements TchargeService {

    @Autowired
    private TchargeMapper chargeMapper;


    @Override
    public List<Tcharge> ListCharge() {
        return chargeMapper.ListCharge();
    }

    @Override
    public Tcharge selectDataByOrderNumber(String orderNumber) {
        return chargeMapper.selectDataByOrderNumber(orderNumber);
    }

    @Override
    public List<Tcharge> FilterData(@Param("carNo") String carNo) {
        return chargeMapper.FilterData(carNo);
    }

    @Override
    public void insertChargeData(Tcharge chargeInfo) {
        chargeMapper.insertChargeData(chargeInfo.getOrderNumber(),chargeInfo.getOwnerName(),chargeInfo.getOwnerPhone(),
                chargeInfo.getTotalAmount(),chargeInfo.getPayType(),chargeInfo.getPayStatus(),chargeInfo.getCarNo(),chargeInfo.getCarType(),
                chargeInfo.getRegistrTime(),chargeInfo.getOperater(),chargeInfo.getOperatTime(),chargeInfo.getRemark());
    }

    @Override
    public void updateChargeData(Tcharge chargeInfo) {
        chargeMapper.updateChargeData(chargeInfo.getOwnerName(),chargeInfo.getOwnerPhone(),chargeInfo.getPayType(),chargeInfo.getCarNo(),
                chargeInfo.getCarType(), chargeInfo.getOperater(),chargeInfo.getOperatTime(),chargeInfo.getPayStatus(),chargeInfo.getRemark(),
                chargeInfo.getTotalAmount(),chargeInfo.getRegistrTime(),chargeInfo.getOrderNumber());
    }
}
