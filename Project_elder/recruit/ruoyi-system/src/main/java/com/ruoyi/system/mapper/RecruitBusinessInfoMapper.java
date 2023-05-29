package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.RecruitBusinessInfo;

/**
 * 企业信息管理Mapper接口
 * 
 * @author XD
 * @date 2023-04-23
 */
public interface RecruitBusinessInfoMapper 
{
    /**
     * 查询企业信息管理
     * 
     * @param id 企业信息管理ID
     * @return 企业信息管理
     */
    public RecruitBusinessInfo selectRecruitBusinessInfoById(Long id);

    /**
     * 查询企业信息管理列表
     * 
     * @param recruitBusinessInfo 企业信息管理
     * @return 企业信息管理集合
     */
    public List<RecruitBusinessInfo> selectRecruitBusinessInfoList(RecruitBusinessInfo recruitBusinessInfo);

    /**
     * 新增企业信息管理
     * 
     * @param recruitBusinessInfo 企业信息管理
     * @return 结果
     */
    public int insertRecruitBusinessInfo(RecruitBusinessInfo recruitBusinessInfo);

    /**
     * 修改企业信息管理
     * 
     * @param recruitBusinessInfo 企业信息管理
     * @return 结果
     */
    public int updateRecruitBusinessInfo(RecruitBusinessInfo recruitBusinessInfo);

    /**
     * 删除企业信息管理
     * 
     * @param id 企业信息管理ID
     * @return 结果
     */
    public int deleteRecruitBusinessInfoById(Long id);

    /**
     * 批量删除企业信息管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRecruitBusinessInfoByIds(Long[] ids);
}
