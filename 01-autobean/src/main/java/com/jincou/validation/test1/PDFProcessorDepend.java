package com.jincou.validation.test1;


import com.jd.jr.baitiao.agreement.export.rest.AgreementSignatureResource;
import com.jd.jr.cf.ledger.util.IdWorker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.stereotype.Component;

/**
 *  PDF处理器依赖
 * @author v-yuezhiwei2020
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class PDFProcessorDepend {
    /**
     *  ID生产器
     */
    private IdWorker idWorker;

    /**
     *  核销材料路径
     */
    private VerificationFiles verificationFiles;


    public void setIdWorker(IdWorker idWorker) {
        this.idWorker = idWorker;
    }

    public void setEngine(VelocityEngine engine) {
        this.engine = engine;
    }

    public VelocityEngine getEngine() {
        return engine;
    }

    /**
     *  VelocityEngine模板引擎
     */
    private VelocityEngine engine;

    /**
     * 协议签章服务 AppId
     */
    private String agreementSignatureAppId;

    /**
     * 协议签章服务 AppToken
     */
    private String agreementSignatureAppToken;

    public void setAgreementSignatureResource(AgreementSignatureResource agreementSignatureResource) {
        this.agreementSignatureResource = agreementSignatureResource;
    }

    public AgreementSignatureResource getAgreementSignatureResource() {
        return agreementSignatureResource;
    }

    /**
     * 协议签章服务
     */
    @Getter
    private AgreementSignatureResource agreementSignatureResource;

    /**
     *  签章机构名称
     */
    private String signatureOrgName = "上海和丰永讯金融信息服务有限公司";

}
