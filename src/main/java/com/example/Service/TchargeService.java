package com.example.Service;

import com.example.Damain.Tcharge;

import java.util.List;

public interface TchargeService {

    public List<Tcharge> ListCharge();

    public Tcharge selectDataByOrderNumber(String orderNumber);

    public List<Tcharge> FilterData(String carNo);

    public void insertChargeData(Tcharge chargeInfo);

    public void updateChargeData(Tcharge chargeInfo);

}
