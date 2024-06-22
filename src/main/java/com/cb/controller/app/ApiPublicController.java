package com.cb.controller.app;

import com.cb.domain.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public")
public class ApiPublicController {

    @GetMapping("/qqq")
    public Result<String> publicEndpoint() {
        return new Result<>("public endpoint");
    }

}
