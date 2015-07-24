package com.topshare.airshuttle.model.userManager;

import java.util.Date;
import java.util.List;


public class TAirshuttleRole {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_airshuttle_role.ID
     *
     * @mbggenerated Tue Jul 14 15:40:12 CST 2015
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_airshuttle_role.DESCRIPTION
     *
     * @mbggenerated Tue Jul 14 15:40:12 CST 2015
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_airshuttle_role.NAME
     *
     * @mbggenerated Tue Jul 14 15:40:12 CST 2015
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_airshuttle_role.CREATE_PERSON
     *
     * @mbggenerated Tue Jul 14 15:40:12 CST 2015
     */
    private Integer createPerson;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_airshuttle_role.CREATE_TIME
     *
     * @mbggenerated Tue Jul 14 15:40:12 CST 2015
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_airshuttle_role.MODIFY_PERSON
     *
     * @mbggenerated Tue Jul 14 15:40:12 CST 2015
     */
    private Integer modifyPerson;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_airshuttle_role.MODIFY_TIME
     *
     * @mbggenerated Tue Jul 14 15:40:12 CST 2015
     */
    private Date modifyTime;

    private List<TAirshuttleRoleResc> roleRescList = null;
    
    private String result;
    
    private String checked;
    
    public List<TAirshuttleRoleResc> getRoleRescList() {
		return roleRescList;
	}

	public void setRoleRescList(List<TAirshuttleRoleResc> roleRescList) {
		this.roleRescList = roleRescList;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_airshuttle_role.ID
     *
     * @return the value of t_airshuttle_role.ID
     *
     * @mbggenerated Tue Jul 14 15:40:12 CST 2015
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_airshuttle_role.ID
     *
     * @param id the value for t_airshuttle_role.ID
     *
     * @mbggenerated Tue Jul 14 15:40:12 CST 2015
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_airshuttle_role.DESCRIPTION
     *
     * @return the value of t_airshuttle_role.DESCRIPTION
     *
     * @mbggenerated Tue Jul 14 15:40:12 CST 2015
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_airshuttle_role.DESCRIPTION
     *
     * @param description the value for t_airshuttle_role.DESCRIPTION
     *
     * @mbggenerated Tue Jul 14 15:40:12 CST 2015
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_airshuttle_role.NAME
     *
     * @return the value of t_airshuttle_role.NAME
     *
     * @mbggenerated Tue Jul 14 15:40:12 CST 2015
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_airshuttle_role.NAME
     *
     * @param name the value for t_airshuttle_role.NAME
     *
     * @mbggenerated Tue Jul 14 15:40:12 CST 2015
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_airshuttle_role.CREATE_PERSON
     *
     * @return the value of t_airshuttle_role.CREATE_PERSON
     *
     * @mbggenerated Tue Jul 14 15:40:12 CST 2015
     */
    public Integer getCreatePerson() {
        return createPerson;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_airshuttle_role.CREATE_PERSON
     *
     * @param createPerson the value for t_airshuttle_role.CREATE_PERSON
     *
     * @mbggenerated Tue Jul 14 15:40:12 CST 2015
     */
    public void setCreatePerson(Integer createPerson) {
        this.createPerson = createPerson;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_airshuttle_role.CREATE_TIME
     *
     * @return the value of t_airshuttle_role.CREATE_TIME
     *
     * @mbggenerated Tue Jul 14 15:40:12 CST 2015
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_airshuttle_role.CREATE_TIME
     *
     * @param createTime the value for t_airshuttle_role.CREATE_TIME
     *
     * @mbggenerated Tue Jul 14 15:40:12 CST 2015
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_airshuttle_role.MODIFY_PERSON
     *
     * @return the value of t_airshuttle_role.MODIFY_PERSON
     *
     * @mbggenerated Tue Jul 14 15:40:12 CST 2015
     */
    public Integer getModifyPerson() {
        return modifyPerson;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_airshuttle_role.MODIFY_PERSON
     *
     * @param modifyPerson the value for t_airshuttle_role.MODIFY_PERSON
     *
     * @mbggenerated Tue Jul 14 15:40:12 CST 2015
     */
    public void setModifyPerson(Integer modifyPerson) {
        this.modifyPerson = modifyPerson;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_airshuttle_role.MODIFY_TIME
     *
     * @return the value of t_airshuttle_role.MODIFY_TIME
     *
     * @mbggenerated Tue Jul 14 15:40:12 CST 2015
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_airshuttle_role.MODIFY_TIME
     *
     * @param modifyTime the value for t_airshuttle_role.MODIFY_TIME
     *
     * @mbggenerated Tue Jul 14 15:40:12 CST 2015
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}