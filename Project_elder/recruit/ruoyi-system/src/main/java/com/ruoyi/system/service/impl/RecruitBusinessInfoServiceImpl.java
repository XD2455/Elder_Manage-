package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.RecruitBusinessInfoMapper;
import com.ruoyi.system.domain.RecruitBusinessInfo;
import com.ruoyi.system.service.IRecruitBusinessInfoService;

/**
 * 企业信息管理Service业务层处理
 * 
 * @author XD
 * @date 2023-04-23
 */
@Service
public class RecruitBusinessInfoServiceImpl implements IRecruitBusinessInfoService 
{
    @Autowired
    private RecruitBusinessInfoMapper recruitBusinessInfoMapper;

    /**
     * 查询企业信息管理
     * 
     * @param id 企业信息管理ID
     * @return 企业信息管理
     */
    @Override
    public RecruitBusinessInfo selectRecruitBusinessInfoById(Long id)
    {
        return recruitBusinessInfoMapper.selectRecruitBusinessInfoById(id);
    }

    /**
     * 查询企业信息管理列表
     * 
     * @param recruitBusinessInfo 企业信息管理
     * @return 企业信息管理
     */
    @Override
    public List<RecruitBusinessInfo> selectRecruitBusinessInfoList(RecruitBusinessInfo recruitBusinessInfo)
    {
        return recruitBusinessInfoMapper.selectRecruitBusinessInfoList(recruitBusinessInfo);
    }

    /**
     * 新增企业信息管理
     * 
     * @param recruitBusinessInfo 企业信息管理
     * @return 结果
     */
    @Override
    public int insertRecruitBusinessInfo(RecruitBusinessInfo recruitBusinessInfo)
    {
        return recruitBusinessInfoMapper.insertRecruitBusinessInfo(recruitBusinessInfo);
    }

    /**
     * 修改企业信息管理
     * 
     * @param recruitBusinessInfo 企业信息管理
     * @return 结果
     */
    @Override
    public int updateRecruitBusinessInfo(RecruitBusinessInfo recruitBusinessInfo)
    {
        return recruitBusinessInfoMapper.updateRecruitBusinessInfo(recruitBusinessInfo);
    }

    /**
     * 批量删除企业信息管理
     * 
     * @param ids 需要删除的企业信息管理ID
     * @return 结果
     */
    @Override
    public int deleteRecruitBusinessInfoByIds(Long[] ids)
    {
        return recruitBusinessInfoMapper.deleteRecruitBusinessInfoByIds(ids);
    }

    /**
     * 删除企业信息管理信息
     * 
     * @param id 企业信息管理ID
     * @return 结果
     */
    @Override
    public int deleteRecruitBusinessInfoById(Long id)
    {
        return recruitBusinessInfoMapper.deleteRecruitBusinessInfoById(id);
    }
}
