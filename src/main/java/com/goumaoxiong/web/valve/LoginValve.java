package com.goumaoxiong.web.valve;

import java.net.URLEncoder;
import java.util.Iterator;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.alibaba.citrus.service.pipeline.PipelineContext;
import com.alibaba.citrus.service.pipeline.support.AbstractValve;
import com.alibaba.citrus.service.uribroker.URIBrokerService;
import com.alibaba.citrus.service.uribroker.uri.URIBroker;
import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.citrus.turbine.TurbineRunData;
import com.alibaba.citrus.turbine.util.TurbineUtil;
import com.goumaoxiong.common.GmxConstants;
import com.goumaoxiong.dal.object.UserDO;

public class LoginValve extends AbstractValve {

    @Resource
    private HttpServletRequest request;
    @Resource
    private URIBrokerService   uriBrokerService;

    @Override
    public void invoke(PipelineContext pipelineContext) throws Exception {
        TurbineRunData rundata = (TurbineRunData) TurbineUtil.getTurbineRunData(request);
        HttpServletRequest request = rundata.getRequest();
        Navigator navigator = (Navigator) rundata;

        // 目前只有新增博客需要登录
        if (request.getRequestURI().contains("new_blog")) {

            HttpSession session = request.getSession();
            UserDO user = (UserDO) session.getAttribute(GmxConstants.LOGIN_USER);

            URIBroker loginUrl = uriBrokerService.getURIBroker("login");

            if (user == null) {
                loginUrl.addQueryData("callback", getUrlWithQueryString(request));
                navigator.redirectToLocation(loginUrl.render());
                return;
            }
        }

        pipelineContext.invokeNext();

    }

    private String getUrlWithQueryString(HttpServletRequest request) {
        StringBuffer buffer = request.getRequestURL();
        String query = getPostParms(request);
        if (query != null) {
            buffer.append("?").append(query);
        }
        return buffer.toString();
    }

    private String getPostParms(HttpServletRequest request) {
        String query = "";
        StringBuilder sb = new StringBuilder();

        for (@SuppressWarnings("rawtypes")
        Iterator iter = request.getParameterMap().keySet().iterator(); iter.hasNext();) {
            String parmName = (String) iter.next();
            String parmValue = request.getParameter(parmName);
            try {
                sb.append(parmName + "=" + URLEncoder.encode(parmValue, "GBK") + "&");
            } catch (Exception e) {
            }
        }

        if (sb.length() > 0) {
            int len = sb.length();

            query = sb.substring(0, len - 1);
        } else {
            query = null;
        }

        return query;
    }
}
