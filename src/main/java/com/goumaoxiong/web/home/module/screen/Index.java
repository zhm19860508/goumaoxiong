package com.goumaoxiong.web.home.module.screen;

import java.util.Calendar;

import com.alibaba.citrus.turbine.Context;

public class Index {

    public void execute(Context context) {
        // 算当时是几月
        int imonth = Calendar.getInstance().getTime().getMonth() + 1;
        String cmonth = (imonth < 10) ? "0" + imonth : "" + imonth;
        // 加上前缀
        cmonth = "cal" + cmonth;
        context.put("cal", cmonth);
    }

}
