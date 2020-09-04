package com.tools.common.util;

import com.alibaba.fastjson.JSONObject;
import com.tools.common.constant.SystemConstant;
import com.tools.common.model.Result;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author 爪哇笔记
 * @Date 2022/9/4
 * 参考：http://lbsyun.baidu.com/index.php?title=webapi/guide/webservice-geocoding
 */
public class BaiDuMapUtils {

    static Logger logger = LoggerFactory.getLogger(BaiDuMapUtils.class);

    static String AK = "888";

    static String SN ="888";

    public static void main(String[] args) {
        String dom = "北京王府井";
        System.out.println("'" + dom + "'的经纬度为：" + getCoordinate(dom));
    }

    /**
     * 调用百度地图API根据地址，获取坐标
     * @param address
     * @return
     */
    public static Result getCoordinate(String address) {
        if (address != null && !"".equals(address)) {
            address = address.replaceAll("\\s*", "").replace("#", "栋");
            String url = "http://api.map.baidu.com/geocoding/v3/?address=" + address + "&output=json&ak=" + AK+"&SN="+SN;
            String json = loadJSON(url);
            logger.info("位置信息：{}",json);
            if (StringUtils.isNotBlank(json)) {
                JSONObject obj = JSONObject.parseObject(json);
                if (SystemConstant.CODE_0.equals(obj.getString("status"))) {
                    /**
                     * 经度
                     */
                    double longitude = obj.getJSONObject("result").getJSONObject("location").getDouble("lng");
                    /**
                     * 纬度
                     */
                    double latitude = obj.getJSONObject("result").getJSONObject("location").getDouble("lat");
                    DecimalFormat df = new DecimalFormat("#.######");
                    Map<String, Object> map = new HashMap<>(6);
                    map.put("longitude",df.format(longitude));
                    map.put("latitude",df.format(latitude));
                    return Result.ok(map);
                }else{
                    return Result.error(obj.getString("message"));
                }
            }else{
                return Result.error();
            }
        }else{
            return Result.error();
        }
    }

    public static String loadJSON(String url) {
        StringBuilder json = new StringBuilder();
        try {
            URL oracle = new URL(url);
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream(), "UTF-8"));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json.toString();
    }
}
