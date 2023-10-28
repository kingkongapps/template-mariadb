package com.kingkongapps.templatemariadb.service.impl;

import com.kingkongapps.templatemariadb.mapper.SampleMapper;
import com.kingkongapps.templatemariadb.service.SampleService;
import com.kingkongapps.templatemariadb.vo.SampleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SampleServiceImpl implements SampleService {
    @Autowired
    private SampleMapper mapper;

    @Override
    public List<SampleVO> getSampleList(SampleVO sampleVO) {
        return mapper.getSampleList(sampleVO);
    }
}
