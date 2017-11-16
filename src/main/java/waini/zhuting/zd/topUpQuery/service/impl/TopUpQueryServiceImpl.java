package top.rreeff.topUpQuery.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.rreeff.common.db.IDataService;
import top.rreeff.common.db.PageInfo;
import top.rreeff.common.db.impl.PageCond;
import top.rreeff.topUpQuery.pojo.MemberGrade;
import top.rreeff.topUpQuery.pojo.TopupRecord;
import top.rreeff.topUpQuery.pojo.link.MemberGradeParam;
import top.rreeff.topUpQuery.pojo.link.TopupRecordParam;
import top.rreeff.topUpQuery.service.ITopUpQueryService;


@Service
public class TopUpQueryServiceImpl implements ITopUpQueryService {

	@Autowired
	IDataService<String, MemberGrade, MemberGrade> memberGradeDataService;
	@Autowired
	IDataService<String, TopupRecord, TopupRecord> topUpRecordDataService;
	@Override
	public PageInfo<MemberGrade> queryMemberGradeByPage(
			MemberGradeParam paramJson, PageCond pageCond) throws Exception {
		List<MemberGrade> MemberGrades =  memberGradeDataService.queryList4Page("MemberGradeMapper.queryMemberGradeByPage", paramJson, pageCond);
		return new PageInfo<MemberGrade>(pageCond.getCurrentPage(), pageCond.getPageSize(), pageCond.getCount(), MemberGrades);
	}
	@Override
	public int addMemberGrade(MemberGradeParam paramJson) throws Exception {
		paramJson.setId(UUID.randomUUID().toString().replace("-", ""));
		return memberGradeDataService.insert("MemberGradeMapper.addMemberGrade", paramJson);
	}
	@Override
	public int deleteMemberGrade(MemberGradeParam paramJson) throws Exception {
		return memberGradeDataService.delete("MemberGradeMapper.deleteMemberGrade", paramJson);
	}
	@Override
	public int updateMemberGrade(MemberGradeParam paramJson) throws Exception {
		return memberGradeDataService.update("MemberGradeMapper.updateMemberGrade", paramJson);
	}
	@Override
	public PageInfo<TopupRecord> queryTopUpRecordByPage(
			TopupRecordParam paramJson, PageCond pageCond) throws Exception {
		List<TopupRecord> TopupRecords =  topUpRecordDataService.queryList4Page("TopupRecordMapper.queryTopUpRecordByPage", paramJson, pageCond);
		return new PageInfo<TopupRecord>(pageCond.getCurrentPage(), pageCond.getPageSize(), pageCond.getCount(), TopupRecords);
	}

}
