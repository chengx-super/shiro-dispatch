package com.hengxc.shiro.monitor.endpoint;

import com.hengxc.shiro.common.annotation.EndPoint;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;

import java.util.List;

/**
 * @author chenguangxu
 * @date 2019/7/26 10:19
 */
@EndPoint
public class FebsHttpTraceEndpoint {

    private final HttpTraceRepository repository;

    public FebsHttpTraceEndpoint(HttpTraceRepository repository) {
        this.repository = repository;
    }

    public HttpTraceDescriptor traces() {
        return new HttpTraceDescriptor(this.repository.findAll());
    }

    public static final class HttpTraceDescriptor {

        private final List<HttpTrace> traces;

        private HttpTraceDescriptor(List<HttpTrace> traces) {
            this.traces = traces;
        }

        public List<HttpTrace> getTraces() {
            return this.traces;
        }
    }
}
