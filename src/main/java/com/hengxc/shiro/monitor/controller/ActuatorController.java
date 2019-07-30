package com.hengxc.shiro.monitor.controller;

import com.hengxc.shiro.common.entity.Response;
import com.hengxc.shiro.common.exception.FebsException;
import com.hengxc.shiro.common.utils.DateUtil;
import com.hengxc.shiro.monitor.endpoint.FebsHttpTraceEndpoint;
import com.hengxc.shiro.monitor.entity.HttpTrace;
import com.hengxc.shiro.monitor.helper.ActuatorHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.hengxc.shiro.monitor.endpoint.FebsHttpTraceEndpoint.HttpTraceDescriptor;

/**
 * @author ctrl+shift+r 一键替换
 * @date 2019/7/26 10:22
 */
@Slf4j
@RestController
@RequestMapping("febs/actuator")
public class ActuatorController {

    @Autowired
    private FebsHttpTraceEndpoint httpTraceEndpoint;
    @Autowired
    private ActuatorHelper actuatorHelper;

    @GetMapping("httptrace")
    @RequiresPermissions("httptrace:view")
    public Response httpTraces(String method, String url) throws FebsException {
        try {
            HttpTraceDescriptor traces = httpTraceEndpoint.traces();
            List<org.springframework.boot.actuate.trace.http.HttpTrace> httpTraceList = traces.getTraces();
            List<HttpTrace> febsHttpTraces = new ArrayList<>();
            httpTraceList.forEach(t -> {
                HttpTrace httpTrace = new HttpTrace();
                httpTrace.setRequestTime(DateUtil.formatInstant(t.getTimestamp(), DateUtil.FULL_TIME_SPLIT_PATTERN));
                httpTrace.setMethod(t.getRequest().getMethod());
                httpTrace.setUrl(t.getRequest().getUri());
                httpTrace.setStatus(t.getResponse().getStatus());
                httpTrace.setTimeTaken(t.getTimeTaken());
                if (StringUtils.isNotBlank(method) && StringUtils.isNotBlank(url)) {
                    if (StringUtils.equalsIgnoreCase(method, httpTrace.getMethod())
                            && StringUtils.containsIgnoreCase(httpTrace.getUrl().toString(), url))
                        febsHttpTraces.add(httpTrace);
                } else if (StringUtils.isNotBlank(method)) {
                    if (StringUtils.equalsIgnoreCase(method, httpTrace.getMethod()))
                        febsHttpTraces.add(httpTrace);
                } else if (StringUtils.isNotBlank(url)) {
                    if (StringUtils.containsIgnoreCase(httpTrace.getUrl().toString(), url))
                        febsHttpTraces.add(httpTrace);
                } else {
                    febsHttpTraces.add(httpTrace);
                }
            });
            Map<String, Object> data = new HashMap<>();
            data.put("rows", febsHttpTraces);
            data.put("total", febsHttpTraces.size());
            return new Response().success().data(data);
        } catch (Exception e) {
            String message = "请求追踪失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }
}
