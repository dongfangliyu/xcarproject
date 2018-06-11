package com.fintecher.util;


import java.util.HashMap;
import java.util.Map;

/**
 * @Author: PeiShouWen
 * @Description: 地图工具类
 * @Date 13:50 2017/8/18
 */
public class MapUtil {

    /**
     * 计算一个经纬度指定半径区域内圆形切四边形的四个点的坐标
     *
     * @param lng    经度
     * @param lat    纬度
     * @param radius 半径
     */
    public static Map<String, Double> computeOrigin4Position(double lng, double lat, double radius) {
        double dlng = 2 * Math.asin(Math.sin(radius / (2 * Constants.EARTH_RADIUS)) / Math.cos(lat * Math.PI / 180));
        dlng = dlng * 180 / Math.PI;//角度转为弧度
        double dlat = radius / Constants.EARTH_RADIUS;
        dlat = dlat * 180 / Math.PI;
        //左上经纬度
        double leftTopLat = lat + dlat;
        double leftToplng = lng - dlng;
        //右上经纬度
        double rightToplat = lat + dlat;
        double rightToplng = lng + dlng;
        //左下经纬度
        double leftBottomLat = lat - dlat;
        double leftBottomlng = lng - dlng;
        //右下经纬度
        double rightBottomLat = lat - dlat;
        double rightBottomlng = lng + dlng;

        double minlat = lat - dlat;
        double maxlat = lat + dlat;
        double minlng = lng - dlng;
        double maxlng = lng + dlng;
        Map<String, Double> resultMap = new HashMap<>();
        resultMap.put("minlng", minlng);//最小经度
        resultMap.put("maxlng", maxlng);//最大经度
        resultMap.put("minlat", minlat);//最小纬度
        resultMap.put("maxlat", maxlat);//最大纬度
        return resultMap;
    }

    public static void main(String[] args) {
        computeOrigin4Position(118.499127, 31.671681, 2);
    }
}
