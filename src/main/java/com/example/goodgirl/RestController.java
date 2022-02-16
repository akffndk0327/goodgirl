package com.example.goodgirl;

import com.example.goodgirl.entity.Member;
import com.example.goodgirl.repo.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    MemberRepository memRepo;

    //form 데이터 저장하기
    @PostMapping("/signChk")
    public String signChk(@RequestBody Member member)throws Exception{
        try {
            //에러가 발생할 수 있는 코드-> 저장이 안될떄
            Optional<Member> byId = memRepo.findById(member.getId());//멤버아이디 찾아봐
            if(byId.isPresent()){ //아이디 있으면
                return "already exist";
//                throw new Exception();
            }else {
                memRepo.save(member);
            }
            //throw 임의로 발생시켜
        }catch (Exception e){
            //에러시 수행
            return "error";
        }
        return  "ok";
        //return 저장 결과값을 view에 알려줘야됨.
    }


    //아이디 비번 찾기
    @PostMapping("/loginChk")
    public String loginChk(@RequestBody Member member, HttpServletRequest request) {
        // id, password 체크체크 ~
        Member chk = memRepo.findByIdAndPassword(member.getId(), member.getPassword());

        if (chk != null) {
            // 로그인 성공 처리
            HttpSession session = request.getSession();                         // 세션이 있으면 있는 세션 반환, 없으면 신규 세션을 생성하여 반환
            session.setAttribute("userId",member.getId());   // 세션에 로그인 회원 정보 보관
            return "welcome" ;
        } else {
            return "없는 회원입니다.";
        }
    }

    //회원정보수정
    @PutMapping("update/{id}")
    public String updateMember(Member member){
        memRepo.findById(member.getId());
        return "ok";
    }


}