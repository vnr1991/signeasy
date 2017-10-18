package com.example.signeasy.dao;


import com.example.signeasy.Entity.Member;

/**
 * Created by vaishakhnr on 10/18/17.
 */
public interface MemberDao {
	void addOrUpdateMember(Member book);
	Member getMember(Long id);
	void deleteMember(Long id);
}
