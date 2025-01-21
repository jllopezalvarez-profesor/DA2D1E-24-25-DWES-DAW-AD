package es.jllopezalvarez.ejemplos.ejemplo07gimnasio.services;

import es.jllopezalvarez.ejemplos.ejemplo07gimnasio.repositories.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Optional<Double> getAvgAgeForOlderThan(int age) {
        return memberRepository.getAvgAgeForOlderThan(age);
    }

}
