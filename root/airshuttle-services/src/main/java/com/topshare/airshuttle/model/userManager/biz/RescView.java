package com.topshare.airshuttle.model.userManager.biz;

import java.util.Date;

public class RescView {
	/**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column T_AIRSHUTTLE_RESC.ID
     *
     * @ibatorgenerated Wed Jul 16 21:59:07 CST 2014
     */
    private String id;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column T_AIRSHUTTLE_RESC.DESCRIPTION
     *
     * @ibatorgenerated Wed Jul 16 21:59:07 CST 2014
     */
    private String description;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column T_AIRSHUTTLE_RESC.NAME
     *
     * @ibatorgenerated Wed Jul 16 21:59:07 CST 2014
     */
    private String name;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column T_AIRSHUTTLE_RESC.PARENT_ID
     *
     * @ibatorgenerated Wed Jul 16 21:59:07 CST 2014
     */
    private String _parentId;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column T_AIRSHUTTLE_RESC.NODE_ORDER
     *
     * @ibatorgenerated Wed Jul 16 21:59:07 CST 2014
     */
    private Integer nodeOrder;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column T_AIRSHUTTLE_RESC.CREATE_PERSON
     *
     * @ibatorgenerated Wed Jul 16 21:59:07 CST 2014
     */
    private String createPerson;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column T_AIRSHUTTLE_RESC.CREATE_TIME
     *
     * @ibatorgenerated Wed Jul 16 21:59:07 CST 2014
     */
    private Date createTime;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column T_AIRSHUTTLE_RESC.MODIFY_PERSON
     *
     * @ibatorgenerated Wed Jul 16 21:59:07 CST 2014
     */
    private String modifyPerson;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column T_AIRSHUTTLE_RESC.MODIFY_TIME
     *
     * @ibatorgenerated Wed Jul 16 21:59:07 CST 2014
     */
    private Date modifyTime;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column T_AIRSHUTTLE_RESC.URI
     *
     * @ibatorgenerated Wed Jul 16 21:59:07 CST 2014
     */
    private String uri;

    private String result;
    
    private String checked;
    
    private String uriCustomer;
    
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_airshuttle_resc.BELONG
     *
     * @mbggenerated Tue Jul 14 15:44:40 CST 2015
     */
    private Integer belong;
    
    public Integer getBelong() {
		return belong;
	}

	public void setBelong(Integer belong) {
		this.belong = belong;
	}

	public String getUriCustomer() {
		return uriCustomer;
	}

	public void setUriCustomer(String uriCustomer) {
		this.uriCustomer = uriCustomer;
	}
	
    public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column T_AIRSHUTTLE_RESC.ID
     *
     * @return the value of T_AIRSHUTTLE_RESC.ID
     *
     * @ibatorgenerated Wed Jul 16 21:59:07 CST 2014
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column T_AIRSHUTTLE_RESC.ID
     *
     * @param id the value for T_AIRSHUTTLE_RESC.ID
     *
     * @ibatorgenerated Wed Jul 16 21:59:07 CST 2014
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column T_AIRSHUTTLE_RESC.DESCRIPTION
     *
     * @return the value of T_AIRSHUTTLE_RESC.DESCRIPTION
     *
     * @ibatorgenerated Wed Jul 16 21:59:07 CST 2014
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column T_AIRSHUTTLE_RESC.DESCRIPTION
     *
     * @param description the value for T_AIRSHUTTLE_RESC.DESCRIPTION
     *
     * @ibatorgenerated Wed Jul 16 21:59:07 CST 2014
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column T_AIRSHUTTLE_RESC.NAME
     *
     * @return the value of T_AIRSHUTTLE_RESC.NAME
     *
     * @ibatorgenerated Wed Jul 16 21:59:07 CST 2014
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column T_AIRSHUTTLE_RESC.NAME
     *
     * @param name the value for T_AIRSHUTTLE_RESC.NAME
     *
     * @ibatorgenerated Wed Jul 16 21:59:07 CST 2014
     */
    public void setName(String name) {
        this.name = name;
    }

