package com.example.signeasy.service;

import com.example.signeasy.Entity.Member;
import com.example.signeasy.dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vaishakhnr on 10/18/17.
 */
@Service
public class MemberService {
	@Autowired
	MemberDao memberDao;

	public void addMember(Member member) {
		memberDao.addOrUpdateMember(member);
	}

	public void updateMember(Member member) {
		memberDao.addOrUpdateMember(member);
	}

	public Member getMember(Long id) {
		return memberDao.getMember(id);
	}

	public void deleteMember(Long id) {
		memberDao.deleteMember(id);
	}
}
