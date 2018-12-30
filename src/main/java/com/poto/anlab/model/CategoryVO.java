package com.poto.anlab.model;

import java.util.List;

public class CategoryVO {
    private int id;
    private String cnName;
    private String enName;
    private String nodeId;
    private String parentNode;
    private int nodeLevel;
    private List<CategoryVO> subCategoryVOList;

    public CategoryVO() {
    }

    public CategoryVO(int id, String cnName, String enName, int nodeLevel, String nodeId, String parentNode) {
        this.id = id;
        this.cnName = cnName;
        this.enName = enName;
        this.nodeLevel = nodeLevel;
        this.nodeId = nodeId;
        this.parentNode = parentNode;
    }

    public List<CategoryVO> getSubCategoryVOList() {
        return subCategoryVOList;
    }

    public void setSubCategoryVOList(List<CategoryVO> subCategoryVOList) {
        this.subCategoryVOList = subCategoryVOList;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getParentNode() {
        return parentNode;
    }

    public void setParentNode(String parentNode) {
        this.parentNode = parentNode;
    }

    public int getNodeLevel() {
        return nodeLevel;
    }

    public void setNodeLevel(int nodeLevel) {
        this.nodeLevel = nodeLevel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }
}
