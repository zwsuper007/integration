package com.zhaowei.config.druid;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
*@name:DruidStatFilter
*@date:2017/11/15 10:25
*@package:org.mytian.db.utils
*@version:V1.0
*@description:TODO
*@author:xiaotian.zhang
*@modify by:
*/

@WebFilter(filterName="druidStatFilter",urlPatterns="/*",
        initParams={
                @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")// 忽略资源
        })
public class DruidStatFilter extends WebStatFilter {

}

