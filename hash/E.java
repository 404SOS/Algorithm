package com.aojia.practice.hash;

import com.aojia.up.backTrack.I;

import java.net.Inet4Address;
import java.util.HashMap;
import java.util.Map;

/**
 * @author QiTian
 * @date 2022/3/21
 * @Description 454. 四数相加 II
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 */
public class E {
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
       //将四组数据分为两两一组  AB  CD两组分别进行用Map存储
        Map<Integer, Integer> mapAB = new HashMap<>();
        for (int u : nums1){
            for (int v : nums2){
                int sumAB=u+v;
                //将AB数组得和存入map作为key，出现该和大小得次数作为value
                mapAB.put(sumAB,mapAB.getOrDefault(sumAB,0)+1);
            }
        }

        int res=0;//用来计数 相加得0得组合方式
        for (int u:nums3){
            for (int v:nums4){
                //sumCD取 正常C D数组之和得相反数
                int sumCD=-(u+v);
                // 如果该值sumCD在mapAB中存在 则get其键值 就是该u v情况下四树枝和得0得值
                if (mapAB.containsKey(sumCD))
                    res+=mapAB.get(sumCD);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int num1[]=new int[]{1,2};
        int num2[]=new int[]{-2,-1};
        int num3[]=new int[]{-1,2};
        int num4[]=new int[]{0,2};
        System.out.println(fourSumCount(num1,num2,num3,num4));
    }
}
