package com.jincou.third.entity;

import java.time.LocalDateTime;

public class CrlDebtDtArchiveInfoDO {
    private Long id;

    private String tenantId;

    private String companyId;

    private String productCode;

    private String customerCode;

    private String userId;

    private String fileType;

    private String archiveUrl;

    private String archiveFileName;

    private String scene;

    private String businessNo;

    private String outsideBusinessNo;

    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;

    public Long getId() {
        return id;
    }

    public CrlDebtDtArchiveInfoDO withId(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenantId() {
        return tenantId;
    }

    public CrlDebtDtArchiveInfoDO withTenantId(String tenantId) {
        this.setTenantId(tenantId);
        return this;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public CrlDebtDtArchiveInfoDO withCompanyId(String companyId) {
        this.setCompanyId(companyId);
        return this;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public String getProductCode() {
        return productCode;
    }

    public CrlDebtDtArchiveInfoDO withProductCode(String productCode) {
        this.setProductCode(productCode);
        return this;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public CrlDebtDtArchiveInfoDO withCustomerCode(String customerCode) {
        this.setCustomerCode(customerCode);
        return this;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode == null ? null : customerCode.trim();
    }

    public String getUserId() {
        return userId;
    }

    public CrlDebtDtArchiveInfoDO withUserId(String userId) {
        this.setUserId(userId);
        return this;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getFileType() {
        return fileType;
    }

    public CrlDebtDtArchiveInfoDO withFileType(String fileType) {
        this.setFileType(fileType);
        return this;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    public String getArchiveUrl() {
        return archiveUrl;
    }

    public CrlDebtDtArchiveInfoDO withArchiveUrl(String archiveUrl) {
        this.setArchiveUrl(archiveUrl);
        return this;
    }

    public void setArchiveUrl(String archiveUrl) {
        this.archiveUrl = archiveUrl == null ? null : archiveUrl.trim();
    }

    public String getArchiveFileName() {
        return archiveFileName;
    }

    public CrlDebtDtArchiveInfoDO withArchiveFileName(String archiveFileName) {
        this.setArchiveFileName(archiveFileName);
        return this;
    }

    public void setArchiveFileName(String archiveFileName) {
        this.archiveFileName = archiveFileName == null ? null : archiveFileName.trim();
    }

    public String getScene() {
        return scene;
    }

    public CrlDebtDtArchiveInfoDO withScene(String scene) {
        this.setScene(scene);
        return this;
    }

    public void setScene(String scene) {
        this.scene = scene == null ? null : scene.trim();
    }

    public String getBusinessNo() {
        return businessNo;
    }

    public CrlDebtDtArchiveInfoDO withBusinessNo(String businessNo) {
        this.setBusinessNo(businessNo);
        return this;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo == null ? null : businessNo.trim();
    }

    public String getOutsideBusinessNo() {
        return outsideBusinessNo;
    }

    public CrlDebtDtArchiveInfoDO withOutsideBusinessNo(String outsideBusinessNo) {
        this.setOutsideBusinessNo(outsideBusinessNo);
        return this;
    }

    public void setOutsideBusinessNo(String outsideBusinessNo) {
        this.outsideBusinessNo = outsideBusinessNo == null ? null : outsideBusinessNo.trim();
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public CrlDebtDtArchiveInfoDO withCreatedDate(LocalDateTime createdDate) {
        this.setCreatedDate(createdDate);
        return this;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public CrlDebtDtArchiveInfoDO withModifiedDate(LocalDateTime modifiedDate) {
        this.setModifiedDate(modifiedDate);
        return this;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tenantId=").append(tenantId);
        sb.append(", companyId=").append(companyId);
        sb.append(", productCode=").append(productCode);
        sb.append(", customerCode=").append(customerCode);
        sb.append(", userId=").append(userId);
        sb.append(", fileType=").append(fileType);
        sb.append(", archiveUrl=").append(archiveUrl);
        sb.append(", archiveFileName=").append(archiveFileName);
        sb.append(", scene=").append(scene);
        sb.append(", businessNo=").append(businessNo);
        sb.append(", outsideBusinessNo=").append(outsideBusinessNo);
        sb.append(", createdDate=").append(createdDate);
        sb.append(", modifiedDate=").append(modifiedDate);
        sb.append("]");
        return sb.toString();
    }
}