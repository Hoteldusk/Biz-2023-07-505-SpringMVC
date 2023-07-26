package com.callor.rent.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.rent.config.QualifierConfig;
import com.callor.rent.dao.MemberDao;
import com.callor.rent.models.MemberDto;
import com.callor.rent.service.MemberService;

@Service(QualifierConfig.SERVICE.MEMBER_V1)
public class MemberServiceImplV1 implements MemberService {

	protected final MemberDao memberDao;

	public MemberServiceImplV1(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	/*
	 * 회원을 등록할 때 새로운 코드를 생성하여 memberDto에 업데이트하고 회원정보 insert 하기
	 */
	@Override
	public int insert(MemberDto memberDto) throws Exception {

		// .trim() white space 제거하기
		String tel = memberDto.getM_tel().trim();
		String name = memberDto.getM_name().trim();

		// 이름 + 전화번호가 중복되지 않도록 하기
		MemberDto resultDto = memberDao.findNameAndTel(name, tel);

		if (resultDto != null) {
			throw new Exception("NAME_TEL");
		}

		String mcode = this.getNewCode();
		memberDto.setM_code(mcode);
		return memberDao.insert(memberDto);
	}

	/*
	 * tbl_members table의 데이터를 조회하여 새로운 고객코드 생성하기
	 */
	public String getNewCode() {
		String mcode = memberDao.getMaxCode();
		String newCode = "000001";
		if (mcode != null) {
			newCode = String.format("%06d", Integer.valueOf(mcode) + 1);
		}
		return newCode;
	}

	@Override
	public List<MemberDto> selectAll() {
		// TODO Auto-generated method stub
		return memberDao.selectAll();
	}

	@Override
	public MemberDto findById(String mcode) {

		return memberDao.findById(mcode);
	}

	@Override
	public int update(MemberDto memberDto) throws Exception {
		
		String name = memberDto.getM_name().trim();
		String tel = memberDto.getM_tel().trim();
		
		MemberDto resultDto = memberDao.findNameAndTel(name, tel);

		/*
		 * 수정하기 위해 입력한 이름과 전화번호로 select를 했는데
		 * 데이터가 있다
		 * 1. 만약 m_code가 같다. : 데이터를 변경하지 않고
		 * 						저장하기를 클릭했다
		 * 2. 만약 m_code가 다르다. : 이미 등록된 회원의 이름, 전화번호로
		 * 						다시 수정을 시도 하였다. -> 중복데이터 오류
		 */
		if(resultDto != null && !resultDto.getM_code().equals(memberDto.getM_code())) {
			throw new Exception("NAME_TEL");
		}
		
		return memberDao.update(memberDto);
	}
	
	@Autowired
	public void crate_table() {
		memberDao.create_member_table(null);
	}

	@Override
	public List<MemberDto> findByName(String mname) {
		// TODO Auto-generated method stub
		return memberDao.findByName(mname);
	}

}
