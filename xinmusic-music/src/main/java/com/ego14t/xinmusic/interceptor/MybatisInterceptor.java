package com.ego14t.xinmusic.interceptor;

import com.ego14t.xinmusic.newentity.BaseEntity;
import com.ego14t.xinmusic.util.IDworker;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

/**
 * @author wangfx
 * @date 2020/11/19 10:37
 */
@Component
@Intercepts(@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}))
public class MybatisInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs(); //方法参数
        MappedStatement ms = (MappedStatement) args[0];
        Object parameter = args[1];
        SqlCommandType sqlCommandType = ms.getSqlCommandType(); //执行的sql类型 update insert

        if (parameter instanceof BaseEntity){
            BaseEntity entity = (BaseEntity) parameter;

            if (sqlCommandType == SqlCommandType.INSERT){
                if (StringUtils.isBlank(entity.getId())){
                    entity.setId(new IDworker(0,0).nextId());



                }
                if (entity.getCreateTime() == null){
                    entity.setCreateTime(LocalDateTime.now());
                }
            }else if (sqlCommandType == SqlCommandType.UPDATE){
                if (entity.getUpdateTime() == null){
                    entity.setUpdateTime(LocalDateTime.now());
                }
            }
        }

        return invocation.proceed();
    }
}
