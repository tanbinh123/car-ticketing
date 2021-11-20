package com.chz.service.impl;

import com.chz.Result.Result;
import com.chz.dao.TripsDao;
import com.chz.pojo.Trips;
import com.chz.service.TripsService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author snicker
 * @date 2021/11/12 10:36
 * @Describe
 */
@Service
public class TripsServiceImpl implements TripsService {

    @Autowired
    TripsDao tripsDao;

    @Override
    public Page<Trips> getAllTripsForAdmin() {
        return tripsDao.getAllTripsForAdmin();
    }

    @Override
    public int saveTrip(Trips trips) {
        return tripsDao.saveTrip(trips);
    }

    @Override
    public int updateTripForAdmin(Trips trips) {
        return tripsDao.updateTripForAdmin(trips);
    }

    @Override
    public int delTrip(Integer id) {
        return tripsDao.deleteTrip(id);
    }

    @Override
    public Result getAlltrips(Trips trips) {
        Result result = new Result();
        List<Trips> tripsdata = tripsDao.getAlltrips(trips);
        if(tripsdata != null){
            result.setMsg("Query all succeed");
            result.setData(tripsdata);
            result.setStateCode(200);
        }
        else{
            result.setMsg("Query failes,no tickets");
            result.setStateCode(404);
        }
        return result;
    }

    /*@Override
    public Result getAimtrips(Trips trips) {
        Result result = new Result();
        Trips tripsdata = tripsDao.getAimtrips(trips);
        if(tripsdata != null){
            result.setMsg("Query all succeed");
            result.setData(trips);
            result.setStateCode(200);
        }
        else{
            result.setMsg("Query failes,no tickets");
            result.setStateCode(404);
        }
        return result;
    }*/

    @Override
    public int decreaseTicketNum(Integer id) {
        return tripsDao.decreaseTicketNum(id);
    }

    @Override
    public int increaseTicketNum(Integer id) {
        return tripsDao.increaseTicketNum(id);
    }
}





























