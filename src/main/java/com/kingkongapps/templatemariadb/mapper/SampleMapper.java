package com.kingkongapps.templatemariadb.mapper;

import com.kingkongapps.templatemariadb.vo.SampleVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SampleMapper {

    List<SampleVO> getSampleList(SampleVO sampleVO);
}
