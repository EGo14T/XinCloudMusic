package com.ego14t.xinmusic.util;

import org.springframework.cglib.beans.BeanCopier;
import org.springframework.util.CollectionUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2020/1/2 09:49
 * Description:
 */
public class BeanCopyUtils {
    /**
     * beanCopier缓存
     * (A拷贝到B,确定一个beanCopier)
     */
    private static Map<Class<?>,Map<Class<?>,BeanCopier>> beanCopierMap = new ConcurrentHashMap<>();

    /**
     * 拷贝方法
     */
    public static <S,T> void copy(S sourceBean,T targetBean){
        @SuppressWarnings("unchecked")
        Class<S> sourceClass = (Class<S>) sourceBean.getClass();
        @SuppressWarnings("unchecked")
        Class<T> targetClass = (Class<T>) targetBean.getClass();

        BeanCopier beanCopier = getBeanCopier(sourceClass,targetClass);
        beanCopier.copy(sourceBean,targetBean,null);
    }

    /**
     * 转换方法
     * @param sourceBean 原对象
     * @param targetClass 目标类
     */
    public static <S,T> T convert(S sourceBean,Class<T> targetClass){
        try {
            assert sourceBean!=null;
            T targetBean = targetClass.newInstance();
            copy(sourceBean,targetBean);
            return targetBean;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static <S,T> BeanCopier getBeanCopier(Class<S> sourceClass, Class<T> targetClass ){
        Map<Class<?>,BeanCopier> map = beanCopierMap.get(sourceClass);
        if(CollectionUtils.isEmpty(map)){
            BeanCopier newBeanCopier = BeanCopier.create(sourceClass, targetClass, false);
            Map<Class<?>,BeanCopier> newMap = new ConcurrentHashMap<>();
            newMap.put(targetClass,newBeanCopier);
            beanCopierMap.put(sourceClass,newMap);
            return newBeanCopier;
        }

        BeanCopier beanCopier = map.get(targetClass);
        if(beanCopier == null){
            BeanCopier newBeanCopier = BeanCopier.create(sourceClass, targetClass, false);
            map.put(targetClass,newBeanCopier);

            return newBeanCopier;
        }

        return beanCopier;
    }
}
