package top.rreeff.topUpQuery.service;

import top.rreeff.common.db.PageInfo;
import top.rreeff.common.db.impl.PageCond;
import top.rreeff.topUpQuery.pojo.MemberGrade;
import top.rreeff.topUpQuery.pojo.TopupRecord;
import top.rreeff.topUpQuery.pojo.link.MemberGradeParam;
import top.rreeff.topUpQuery.pojo.link.TopupRecordParam;

public interface ITopUpQueryService {

	/**
	 * 查询会员等级金额分页列表
	 * @param paramJson
	 * @param pageCond
	 * @return
	 * @throws Exception
	 */
	PageInfo<MemberGrade> queryMemberGradeByPage(MemberGradeParam paramJson,
			PageCond pageCond)throws Exception;
	/**
	 * 添加会员等级
	 * @param paramJson
	 * @return
	 * @throws Exception
	 */
	int addMemberGrade(MemberGradeParam paramJson)throws Exception;
	/**
	 * 删除会员等级
	 * @param paramJson
	 * @return
	 */
	int deleteMemberGrade(MemberGradeParam paramJson)throws Exception;
	/**
	 * 编辑会员等级
	 * @param paramJson
	 * @return
	 */
	int updateMemberGrade(MemberGradeParam paramJson)throws Exception;
	/**
	 * 查询充值记录分页列表
	 * @param paramJson
	 * @param pageCond
	 * @return
	 * @throws Exception
	 */
	PageInfo<TopupRecord> queryTopUpRecordByPage(TopupRecordParam paramJson,
			PageCond pageCond)throws Exception;

}
