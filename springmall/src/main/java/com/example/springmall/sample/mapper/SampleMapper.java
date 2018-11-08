package com.example.springmall.sample.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.springmall.sample.vo.Sample;

@Mapper
public interface SampleMapper { // 추상메서드, 추상클래스, 인터페이스(다중상속(구현) 가능)
	
	// 1. select all
	List<Sample> selectSampleAll(HashMap<String, Object> map); // 무조건 public abstract
	int selectSampleAllCount();
	// 2. delete
	int deleteSample(int sampleNo);
	// 3. insert
	int insertSample(Sample sample);
	// 4. update
	int updateSample(Sample sample);
	// 5. select one
	Sample selectOne(int sampleNo);
	
}
