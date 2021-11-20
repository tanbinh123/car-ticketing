package com.chz.controller;

import com.chz.Result.Result;
import com.chz.pojo.Trips;
import com.chz.service.TripsService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author snicker
 * @date 2021/11/12 10:39
 * @Describe
 */
@RestController
@CrossOrigin
public class TripsController {

    @Resource
    private TripsService tripsService;

    /**
     * 管理员得到分页用户
     * @param pn
     * @return
     */
    @GetMapping("/getalltripsforadmin")
    public Map<String,Object> getAllTripsForAdmin(@RequestParam(defaultValue="1",required=true,value="pn") Integer pn){

        Integer pageSize=5;
        PageHelper.startPage(pn,pageSize);
        List<Trips> allTrip = tripsService.getAllTripsForAdmin();
        PageInfo<Trips> pageInfo = new PageInfo(allTrip);
        Map<String, Object> modelMap = new HashMap<>();
        if (pageInfo != null){
            modelMap.put("code", 200);
            modelMap.put("data", pageInfo);
        }else {
            modelMap.put("code", 200);
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("message", "获取model列表失败");
            dataMap.put("entity", null);
            modelMap.put("data", dataMap);
        }
        return modelMap;
    }

    /**
     * 管理员后台添加车次
     * @param trips
     * @return
     */
    @Transactional
    @RequestMapping(value = "/saveTrip",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> saveUser(@RequestBody Trips trips){
        int i = tripsService.saveTrip(trips);
        Map<String, Object> modelMap = new HashMap<>();
        if (i == 1){
            modelMap.put("code", 200);
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("message", "success");
            dataMap.put("entity", null);
            modelMap.put("data", dataMap);
        }else {
            modelMap.put("code", 200);
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("message", "添加车次失败");
            dataMap.put("entity", null);
            modelMap.put("data", dataMap);
        }
        return modelMap;
    }

    /**
     * 编辑车次信息
     * @param trips
     * @return
     */
    @RequestMapping(value = "/updateTripForAdmin",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateTripForAdmin(@RequestBody Trips trips){
        int i = tripsService.updateTripForAdmin(trips);
        Map<String, Object> modelMap = new HashMap<>();
        if (i == 1){
            modelMap.put("code", 200);
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("message", "success");
            dataMap.put("entity", null);
            modelMap.put("data", dataMap);
        }else {
            modelMap.put("code", 200);
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("message", "更新车次信息失败");
            dataMap.put("entity", null);
            modelMap.put("data", dataMap);
        }
        return modelMap;
    }

    /**
     * 后台根据id删除车次
     * @param id
     * @return
     */
    @Transactional
    @RequestMapping(value = "/deleteTrip/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> deleteTrip(@PathVariable("id")Integer id){
        Map<String, Object> modelMap = new HashMap<>();

        try {
            int i = tripsService.delTrip(id);
            if (i == 1){
                modelMap.put("code", 200);
                Map<String, Object> dataMap = new HashMap<>();
                dataMap.put("message", "success");
                dataMap.put("entity", null);
                modelMap.put("data", dataMap);
            }else {
                modelMap.put("code", 200);
                Map<String, Object> dataMap = new HashMap<>();
                dataMap.put("message", "删除失败");
                dataMap.put("entity", null);
                modelMap.put("data", dataMap);
            }
        }catch (Exception e){
            modelMap.put("code", 500);
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("message", "删除失败");
            dataMap.put("entity", null);
            modelMap.put("data", dataMap);
        }
        return modelMap;
    }

    @PostMapping("/getalltrips")
    @ResponseBody
    public Result getAlltrips(@RequestBody Trips trips){
        Result result = tripsService.getAlltrips(trips);
        return result;
    }


}































