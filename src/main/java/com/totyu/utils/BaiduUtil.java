package com.totyu.utils;
public class BaiduUtil {
    public static void main(String[] args) {
        getDistanceFromTwoPoints(30.25924446, 120.21937542, 30.239652, 120.187755);

        distanceOfTwoPoints(30.25924446, 120.21937542, 30.239652, 120.187755);  //这种比较好
    }

    private static final Double PI = Math.PI;

    private static final Double PK = 180 / PI;

    public static double getDistanceFromTwoPoints(double lat_a, double lng_a, double lat_b, double lng_b) {
        double t1 = Math.cos(lat_a / PK) * Math.cos(lng_a / PK) * Math.cos(lat_b / PK) * Math.cos(lng_b / PK);
        double t2 = Math.cos(lat_a / PK) * Math.sin(lng_a / PK) * Math.cos(lat_b / PK) * Math.sin(lng_b / PK);
        double t3 = Math.sin(lat_a / PK) * Math.sin(lat_b / PK);

        double tt = Math.acos(t1 + t2 + t3);

        System.out.println("两点间的距离：" + 6366000 * tt + " 米");
        return 6366000 * tt;
    }


    /********************************************************************************************************/
    // 地球半径
    private static final double EARTH_RADIUS = 6370996.81;

    // 弧度
    private static double radian(double d) {
        return d * Math.PI / 180.0;
    }

    public static void distanceOfTwoPoints(double lat1, double lng1, double lat2, double lng2) {
        double radLat1 = radian(lat1);
        double radLat2 = radian(lat2);
        double a = radLat1 - radLat2;
        double b = radian(lng1) - radian(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
                + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000) / 10000;
        double ss = s * 1.0936132983377;
        System.out.println("两点间的距离是：" + s + "米" + "," + (int) ss + "码");
    }

    public static double distanceOfTwoPoints2(double lat1, double lng1, double lat2, double lng2) {
        double radLat1 = radian(lat1);
        double radLat2 = radian(lat2);
        double a = radLat1 - radLat2;
        double b = radian(lng1) - radian(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
                + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000) / 10000;
        return s ;
    }

}
