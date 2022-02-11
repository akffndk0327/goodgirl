package com.example.goodgirl;

import com.example.goodgirl.entity.Member;
import com.example.goodgirl.repo.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    MemberRepository memRepo;

    //form 데이터 저장하기
    @PostMapping("/signChk")
    public String signChk(@RequestBody Member member){
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
}
