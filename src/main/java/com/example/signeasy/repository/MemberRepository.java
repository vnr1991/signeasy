package com.example.signeasy.repository;

import com.example.signeasy.Entity.Member;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by vaishakhnr on 10/18/17.
 */
public interface MemberRepository extends CrudRepository<Member, Long>{
}
