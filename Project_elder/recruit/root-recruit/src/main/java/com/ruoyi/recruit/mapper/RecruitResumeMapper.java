package com.ruoyi.recruit.mapper;

import java.util.List;
import com.ruoyi.recruit.domain.RecruitResume;

/**
 * 求职者简历信息Mapper接口
 *
 * @author ruoyi
 * @date 2021-04-03
 */
public interface RecruitResumeMapper
{
    /**
     * 查询求职者简历信息
     *
     * @param id 求职者简历信息ID
     * @return 求职者简历信息
     */
    public RecruitResume selectRecruitResumeById(Long id);

    public RecruitResume selectResumeByUserId(Long userId);

    /**
     * 查询求职者简历信息列表
     *
     * @param recruitResume 求职者简历信息
     * @return 求职者简历信息集合
     */
    public List<RecruitResume> selectRecruitResumeList(RecruitResume recruitResume);

    /**
     * 新增求职者简历信息
     *
     * @param recruitResume 求职者简历信息
     * @return 结果
     */
    public int insertRecruitResume(RecruitResume recruitResume);

    /**
     * 修改求职者简历信息
     *
     * @param recruitResume 求职者简历信息
     * @return 结果
     */
    public int updateRecruitResume(RecruitResume recruitResume);

    /**
     * 删除求职者简历信息
     *
     * @param id 求职者简历信息ID
     * @return 结果
     */
    public int deleteRecruitResumeById(Long id);

    /**
     * 批量删除求职者简历信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRecruitResumeByIds(Long[] ids);
}
