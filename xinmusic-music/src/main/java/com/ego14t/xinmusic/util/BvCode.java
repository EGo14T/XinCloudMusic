package com.ego14t.xinmusic.util;

/**
 * @author wangfx
 * @date 2020/11/27 16:55
 */
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

/**
 * Bilibili新启用了BV号代替av号， 本类可以将二者进行互相转换，也可以对xor、add、changeArray、dictionary进行自定义后作为自己的加解密工具类。
 * 注意要求，加密后的字符串长度要与changeArray进行匹配。
 */
public class BvCode {
    /**
     * 异或用的数，可变
     */
    public static final int xor = 177451812;

    /**
     * 加减用的数，可变
     */
    public static final long add = 100618342136696320L;

    /**
     * 核心变换数组，BV号的重排顺序，注意到该数组中没有元素0 元素1，意味着BV号的第一、第二位（前缀）不会参与到整个加密、解密的过程中。
     */
    public static final int[] changeArray = {11,10,3,8,4,6,2,9,5,7};

    /**
     * 核心变换字典，BV号是58进制，所以字典58位，代表从0-57。
     */
    public static final String dictionary = "fZodR9XQDSUm21yCkr6zBqiveYah8bt4xsWpHnJE7jL5VG3guMTKNPAwcF";

    /**
     * 加密过程中用到的前缀符，长度要求与changeArray最小元素值一致。
     */
    public static final String preFix = "XM";

    /**
     * 建立字典中字符与字典值之间的对应关系。
     * @return
     */
    public static Map<Character, Integer> getWorkingMap() {
        char[] cArray = dictionary.toCharArray();
        Map<Character, Integer> map = new HashMap<>(dictionary.length());
        for(int i = 0 ; i < dictionary.length() ; i++)
        {
            map.put(cArray[i], i);
        }
        return map;
    }

    /**
     * 获取整形数组中元素的最大/最小值
     * @param array 整形数组
     * @param max true获取最大值， false获取最小值
     * @return 最大、最小值
     */
    public static int getExtremum(int[] array , boolean max) {
        int k = (max ? Integer.MIN_VALUE : Integer.MAX_VALUE);
        for(int l : array)
        {
            k = (max ? Integer.max(k, l) : Integer.min(k, l));
        }
        return k;
    }

    /**
     * 解码 BV号转到AV号
     * @param BV号
     * @return av号
     */
    public static long decode(String bv) {
        //参数校验，前缀一致，且长度符合changeArray最大元素+1
        if(bv.startsWith(preFix) && bv.length() == (getExtremum(changeArray, true) + 1))
        {
            BigDecimal b = new BigDecimal(0);
            char[] intputArray = bv.toCharArray();
            for(int i = 0 ; i < changeArray.length ; i ++)
            {
                //TODO:参数校验，有可能Key取不到Value
                BigDecimal b1 = new BigDecimal(getWorkingMap().get(intputArray[changeArray[i]]));
                BigDecimal b2 = new BigDecimal(dictionary.length()).pow(i);
                b = b.add(b1.multiply(b2));
            }
            long l = b.subtract(new BigDecimal(add)).longValue();
            return l ^ xor;
        }
        else
        {
            return -1;
        }
    }

    public static String encode(long av) {
        BigDecimal b = new BigDecimal(av ^ xor).add(new BigDecimal(add));
        char[] resultArray = new char[changeArray.length];
        char[] dictionaryArray = dictionary.toCharArray();
        for(int i = 0 ;  i < changeArray.length ;  i++)
        {
            /*
             * 在生成的过程中，不需要考虑前缀，所以把重排数组中，前缀占用空间减去。要求：
             * assert getExtremum(changeArray, false) == preFix.length();
             */
            resultArray[changeArray[i] - getExtremum(changeArray, false)] =
                    dictionaryArray[
                            //(b / (进制的i次幂))对进制取模
                            b.divide(new BigDecimal(Math.pow(dictionary.length(), i)) , RoundingMode.DOWN)
                                    .remainder(new BigDecimal(dictionary.length()))
                                    .intValue()];
        }
        //将前缀加回。
        StringBuilder sb = new StringBuilder(preFix);
        for(char i : resultArray)
        {
            //拼接字符串。
            sb.append(i);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(decode("XMbzUjMY3sM3"));
        //System.out.println(encode());
    }
}
