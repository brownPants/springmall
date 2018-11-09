package com.example.springmall.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springmall.sample.mapper.SampleMapper;
import com.example.springmall.sample.vo.PageMaker;
import com.example.springmall.sample.vo.Sample;

@Service
@Transactional
public class SampleService {
	
	@Autowired
	private SampleMapper sampleMapper;
	
	// 4-1
	public Sample getSample(int sampleNo) {
		return sampleMapper.selectOne(sampleNo);
	}
	// 4-2
	public int modifySample(Sample sample) {
		return sampleMapper.updateSample(sample);
	}
	// 3
	public int addSample(Sample sample) {
		return sampleMapper.insertSample(sample);
	}
	// 2
	public int removeSample(int sampleNo) {
		return sampleMapper.deleteSample(sampleNo);
	}
	// 1
	public List<Sample> getSampleAll(PageMaker pageMaker) {
		// 페이징 관련 코드(set메서드 순서를 지켜야함)
		// 페이징에서 기본적으로 넣어줘야 할 값을 설정
		pageMaker.setRowPerPage(10);
		pageMaker.setPagePerBlock(10);
		pageMaker.setAllCount(sampleMapper.selectSampleAllCount());
		// 페이징에 필요한 값 계산하여 설정
		pageMaker.setStartRow();
		pageMaker.setLastPage();
		pageMaker.setCurrentBlock();
		pageMaker.setLastBlock();
		pageMaker.setStartPage();
		pageMaker.setEndPage();
		// 이전 페이지와 다음 페이지를 컨트롤하는 조건문
		if(pageMaker.getCurrentPage() > 0 && pageMaker.getCurrentPage() < pageMaker.getPagePerBlock() + 1) {
			pageMaker.setPrevPage(false);
			pageMaker.setNextPage(true);
		} else if(pageMaker.getLastBlock() == pageMaker.getCurrentBlock()) {
			pageMaker.setPrevPage(true);
			pageMaker.setNextPage(false);
		} else {
			pageMaker.setPrevPage(true);
			pageMaker.setNextPage(true);
		}
		return sampleMapper.selectSampleAll(pageMaker);
	}
	
}
