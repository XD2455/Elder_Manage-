package com.ruoyi.recruit.service;

import java.util.List;

import com.ruoyi.recruit.domain.RecruitCompanyInfo;

/**
 * 企业信息Service接口
 *
 * @author root
 * @date 2021-02-20
 */
public interface IRecruitCompanyInfoService {
    /**
     * 查询企业信息
     *
     * @param id 企业信息ID
     * @return 企业信息
     */
    public RecruitCompanyInfo selectRecruitCompanyInfoById(Long id);

    /**
     * 查询企业信息列表
     *
     * @param recruitCompanyInfo 企业信息
     * @return 企业信息集合
     */
    public List<RecruitCompanyInfo> selectRecruitCompanyInfoList(RecruitCompanyInfo recruitCompanyInfo);

    /**
     * 新增企业信息
     *
     * @param recruitCompanyInfo 企业信息
     * @return 结果
     */
    public int insertRecruitCompanyInfo(RecruitCompanyInfo recruitCompanyInfo);

    /**
     * 修改企业信息
     *
     * @param recruitCompanyInfo 企业信息
     * @return 结果
     */
    public int updateRecruitCompanyInfo(RecruitCompanyInfo recruitCompanyInfo);

    /**
     * 批量删除企业信息
     *
     * @param ids 需要删除的企业信息ID
     * @return 结果
     */
    public int deleteRecruitCompanyInfoByIds(Long[] ids);

    /**
     * 删除企业信息信息
     *
     * @param id 企业信息ID
     * @return 结果
     */
    public int deleteRecruitCompanyInfoById(Long id);
}
