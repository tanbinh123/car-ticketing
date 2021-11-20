package com.chz.controller;

import com.alibaba.fastjson.JSONObject;
import com.chz.Result.Result;
import com.chz.pojo.User;
import com.chz.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author snicker
 * @date 2021/11/10 18:08
 * @Describe
 */
@RestController
@CrossOrigin
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 得到分页所有用户
     * @param pn
     * @return
     */
    @GetMapping("/getallusers")
    public Map<String,Object> getAllUsers(@RequestParam(defaultValue="1",required=true,value="pn") Integer pn){
        //每页显示记录数
        Integer pageSize=5;
        //分页查询，注意顺序，startPage()方法放前面
        PageHelper.startPage(pn,pageSize);
        //获取所用用户信息
        List<User> allUser = userService.getAllUsers();
        //使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。封装了详细的分页信息,传入连续显示的页数
        PageInfo<User> pageInfo=new PageInfo(allUser);

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
     * 管理员后台添加用户
     * @param user
     * @return
     */
    @Transactional
    @RequestMapping(value = "/saveUser",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> saveUser(@RequestBody User user){
        int i=userService.saveUser(user);
        Map<String, Object> modelMap = new HashMap<>();
        if(i==1){
            modelMap.put("code",200);
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("message","success");
            dataMap.put("entity",null);
            modelMap.put("data",dataMap);
        }else {
            modelMap.put("code", 200);
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("message", "添加用户失败");
            dataMap.put("entity", null);
            modelMap.put("data", dataMap);
        }
        return modelMap;
    }

    /**
     * 管理员添加用户名不能有重复
     * @param username
     * @return
     */
    @RequestMapping(value = "/checkUser/{username}",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> checkUserName(@PathVariable("username") String username){
        User user=userService.checkUserName(username);
        Map<String, Object> modelMap=new HashMap<>();
        if(user!=null){
            modelMap.put("code", 200);
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("message", "用户名已存在");
            dataMap.put("entity", null);
            modelMap.put("data", dataMap);
        }else {
            modelMap.put("code", 200);
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("message", "success");
            dataMap.put("entity", null);
            modelMap.put("data", dataMap);
        }
        return modelMap;
    }

    /**
     * 编辑用户信息
     * @param user
     * @return
     */
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateUser(@RequestBody User user){
        boolean i = userService.updateUser(user);
        Map<String, Object> modelMap = new HashMap<>();
        if (i){
            modelMap.put("code", 200);
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("message", "success");
            dataMap.put("entity", null);
            modelMap.put("data", dataMap);
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
     * 根据用户名删除用户
     * @param username
     * @return
     */
    @Transactional
    @RequestMapping(value = "/deleteUser/{username}",method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> deleteUser(@PathVariable("username") String username){
        Map<String, Object> modelMap = new HashMap<>();

        //保存用户
        try {
            int i = userService.deleteUser(username);
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

    /**
     * 通过用户名查询个人信息
     * @param jsonObject
     * @return
     */
    @PostMapping("/getpersoninfo")
    public Result getPersonInfo(@RequestBody JSONObject jsonObject){
        System.out.println(jsonObject.getString("username"));
        return userService.getPersonInfoByUsername(jsonObject.getString("username"));
    }

    /**
     * 用户自己完善个人信息
     * @param jsonObject
     * @return
     */
    @PostMapping("/updateUserInfo")
    public Result updateUserInfo(@RequestBody JSONObject jsonObject){
        Result result = null;
        String username = jsonObject.getString("username");
        String trueName = jsonObject.getString("trueName");
        String idCardNum = jsonObject.getString("idCardNum");
        String phoneNum = jsonObject.getString("phoneNum");
        Integer age = jsonObject.getInteger("age");
        String sex=jsonObject.getString("sex");
        result = userService.updateUserInfo(username,trueName, idCardNum, phoneNum, age, sex);
        return result;
    }


}

































