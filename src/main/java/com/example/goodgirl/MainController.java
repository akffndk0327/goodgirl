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
        mav.setViewName("/index");

        mav.addObject("memRepo", memRepo.findAll());
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
        mav.setViewName("login");
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userId");
        mav.addObject("memRepo", memRepo.findById(userId).get());
        return mav;
    }
}