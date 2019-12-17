package com.dianer.provider.service;

import com.dianer.api.PersonService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "dianer-server")
public interface KKPersonService extends PersonService {

}
