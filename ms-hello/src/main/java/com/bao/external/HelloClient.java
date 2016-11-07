package com.bao.external;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by user on 2016/11/7.
 */
@FeignClient(name = "ms-world")
public interface HelloClient {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    String world();
}