    public String get_parentId() {
		return _parentId;
	}

	public void set_parentId(String _parentId) {
		this._parentId = _parentId;
	}

	/**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column T_AIRSHUTTLE_RESC.NODE_ORDER
     *
     * @return the value of T_AIRSHUTTLE_RESC.NODE_ORDER
     *
     * @ibatorgenerated Wed Jul 16 21:59:07 CST 2014
     */
    public Integer getNodeOrder() {
        return nodeOrder;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column T_AIRSHUTTLE_RESC.NODE_ORDER
     *
     * @param nodeOrder the value for T_AIRSHUTTLE_RESC.NODE_ORDER
     *
     * @ibatorgenerated Wed Jul 16 21:59:07 CST 2014
     */
    public void setNodeOrder(Integer nodeOrder) {
        this.nodeOrder = nodeOrder;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column T_AIRSHUTTLE_RESC.CREATE_PERSON
     *
     * @return the value of T_AIRSHUTTLE_RESC.CREATE_PERSON
     *
     * @ibatorgenerated Wed Jul 16 21:59:07 CST 2014
     */
    public String getCreatePerson() {
        return createPerson;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column T_AIRSHUTTLE_RESC.CREATE_PERSON
     *
     * @param createPerson the value for T_AIRSHUTTLE_RESC.CREATE_PERSON
     *
     * @ibatorgenerated Wed Jul 16 21:59:07 CST 2014
     */
    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column T_AIRSHUTTLE_RESC.CREATE_TIME
     *
     * @return the value of T_AIRSHUTTLE_RESC.CREATE_TIME
     *
     * @ibatorgenerated Wed Jul 16 21:59:07 CST 2014
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column T_AIRSHUTTLE_RESC.CREATE_TIME
     *
     * @param createTime the value for T_AIRSHUTTLE_RESC.CREATE_TIME
     *
     * @ibatorgenerated Wed Jul 16 21:59:07 CST 2014
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column T_AIRSHUTTLE_RESC.MODIFY_PERSON
     *
     * @return the value of T_AIRSHUTTLE_RESC.MODIFY_PERSON
     *
     * @ibatorgenerated Wed Jul 16 21:59:07 CST 2014
     */
    public String getModifyPerson() {
        return modifyPerson;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column T_AIRSHUTTLE_RESC.MODIFY_PERSON
     *
     * @param modifyPerson the value for T_AIRSHUTTLE_RESC.MODIFY_PERSON
     *
     * @ibatorgenerated Wed Jul 16 21:59:07 CST 2014
     */
    public void setModifyPerson(String modifyPerson) {
        this.modifyPerson = modifyPerson;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column T_AIRSHUTTLE_RESC.MODIFY_TIME
     *
     * @return the value of T_AIRSHUTTLE_RESC.MODIFY_TIME
     *
     * @ibatorgenerated Wed Jul 16 21:59:07 CST 2014
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column T_AIRSHUTTLE_RESC.MODIFY_TIME
     *
     * @param modifyTime the value for T_AIRSHUTTLE_RESC.MODIFY_TIME
     *
     * @ibatorgenerated Wed Jul 16 21:59:07 CST 2014
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column T_AIRSHUTTLE_RESC.URI
     *
     * @return the value of T_AIRSHUTTLE_RESC.URI
     *
     * @ibatorgenerated Wed Jul 16 21:59:07 CST 2014
     */
    public String getUri() {
        return uri;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column T_AIRSHUTTLE_RESC.URI
     *
     * @param uri the value for T_AIRSHUTTLE_RESC.URI
     *
     * @ibatorgenerated Wed Jul 16 21:59:07 CST 2014
     */
    public void setUri(String uri) {
        this.uri = uri;
    }
}