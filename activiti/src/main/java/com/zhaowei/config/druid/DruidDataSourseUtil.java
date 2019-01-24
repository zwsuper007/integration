package com.zhaowei.config.druid;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.SQLException;
import java.util.Properties;

/**
*@name:DruidDataSourseUtil
*@date:2017/11/15 14:39
*@package:org.mytian.db.utils
*@version:V1.0
*@description:TODO
*@author:xiaotian.zhang
*@modify by:
*/

public class DruidDataSourseUtil {
    public static DruidDataSource getDataSource(DruidSetting druidSetting){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(druidSetting.getDriverClassName());
        dataSource.setUrl(druidSetting.getUrl());
        dataSource.setUsername(druidSetting.getUsername());
        dataSource.setPassword(druidSetting.getPassword());
        dataSource.setInitialSize(druidSetting.getInitialSize());
        dataSource.setMinIdle(druidSetting.getMinIdle());
        dataSource.setMaxActive(druidSetting.getMaxActive());
        dataSource.setMaxWait(druidSetting.getMaxWait());
        dataSource.setTimeBetweenEvictionRunsMillis(druidSetting.getTimeBetweenEvictionRunsMillis());
        dataSource.setMinEvictableIdleTimeMillis(druidSetting.getMinEvictableIdleTimeMillis());
        String validationQuery = druidSetting.getValidationQuery();
        if (validationQuery != null && !"".equals(validationQuery)) {
            dataSource.setValidationQuery(validationQuery);
        }
        dataSource.setTestWhileIdle(druidSetting.isTestWhileIdle());
        dataSource.setTestOnBorrow(druidSetting.isTestOnBorrow());
        dataSource.setTestOnReturn(druidSetting.isTestOnReturn());
        if(druidSetting.isPoolPreparedStatements()){
            dataSource.setMaxPoolPreparedStatementPerConnectionSize(druidSetting.getMaxPoolPreparedStatementPerConnectionSize());
        }
        try {
            //这是最关键的,否则SQL监控无法生效
            dataSource.setFilters(druidSetting.getFilters());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String connectionPropertiesStr = druidSetting.getConnectionProperties();
        if(connectionPropertiesStr != null && !"".equals(connectionPropertiesStr)){
            Properties connectProperties = new Properties();
            String[] propertiesList = connectionPropertiesStr.split(";");
            for(String propertiesTmp:propertiesList){
                String[] obj = propertiesTmp.split("=");
                String key = obj[0];
                String value = obj[1];
                connectProperties.put(key,value);
            }
            dataSource.setConnectProperties(connectProperties);
        }
        dataSource.setUseGlobalDataSourceStat(druidSetting.isUseGlobalDataSourceStat());

        return dataSource;
    }
}
