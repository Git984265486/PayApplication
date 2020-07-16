package com.example.Controller;

import com.example.Damain.Tcharge;
import com.example.Service.TchargeService;
import com.example.Utils.PayUtils;
import com.example.Utils.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
public class TchargeController {

    @Autowired
    private TchargeService chargeService;

    @RequestMapping("/ListCharge")
    @ResponseBody
    public Map<String , Object> ListCharge(@RequestParam(value = "page",defaultValue = "1") int page,
                                           @RequestParam(value = "limit",defaultValue = "10")int size){
        System.out.println("【分页信息：】" + page + "\t\t\tlimit:" + size);
        Map<String , Object> map = new HashMap<>();
        PageHelper.startPage(page , size);
        List<Tcharge> listCharge = chargeService.ListCharge();
        PageInfo<Tcharge> listData = new PageInfo<>(listCharge);
        map.put("count",listData.getTotal());
        map.put("listCharge" , listData.getList());
        return map;
    }

    /**【列出、条件查询 收费信息】**/
    @RequestMapping("/searchOrder")
    @ResponseBody
    public Map<String , Object> searchOrder(@RequestParam(value = "carNo",defaultValue = "" ) String carNo,
                                            @RequestParam(value = "page" ,defaultValue = "1") int page,
                                            @RequestParam(value = "limit",defaultValue = "10") int size){
        System.out.println("【分页信息】\tpage:\t" + page + "\t\tlimit:\t" + size);
        Map<String , Object> map = new HashMap<>();
        PageHelper.startPage(page , size);
        //List<Tcharge> filterData = chargeService.FilterData(carNo);   PageInfo<Tcharge> listData = new PageInfo<>(filterData);
        PageInfo<Tcharge> listData = new PageInfo<>(chargeService.FilterData(carNo));
        map.put("count",listData.getTotal());
        map.put("listCharge",listData.getList());
        map.put("result" , "success");
        return map;
    }

    /**【收费信息更新】**/
    @RequestMapping("/editChargeData")
    @ResponseBody
    public Map<String , Object>editChargeData(@RequestParam(value="editVal",defaultValue="") String editVal){
        Map<String , Object> map = new HashMap<>();
        System.out.println("【更新收费信息传递过来的表单数据】" + editVal);
        Tcharge chargeInfo = PayUtils.editChargeData(editVal);
        chargeService.updateChargeData(chargeInfo);
        map.put("result" , "Success");
        return map;
    }

}
