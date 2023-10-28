package com.kingkongapps.templatemariadb.service;

import com.kingkongapps.templatemariadb.vo.SampleVO;

import java.util.List;

public interface SampleService {
    List<SampleVO> getSampleList(SampleVO sampleVO);
}
