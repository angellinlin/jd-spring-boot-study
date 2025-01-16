package com.jincou.third.dao;

/**
 * @author zhouguilong6
 * @date 2025/1/15 22:17
 */
import com.jdd.fintech.morse.base.dao.PrimaryMapper;
import com.jdd.fintech.morse.base.entity.split.CrlArchiveInfo;
import com.jdd.fintech.morse.base.entity.split.bt.archives.CrlDebtbtArchiveInfo;
import com.jincou.third.entity.CrlDebtDtArchiveInfoDO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @类描述: 网贷白条影像件信息表Mapper（crl_debtbt_archive_info）
 * @类名称: CrlDebtbtArchiveInfoMapper
 * @操作人: ext.fengcheng
 * @操作时间: 2022/8/15 10:35
 * @项目名称: morse-loan-common-service
 **/
public interface CrlDebtbtArchiveInfoMapper extends PrimaryMapper<CrlDebtbtArchiveInfo, CrlDebtbtArchiveInfo> {

    /**
     * 根据租户号、业务号、文件类型进行数据删除操作
     *
     * @param businessNo
     * @param tenantId
     * @param type
     * @param customerCode
     * @return
     */
    @Delete(" delete from crl_debtbt_archive_info " +
            " where business_no = #{businessNo}" +
            " and tenant_id = #{tenantId}" +
            " and file_type = #{type}" +
            " and customer_code = #{customerCode}")
    int deleteByBusinessNoAndFileType(@Param("businessNo") String businessNo,
                                      @Param("tenantId") String tenantId,
                                      @Param("type") CrlArchiveInfo.FileType type,
                                      @Param("customerCode") String customerCode);

    @Select(" select *  from crl_debtbt_archive_info" +
            " where tenant_id=#{tenantId,jdbcType=VARCHAR} " +
            " and business_no = #{businessNo,jdbcType=VARCHAR}" +
            " and file_type = #{fileType,jdbcType=VARCHAR}" +
            " and customer_code = #{customerCode,jdbcType=VARCHAR}")
    CrlDebtbtArchiveInfo selectByBusiNoAndArchType(@Param("tenantId") String tenantId,
                                                   @Param("businessNo") String businessNo,
                                                   @Param("fileType")  CrlArchiveInfo.FileType fileType,
                                                   @Param("customerCode") String customerCode);


    @Select(" select *  from crl_debtbt_archive_info" +
            " where tenant_id=#{tenantId,jdbcType=VARCHAR}")
    List<CrlDebtDtArchiveInfoDO> selectByBusiNoAndCustmerCode(@Param("tenantId") String tenantId);

}
