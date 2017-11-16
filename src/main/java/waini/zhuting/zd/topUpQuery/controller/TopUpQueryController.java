package waini.zhuting.zd.topUpQuery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import top.rreeff.common.db.PageInfo;
import top.rreeff.common.db.impl.PageCond;
import top.rreeff.common.utils.ValidatorResultHandler;
import top.rreeff.topUpQuery.pojo.MemberGrade;
import top.rreeff.topUpQuery.pojo.TopupRecord;
import top.rreeff.topUpQuery.pojo.link.MemberGradeParam;
import top.rreeff.topUpQuery.pojo.link.TopupRecordParam;
import top.rreeff.topUpQuery.service.ITopUpQueryService;
import waini.zhuting.zd.common.utils.Response;

@Controller
@ResponseBody
@RequestMapping(value="/topUpQuery")
public class TopUpQueryController {
	
	@Autowired
	ITopUpQueryService topUpQueryService;
	
	/**
	 * 查询会员等级分页列表
	 * @param paramJson
	 * @param result
	 * @return
	 */
	@RequestMapping(value="/queryMemberGradeByPage", method = RequestMethod.POST)
	public Object queryMemberGradeByPage(@RequestBody MemberGradeParam paramJson,
			BindingResult result){
		Response retVal = ValidatorResultHandler.handle(result);
		if (retVal != null) {
			return retVal;
		}
		PageInfo<MemberGrade> MemberGrades;
		PageCond pageCond = new PageCond(paramJson.getCurrentPage(),
				paramJson.getPageSize());
		try {
			MemberGrades = topUpQueryService.queryMemberGradeByPage(paramJson,pageCond);
				return Response.getInstance().success(MemberGrades);
		} catch (Exception e) {
			e.printStackTrace();
			return Response.getInstance().failure("查询会员等级金额失败，后台报错了");
		}
	}
	
	/**
	 * 添加会员等级
	 */
	@RequestMapping(value="/addMemberGrade", method = RequestMethod.POST)
	public Object addClassify(@RequestBody MemberGradeParam paramJson,
			BindingResult result){
		Response retVal = ValidatorResultHandler.handle(result);
		if (retVal != null) {
			return retVal;
		}
		try {
			int i = topUpQueryService.addMemberGrade(paramJson);
			if(i > 0)
				return Response.getInstance().success("添加会员等级成功");
			else
				return Response.getInstance().failure("添加会员等级失败");
		} catch (Exception e) {
			e.printStackTrace();
			return Response.getInstance().failure("添加会员等级失败，后台报错了");
		}
	}
	
	/**
	 * 删除会员等级
	 */
	@RequestMapping(value="/deleteMemberGrade", method = RequestMethod.POST)
	public Object deleteMemberGrade(@RequestBody MemberGradeParam paramJson,
			BindingResult result){
		Response retVal = ValidatorResultHandler.handle(result);
		if (retVal != null) {
			return retVal;
		}
		try {
			int i = topUpQueryService.deleteMemberGrade(paramJson);
			if(i > 0)
				return Response.getInstance().success("删除会员等级成功");
			else
				return Response.getInstance().failure("删除会员等级失败");
		} catch (Exception e) {
			e.printStackTrace();
			return Response.getInstance().failure("删除会员等级失败，后台报错了");
		}
	}
	
	/**
	 * 编辑分类
	 */
	@RequestMapping(value="/updateMemberGrade", method = RequestMethod.POST)
	public Object updateMemberGrade(@RequestBody MemberGradeParam paramJson,
			BindingResult result){
		Response retVal = ValidatorResultHandler.handle(result);
		if (retVal != null) {
			return retVal;
		}
		try {
			int i = topUpQueryService.updateMemberGrade(paramJson);
			if(i > 0)
				return Response.getInstance().success("编辑会员等级成功");
			else
				return Response.getInstance().failure("编辑会员等级失败");
		} catch (Exception e) {
			e.printStackTrace();
			return Response.getInstance().failure("编辑会员等级失败，后台报错了");
		}
	}
	
	/**
	 * 查询充值记录分页列表
	 * @param paramJson
	 * @param result
	 * @return
	 */
	@RequestMapping(value="/queryTopUpRecordByPage", method = RequestMethod.POST)
	public Object queryTopUpRecordByPage(@RequestBody TopupRecordParam paramJson,
			BindingResult result){
		Response retVal = ValidatorResultHandler.handle(result);
		if (retVal != null) {
			return retVal;
		}
		PageInfo<TopupRecord> TopupRecords;
		PageCond pageCond = new PageCond(paramJson.getCurrentPage(),
				paramJson.getPageSize());
		try {
			TopupRecords = topUpQueryService.queryTopUpRecordByPage(paramJson,pageCond);
				return Response.getInstance().success(TopupRecords);
		} catch (Exception e) {
			e.printStackTrace();
			return Response.getInstance().failure("查询充值记录失败，后台报错了");
		}
	}
	
}
