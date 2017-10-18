package com.example.signeasy.dao.impl;

import com.example.signeasy.Entity.Member;
import com.example.signeasy.dao.MemberDao;
import com.example.signeasy.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vaishakhnr on 10/18/17.
 */
@Component
@Transactional
public class MemberDaoImpl implements MemberDao{
	@Autowired
	MemberRepository memberRepository;

	public void addOrUpdateMember(Member member) {
		memberRepository.save(member);
	}

	public Member getMember(Long id) {
		return memberRepository.findOne(id);
	}

	public void deleteMember(Long id) {
		memberRepository.delete(id);
	}


}
