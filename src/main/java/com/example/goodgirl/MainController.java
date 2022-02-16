package com.example.goodgirl;

import com.example.goodgirl.repo.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    @Autowired
    MemberRepository memRepo;

    @RequestMapping("/")
    public ModelAndView Home(ModelAndView mav) {
        mav.setViewName("/index"); //뷰네임 지정

        mav.addObject("memRepo", memRepo.findAll()); //mav에 데이터 저장해서 해당 뷰에서 "memRepo"에 담긴 데이터 꺼내올수있음
        //findAll()반환형태 list임 -> 뷰에서 for문으로 데이터 꺼내야함

        return mav ;
    }

    @RequestMapping("/signUpPre")
    public ModelAndView signUpPre(ModelAndView mav) {
        mav.setViewName("/signUpPre2");
        return mav ;
    }

    @RequestMapping("/signUp")
    public ModelAndView signUp(ModelAndView mav) {
        mav.setViewName("/signUp2");
        return mav ;
    }

    @RequestMapping("/tabulator")
    public ModelAndView tabulator(ModelAndView mav) {
        mav.setViewName("/tabulator");
        return mav ;
    }

    //로그인 후 화면
    @RequestMapping("/login")
    public ModelAndView login(ModelAndView mav,  HttpServletRequest request) {
        mav.setViewName("login"); // 뷰네임
        HttpSession session = request.getSession(); // 로그인정보 담기 위한 세션
        String userId = (String) session.getAttribute("userId"); //세션에 로그인 id 담고 String 으로 형변환

        // findBy는 상자같은거여서 열어봐야 어떤 데이터가 있는지 알 수 있음 그래서 userId를 findById에 넣어서 get 해서 뽑아오기
        mav.addObject("memRepo", memRepo.findById(userId).get());
        return mav;
    }

    //회원정보 수정화면
}