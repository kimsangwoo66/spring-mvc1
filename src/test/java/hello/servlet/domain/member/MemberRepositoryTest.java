package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemberRepositoryTest {
    //싱글톤이기때문에 = new로 생성하면 안된다.
    //스프링 자체가 싱글톤을 보장
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void atterEach(){
        //한 메소드마다 테스트가 실행되면 값이 메모리에 쌓여있기때문에 태스트 오류가 생길수 있다.
        //따라서 테스트가 끝날때 마다 이 함수가 실행되게 해줘야한다.
        memberRepository.clearStore();
    }

    @Test
    void save(){
        //given
        Member member = new Member("hello", 20);

        //when
        Member savedMember = memberRepository.save(member);


        //then
        Member findMember =memberRepository.findById(savedMember.getId());
        assertThat(findMember).isEqualTo(savedMember);


    }


    @Test
    void findAll(){
        //given
        Member member1=new Member("member1", 20);
        Member member2=new Member("member2", 30);

        memberRepository.save(member1);
        memberRepository.save(member2);
        //when
        List<Member> result=memberRepository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1,member2);



    }

}
