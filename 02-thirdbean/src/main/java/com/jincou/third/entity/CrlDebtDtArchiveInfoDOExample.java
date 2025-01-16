package com.jincou.third.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CrlDebtDtArchiveInfoDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CrlDebtDtArchiveInfoDOExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNull() {
            addCriterion("tenant_id is null");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNotNull() {
            addCriterion("tenant_id is not null");
            return (Criteria) this;
        }

        public Criteria andTenantIdEqualTo(String value) {
            addCriterion("tenant_id =", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotEqualTo(String value) {
            addCriterion("tenant_id <>", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThan(String value) {
            addCriterion("tenant_id >", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThanOrEqualTo(String value) {
            addCriterion("tenant_id >=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThan(String value) {
            addCriterion("tenant_id <", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThanOrEqualTo(String value) {
            addCriterion("tenant_id <=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLike(String value) {
            addCriterion("tenant_id like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotLike(String value) {
            addCriterion("tenant_id not like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdIn(List<String> values) {
            addCriterion("tenant_id in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotIn(List<String> values) {
            addCriterion("tenant_id not in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdBetween(String value1, String value2) {
            addCriterion("tenant_id between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotBetween(String value1, String value2) {
            addCriterion("tenant_id not between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNull() {
            addCriterion("company_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("company_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdEqualTo(String value) {
            addCriterion("company_id =", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotEqualTo(String value) {
            addCriterion("company_id <>", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThan(String value) {
            addCriterion("company_id >", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(String value) {
            addCriterion("company_id >=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThan(String value) {
            addCriterion("company_id <", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(String value) {
            addCriterion("company_id <=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLike(String value) {
            addCriterion("company_id like", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotLike(String value) {
            addCriterion("company_id not like", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIn(List<String> values) {
            addCriterion("company_id in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotIn(List<String> values) {
            addCriterion("company_id not in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdBetween(String value1, String value2) {
            addCriterion("company_id between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotBetween(String value1, String value2) {
            addCriterion("company_id not between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andProductCodeIsNull() {
            addCriterion("product_code is null");
            return (Criteria) this;
        }

        public Criteria andProductCodeIsNotNull() {
            addCriterion("product_code is not null");
            return (Criteria) this;
        }

        public Criteria andProductCodeEqualTo(String value) {
            addCriterion("product_code =", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotEqualTo(String value) {
            addCriterion("product_code <>", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeGreaterThan(String value) {
            addCriterion("product_code >", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeGreaterThanOrEqualTo(String value) {
            addCriterion("product_code >=", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLessThan(String value) {
            addCriterion("product_code <", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLessThanOrEqualTo(String value) {
            addCriterion("product_code <=", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLike(String value) {
            addCriterion("product_code like", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotLike(String value) {
            addCriterion("product_code not like", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeIn(List<String> values) {
            addCriterion("product_code in", values, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotIn(List<String> values) {
            addCriterion("product_code not in", values, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeBetween(String value1, String value2) {
            addCriterion("product_code between", value1, value2, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotBetween(String value1, String value2) {
            addCriterion("product_code not between", value1, value2, "productCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeIsNull() {
            addCriterion("customer_code is null");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeIsNotNull() {
            addCriterion("customer_code is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeEqualTo(String value) {
            addCriterion("customer_code =", value, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeNotEqualTo(String value) {
            addCriterion("customer_code <>", value, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeGreaterThan(String value) {
            addCriterion("customer_code >", value, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeGreaterThanOrEqualTo(String value) {
            addCriterion("customer_code >=", value, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeLessThan(String value) {
            addCriterion("customer_code <", value, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeLessThanOrEqualTo(String value) {
            addCriterion("customer_code <=", value, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeLike(String value) {
            addCriterion("customer_code like", value, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeNotLike(String value) {
            addCriterion("customer_code not like", value, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeIn(List<String> values) {
            addCriterion("customer_code in", values, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeNotIn(List<String> values) {
            addCriterion("customer_code not in", values, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeBetween(String value1, String value2) {
            addCriterion("customer_code between", value1, value2, "customerCode");
            return (Criteria) this;
        }

        public Criteria andCustomerCodeNotBetween(String value1, String value2) {
            addCriterion("customer_code not between", value1, value2, "customerCode");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andFileTypeIsNull() {
            addCriterion("file_type is null");
            return (Criteria) this;
        }

        public Criteria andFileTypeIsNotNull() {
            addCriterion("file_type is not null");
            return (Criteria) this;
        }

        public Criteria andFileTypeEqualTo(String value) {
            addCriterion("file_type =", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotEqualTo(String value) {
            addCriterion("file_type <>", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeGreaterThan(String value) {
            addCriterion("file_type >", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeGreaterThanOrEqualTo(String value) {
            addCriterion("file_type >=", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLessThan(String value) {
            addCriterion("file_type <", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLessThanOrEqualTo(String value) {
            addCriterion("file_type <=", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLike(String value) {
            addCriterion("file_type like", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotLike(String value) {
            addCriterion("file_type not like", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeIn(List<String> values) {
            addCriterion("file_type in", values, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotIn(List<String> values) {
            addCriterion("file_type not in", values, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeBetween(String value1, String value2) {
            addCriterion("file_type between", value1, value2, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotBetween(String value1, String value2) {
            addCriterion("file_type not between", value1, value2, "fileType");
            return (Criteria) this;
        }

        public Criteria andArchiveUrlIsNull() {
            addCriterion("archive_url is null");
            return (Criteria) this;
        }

        public Criteria andArchiveUrlIsNotNull() {
            addCriterion("archive_url is not null");
            return (Criteria) this;
        }

        public Criteria andArchiveUrlEqualTo(String value) {
            addCriterion("archive_url =", value, "archiveUrl");
            return (Criteria) this;
        }

        public Criteria andArchiveUrlNotEqualTo(String value) {
            addCriterion("archive_url <>", value, "archiveUrl");
            return (Criteria) this;
        }

        public Criteria andArchiveUrlGreaterThan(String value) {
            addCriterion("archive_url >", value, "archiveUrl");
            return (Criteria) this;
        }

        public Criteria andArchiveUrlGreaterThanOrEqualTo(String value) {
            addCriterion("archive_url >=", value, "archiveUrl");
            return (Criteria) this;
        }

        public Criteria andArchiveUrlLessThan(String value) {
            addCriterion("archive_url <", value, "archiveUrl");
            return (Criteria) this;
        }

        public Criteria andArchiveUrlLessThanOrEqualTo(String value) {
            addCriterion("archive_url <=", value, "archiveUrl");
            return (Criteria) this;
        }

        public Criteria andArchiveUrlLike(String value) {
            addCriterion("archive_url like", value, "archiveUrl");
            return (Criteria) this;
        }

        public Criteria andArchiveUrlNotLike(String value) {
            addCriterion("archive_url not like", value, "archiveUrl");
            return (Criteria) this;
        }

        public Criteria andArchiveUrlIn(List<String> values) {
            addCriterion("archive_url in", values, "archiveUrl");
            return (Criteria) this;
        }

        public Criteria andArchiveUrlNotIn(List<String> values) {
            addCriterion("archive_url not in", values, "archiveUrl");
            return (Criteria) this;
        }

        public Criteria andArchiveUrlBetween(String value1, String value2) {
            addCriterion("archive_url between", value1, value2, "archiveUrl");
            return (Criteria) this;
        }

        public Criteria andArchiveUrlNotBetween(String value1, String value2) {
            addCriterion("archive_url not between", value1, value2, "archiveUrl");
            return (Criteria) this;
        }

        public Criteria andArchiveFileNameIsNull() {
            addCriterion("archive_file_name is null");
            return (Criteria) this;
        }

        public Criteria andArchiveFileNameIsNotNull() {
            addCriterion("archive_file_name is not null");
            return (Criteria) this;
        }

        public Criteria andArchiveFileNameEqualTo(String value) {
            addCriterion("archive_file_name =", value, "archiveFileName");
            return (Criteria) this;
        }

        public Criteria andArchiveFileNameNotEqualTo(String value) {
            addCriterion("archive_file_name <>", value, "archiveFileName");
            return (Criteria) this;
        }

        public Criteria andArchiveFileNameGreaterThan(String value) {
            addCriterion("archive_file_name >", value, "archiveFileName");
            return (Criteria) this;
        }

        public Criteria andArchiveFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("archive_file_name >=", value, "archiveFileName");
            return (Criteria) this;
        }

        public Criteria andArchiveFileNameLessThan(String value) {
            addCriterion("archive_file_name <", value, "archiveFileName");
            return (Criteria) this;
        }

        public Criteria andArchiveFileNameLessThanOrEqualTo(String value) {
            addCriterion("archive_file_name <=", value, "archiveFileName");
            return (Criteria) this;
        }

        public Criteria andArchiveFileNameLike(String value) {
            addCriterion("archive_file_name like", value, "archiveFileName");
            return (Criteria) this;
        }

        public Criteria andArchiveFileNameNotLike(String value) {
            addCriterion("archive_file_name not like", value, "archiveFileName");
            return (Criteria) this;
        }

        public Criteria andArchiveFileNameIn(List<String> values) {
            addCriterion("archive_file_name in", values, "archiveFileName");
            return (Criteria) this;
        }

        public Criteria andArchiveFileNameNotIn(List<String> values) {
            addCriterion("archive_file_name not in", values, "archiveFileName");
            return (Criteria) this;
        }

        public Criteria andArchiveFileNameBetween(String value1, String value2) {
            addCriterion("archive_file_name between", value1, value2, "archiveFileName");
            return (Criteria) this;
        }

        public Criteria andArchiveFileNameNotBetween(String value1, String value2) {
            addCriterion("archive_file_name not between", value1, value2, "archiveFileName");
            return (Criteria) this;
        }

        public Criteria andSceneIsNull() {
            addCriterion("scene is null");
            return (Criteria) this;
        }

        public Criteria andSceneIsNotNull() {
            addCriterion("scene is not null");
            return (Criteria) this;
        }

        public Criteria andSceneEqualTo(String value) {
            addCriterion("scene =", value, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneNotEqualTo(String value) {
            addCriterion("scene <>", value, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneGreaterThan(String value) {
            addCriterion("scene >", value, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneGreaterThanOrEqualTo(String value) {
            addCriterion("scene >=", value, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneLessThan(String value) {
            addCriterion("scene <", value, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneLessThanOrEqualTo(String value) {
            addCriterion("scene <=", value, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneLike(String value) {
            addCriterion("scene like", value, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneNotLike(String value) {
            addCriterion("scene not like", value, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneIn(List<String> values) {
            addCriterion("scene in", values, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneNotIn(List<String> values) {
            addCriterion("scene not in", values, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneBetween(String value1, String value2) {
            addCriterion("scene between", value1, value2, "scene");
            return (Criteria) this;
        }

        public Criteria andSceneNotBetween(String value1, String value2) {
            addCriterion("scene not between", value1, value2, "scene");
            return (Criteria) this;
        }

        public Criteria andBusinessNoIsNull() {
            addCriterion("business_no is null");
            return (Criteria) this;
        }

        public Criteria andBusinessNoIsNotNull() {
            addCriterion("business_no is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessNoEqualTo(String value) {
            addCriterion("business_no =", value, "businessNo");
            return (Criteria) this;
        }

        public Criteria andBusinessNoNotEqualTo(String value) {
            addCriterion("business_no <>", value, "businessNo");
            return (Criteria) this;
        }

        public Criteria andBusinessNoGreaterThan(String value) {
            addCriterion("business_no >", value, "businessNo");
            return (Criteria) this;
        }

        public Criteria andBusinessNoGreaterThanOrEqualTo(String value) {
            addCriterion("business_no >=", value, "businessNo");
            return (Criteria) this;
        }

        public Criteria andBusinessNoLessThan(String value) {
            addCriterion("business_no <", value, "businessNo");
            return (Criteria) this;
        }

        public Criteria andBusinessNoLessThanOrEqualTo(String value) {
            addCriterion("business_no <=", value, "businessNo");
            return (Criteria) this;
        }

        public Criteria andBusinessNoLike(String value) {
            addCriterion("business_no like", value, "businessNo");
            return (Criteria) this;
        }

        public Criteria andBusinessNoNotLike(String value) {
            addCriterion("business_no not like", value, "businessNo");
            return (Criteria) this;
        }

        public Criteria andBusinessNoIn(List<String> values) {
            addCriterion("business_no in", values, "businessNo");
            return (Criteria) this;
        }

        public Criteria andBusinessNoNotIn(List<String> values) {
            addCriterion("business_no not in", values, "businessNo");
            return (Criteria) this;
        }

        public Criteria andBusinessNoBetween(String value1, String value2) {
            addCriterion("business_no between", value1, value2, "businessNo");
            return (Criteria) this;
        }

        public Criteria andBusinessNoNotBetween(String value1, String value2) {
            addCriterion("business_no not between", value1, value2, "businessNo");
            return (Criteria) this;
        }

        public Criteria andOutsideBusinessNoIsNull() {
            addCriterion("outside_business_no is null");
            return (Criteria) this;
        }

        public Criteria andOutsideBusinessNoIsNotNull() {
            addCriterion("outside_business_no is not null");
            return (Criteria) this;
        }

        public Criteria andOutsideBusinessNoEqualTo(String value) {
            addCriterion("outside_business_no =", value, "outsideBusinessNo");
            return (Criteria) this;
        }

        public Criteria andOutsideBusinessNoNotEqualTo(String value) {
            addCriterion("outside_business_no <>", value, "outsideBusinessNo");
            return (Criteria) this;
        }

        public Criteria andOutsideBusinessNoGreaterThan(String value) {
            addCriterion("outside_business_no >", value, "outsideBusinessNo");
            return (Criteria) this;
        }

        public Criteria andOutsideBusinessNoGreaterThanOrEqualTo(String value) {
            addCriterion("outside_business_no >=", value, "outsideBusinessNo");
            return (Criteria) this;
        }

        public Criteria andOutsideBusinessNoLessThan(String value) {
            addCriterion("outside_business_no <", value, "outsideBusinessNo");
            return (Criteria) this;
        }

        public Criteria andOutsideBusinessNoLessThanOrEqualTo(String value) {
            addCriterion("outside_business_no <=", value, "outsideBusinessNo");
            return (Criteria) this;
        }

        public Criteria andOutsideBusinessNoLike(String value) {
            addCriterion("outside_business_no like", value, "outsideBusinessNo");
            return (Criteria) this;
        }

        public Criteria andOutsideBusinessNoNotLike(String value) {
            addCriterion("outside_business_no not like", value, "outsideBusinessNo");
            return (Criteria) this;
        }

        public Criteria andOutsideBusinessNoIn(List<String> values) {
            addCriterion("outside_business_no in", values, "outsideBusinessNo");
            return (Criteria) this;
        }

        public Criteria andOutsideBusinessNoNotIn(List<String> values) {
            addCriterion("outside_business_no not in", values, "outsideBusinessNo");
            return (Criteria) this;
        }

        public Criteria andOutsideBusinessNoBetween(String value1, String value2) {
            addCriterion("outside_business_no between", value1, value2, "outsideBusinessNo");
            return (Criteria) this;
        }

        public Criteria andOutsideBusinessNoNotBetween(String value1, String value2) {
            addCriterion("outside_business_no not between", value1, value2, "outsideBusinessNo");
            return (Criteria) this;
        }

        public Criteria andCreatedDateIsNull() {
            addCriterion("created_date is null");
            return (Criteria) this;
        }

        public Criteria andCreatedDateIsNotNull() {
            addCriterion("created_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedDateEqualTo(LocalDateTime value) {
            addCriterion("created_date =", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateNotEqualTo(LocalDateTime value) {
            addCriterion("created_date <>", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateGreaterThan(LocalDateTime value) {
            addCriterion("created_date >", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("created_date >=", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateLessThan(LocalDateTime value) {
            addCriterion("created_date <", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("created_date <=", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateIn(List<LocalDateTime> values) {
            addCriterion("created_date in", values, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateNotIn(List<LocalDateTime> values) {
            addCriterion("created_date not in", values, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("created_date between", value1, value2, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("created_date not between", value1, value2, "createdDate");
            return (Criteria) this;
        }

        public Criteria andModifiedDateIsNull() {
            addCriterion("modified_date is null");
            return (Criteria) this;
        }

        public Criteria andModifiedDateIsNotNull() {
            addCriterion("modified_date is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedDateEqualTo(LocalDateTime value) {
            addCriterion("modified_date =", value, "modifiedDate");
            return (Criteria) this;
        }

        public Criteria andModifiedDateNotEqualTo(LocalDateTime value) {
            addCriterion("modified_date <>", value, "modifiedDate");
            return (Criteria) this;
        }

        public Criteria andModifiedDateGreaterThan(LocalDateTime value) {
            addCriterion("modified_date >", value, "modifiedDate");
            return (Criteria) this;
        }

        public Criteria andModifiedDateGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("modified_date >=", value, "modifiedDate");
            return (Criteria) this;
        }

        public Criteria andModifiedDateLessThan(LocalDateTime value) {
            addCriterion("modified_date <", value, "modifiedDate");
            return (Criteria) this;
        }

        public Criteria andModifiedDateLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("modified_date <=", value, "modifiedDate");
            return (Criteria) this;
        }

        public Criteria andModifiedDateIn(List<LocalDateTime> values) {
            addCriterion("modified_date in", values, "modifiedDate");
            return (Criteria) this;
        }

        public Criteria andModifiedDateNotIn(List<LocalDateTime> values) {
            addCriterion("modified_date not in", values, "modifiedDate");
            return (Criteria) this;
        }

        public Criteria andModifiedDateBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("modified_date between", value1, value2, "modifiedDate");
            return (Criteria) this;
        }

        public Criteria andModifiedDateNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("modified_date not between", value1, value2, "modifiedDate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}