package com.example.signeasy.controller;

import com.example.signeasy.Entity.Member;
import com.example.signeasy.pojo.BaseResponse;
import com.example.signeasy.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by vaishakhnr on 10/18/17.
 */
@Slf4j
@RestController
@RequestMapping("/member")
public class MemberController {
	@Autowired
	MemberService memberService;

	@RequestMapping(
			value = "/add",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public BaseResponse addMember(@RequestBody Member member) {
		log.info("addMember request {}", member);
		try {
			memberService.addMember(member);
			return new BaseResponse(0, "Success", null);
		} catch (Exception e) {
			log.error("exception in addMember {}", e);
			return new BaseResponse(1, "Failure", null);
		}
	}

	@RequestMapping(
			value = "/update",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public BaseResponse updateMember(@RequestBody Member member) {
		log.info("updateMember request {}", member);
		try {
			memberService.updateMember(member);
			return new BaseResponse(0, "Success", null);
		} catch (Exception e) {
			log.error("exception in updateMember {}", e);
			return new BaseResponse(1, "Failure", null);
		}
	}

	@RequestMapping(
			value = "/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public BaseResponse getMember(@PathVariable(value = "id") Long id) {
		log.info("getMember request {}", id);
		try {
			Member member = memberService.getMember(id);
			if (member == null) {
				return new BaseResponse(0, "Member not found", null);
			}
			return new BaseResponse(0, "Success", member);
		} catch (Exception e) {
			log.error("exception in getMember {}", e);
			return new BaseResponse(1, "Failure", null);
		}
	}

	@RequestMapping(
			value = "/{id}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public BaseResponse deleteMember(@PathVariable(value = "id") Long id) {
		log.info("deleteMember request {}", id);
		try {
			memberService.deleteMember(id);
			return new BaseResponse(0, "Success", null);
		} catch (Exception e) {
			log.error("exception in deleteMember {}", e);
			return new BaseResponse(1, "Failure", null);
		}
	}
}
