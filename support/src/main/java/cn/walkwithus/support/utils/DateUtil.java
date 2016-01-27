/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved
 */

package cn.walkwithus.support.utils;

import com.google.common.base.Preconditions;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yangtao.lyt
 * @version $Id: DateUtil, v 0.1 2016-01-26 19:15 yangtao.lyt Exp $
 */
public abstract class DateUtil {

    public static Date parseStr(String dateStr, String format){

        Preconditions.checkArgument(!StringUtils.isEmpty(dateStr), "dateStr不能为空");
        Preconditions.checkArgument(!StringUtils.isEmpty(format), "format不能为空");

        SimpleDateFormat sdf = new SimpleDateFormat(format);

        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException("解析时间错误", e);
        }
    }

    public static String format(Date date, String format){

        Preconditions.checkArgument(!StringUtils.isEmpty(date), "date不能为空");
        Preconditions.checkArgument(!StringUtils.isEmpty(format), "format不能为空");

        SimpleDateFormat sdf = new SimpleDateFormat(format);

        return sdf.format(date);

    }


}
