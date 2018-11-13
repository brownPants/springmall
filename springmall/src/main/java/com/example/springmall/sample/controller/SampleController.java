package com.example.springmall.sample.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springmall.sample.service.SampleService;
import com.example.springmall.sample.vo.PageMaker;
import com.example.springmall.sample.vo.Sample;
import com.example.springmall.sample.vo.SampleRequest;

@Controller
public class SampleController {
	
	@Autowired
	private SampleService sampleService;
	/*
	 * DATA(변수)+FUNCTION(제어문,연산자)
	 */
	// 4-1. 수정 폼
	@RequestMapping(value = "/sample/modifySample", method = RequestMethod.GET)
	public String modifySample(Model model, @RequestParam(value = "sampleNo") int sampleNo) {
		Sample sample = sampleService.getSample(sampleNo);
		model.addAttribute("sample", sample);
		return "/sample/modifySample";
	}
	// 4-2. 수정 액션
	@RequestMapping(value = "/sample/modifySample", method = RequestMethod.POST)
	public String modifySample(Sample sample) {
		if(sampleService.modifySample(sample) == 1) {
			System.out.println(sample.getSampleNo()+"번 데이터 수정 성공");
		} else {
			System.out.println(sample.getSampleNo()+"번 데이터 수정 성공");
		}
		return "redirect:/sample/sampleList";
	}
	// 3-1. 입력 폼
	@RequestMapping(value = "/sample/addSample", method = RequestMethod.GET)
	public String addSample() {
		return "/sample/addSample";
		// jquery, bootstrap, Sample command객체를 사용할 것을 염두해두자
	}
	// 3-2. 입력 액션
	@RequestMapping(value = "/sample/addSample", method = RequestMethod.POST)
	public String addSample(SampleRequest sampleRequest, HttpSession session) {
		// 커맨드 객체 멤버 변수의 이름과 input태그 name의 이름이 같아야함, setter를 호출하므로 표준 setter가 필요하다.
		// 세션을 통해 상대경로를 받아와 sampleRequest에 넣어준다.
		sampleRequest.setSampleFilePath(session.getServletContext().getRealPath("\\WEB-INF\\uploads"));
		if(sampleService.addSample(sampleRequest) == 1) {
			System.out.println("ID:"+sampleRequest.getSampleId()+"인 데이터 추가 성공");
		} else {
			System.out.println("ID:"+sampleRequest.getSampleId()+"인 데이터 추가 실패");
		}
		return "redirect:/sample/sampleList";
	}
	// 2. 삭제
	@RequestMapping(value = "/sample/removeSample", method = RequestMethod.GET)
	public String removeSample(@RequestParam(value = "sampleNo") int sampleNo) {
		if(sampleService.removeSample(sampleNo) == 1) {
			System.out.println(sampleNo+"번 데이터 삭제 성공");
		} else {
			System.out.println(sampleNo+"번 데이터 삭제 실패");
		}
		return "redirect:/sample/sampleList";
	}
	// 1. 샘플목록
	@RequestMapping(value = "/sample/sampleList", method = RequestMethod.GET)
	public String sampleList(Model model, HashMap<String, Object> map, PageMaker pageMaker, @RequestParam(value = "currentPage", defaultValue = "1") int currentPage, @RequestParam(value = "searchWord", defaultValue = "") String searchWord) { // Model model = new Model();
		pageMaker.setCurrentPage(currentPage);
		map.put("pageMaker", pageMaker);
		map.put("searchWord", "%"+searchWord+"%");
		List<Sample> sampleList = sampleService.getSampleAll(map);
		model.addAttribute("sampleList", sampleList);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pagePerBlock", pageMaker.getPagePerBlock());
		model.addAttribute("currentBlock", pageMaker.getCurrentBlock());
		model.addAttribute("startPage", pageMaker.getStartPage());
		model.addAttribute("endPage", pageMaker.getEndPage());
		model.addAttribute("prevPage", pageMaker.isPrevPage());
		model.addAttribute("nextPage", pageMaker.isNextPage());
		model.addAttribute("searchWord", searchWord);
		return "/sample/sampleList";
	}
	
}
