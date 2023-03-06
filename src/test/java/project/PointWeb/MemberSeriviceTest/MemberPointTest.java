package project.PointWeb.MemberSeriviceTest;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import project.PointWeb.Controller.MemberController.MemberBasicController;
import project.PointWeb.Service.MemberBasicService;
import project.PointWeb.Repository.MemberRepository;

@SpringBootTest
@Transactional
@Rollback
public class MemberPointTest {


    @Autowired MemberBasicController memberController;
    @Autowired MemberRepository memberRepository;
    @Autowired
    MemberBasicService memberBasicService;

    @Test
    void 포인트_지급_아이디_미존재_테스트(){



    }

    @Test
    void 포인트_지급_포인트_부족_테스트(){

    }

    @Test
    void 포인트_지급_성공_테스트(){

    }




}
