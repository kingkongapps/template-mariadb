package com.kingkongapps.templatemariadb.controller;

import com.kingkongapps.templatemariadb.service.SampleService;
import com.kingkongapps.templatemariadb.vo.SampleVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;

@Controller
@Slf4j
public class SampleController {

    @Autowired
    private SampleService sampleService;

    @GetMapping(value = "/sample_ajax")
    public String getSampleAjax(Model model) {
        log.debug("getSampleAjax...");

        return "/sample/sample_ajax";
    }

    @GetMapping(value = "/sample_thymeleaf")
    public String getSampleThymeleaf(Model model) {
        log.debug("getSampleThymeleaf...");

        Date today = new Date();
        //
        List<SampleVO> list = sampleService.getSampleList(new SampleVO());

        model.addAttribute("serverTime", today );
        model.addAttribute("sampleList", list);

        return "/sample/sample_thymeleaf";
    }


    @GetMapping(value = "/sample_jsp")
    public String getSampleJsp(Model model) {
        log.debug("getSampleJsp...");

        Date today = new Date();
        //
        List<SampleVO> list = sampleService.getSampleList(new SampleVO());

        model.addAttribute("serverTime", today );
        model.addAttribute("sampleList", list);

        return "/sample/sample_jsp";
    }
}
