package com.template.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.template.test.model.Test;

@Mapper
public interface TestMapper {

	public List<Test> getTestListAll();
	public List<Test> getTestList(Test test);
	public Test getTest(Test test);
}
