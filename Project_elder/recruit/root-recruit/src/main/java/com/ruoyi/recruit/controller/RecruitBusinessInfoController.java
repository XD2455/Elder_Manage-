package com.ruoyi.recruit.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.RecruitBusinessInfo;
import com.ruoyi.system.service.IRecruitBusinessInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 企业信息管理Controller
 * 
 * @author XD
 * @date 2023-04-23
 */
@RestController
@RequestMapping("/system/info")
public class RecruitBusinessInfoController extends BaseController
{
    @Autowired
    private IRecruitBusinessInfoService recruitBusinessInfoService;

    /**
     * 查询企业信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(RecruitBusinessInfo recruitBusinessInfo)
    {
        startPage();
        List<RecruitBusinessInfo> list = recruitBusinessInfoService.selectRecruitBusinessInfoList(recruitBusinessInfo);
        return getDataTable(list);
    }

    /**
     * 导出企业信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:info:export')")
    @Log(title = "企业信息管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(RecruitBusinessInfo recruitBusinessInfo)
    {
        List<RecruitBusinessInfo> list = recruitBusinessInfoService.selectRecruitBusinessInfoList(recruitBusinessInfo);
        ExcelUtil<RecruitBusinessInfo> util = new ExcelUtil<RecruitBusinessInfo>(RecruitBusinessInfo.class);
        return util.exportExcel(list, "info");
    }

    /**
     * 获取企业信息管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:info:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(recruitBusinessInfoService.selectRecruitBusinessInfoById(id));
    }

    /**
     * 新增企业信息管理
     */
    @PreAuthorize("@ss.hasPermi('system:info:add')")
    @Log(title = "企业信息管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RecruitBusinessInfo recruitBusinessInfo)
    {
        return toAjax(recruitBusinessInfoService.insertRecruitBusinessInfo(recruitBusinessInfo));
    }

    /**
     * 修改企业信息管理
     */
    @PreAuthorize("@ss.hasPermi('system:info:edit')")
    @Log(title = "企业信息管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RecruitBusinessInfo recruitBusinessInfo)
    {
        return toAjax(recruitBusinessInfoService.updateRecruitBusinessInfo(recruitBusinessInfo));
    }

    /**
     * 删除企业信息管理
     */
    @PreAuthorize("@ss.hasPermi('system:info:remove')")
    @Log(title = "企业信息管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(recruitBusinessInfoService.deleteRecruitBusinessInfoByIds(ids));
    }
}
