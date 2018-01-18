package com.example.a1535725170.javatree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1535725170 on 2018/1/18.
 */

public class ManyTreeNode {

    //树节点的信息
    private TreeNode data;

    //子节点集合
    private List<ManyTreeNode> childList;

    //to bo used
    private ManyTreeNode parentNode;

    //构造函数
    public ManyTreeNode(TreeNode data){
        this.data=data;
        this.childList = new ArrayList<ManyTreeNode>();
    }

    //构造函数
    public ManyTreeNode(TreeNode data,List<ManyTreeNode>childList){
        this.data=data;
        this.childList=childList;
    }

    //得到该节点的信息
    public TreeNode getData(){
        return data;
    }

    //得到该节点的子节点集合
    public List<ManyTreeNode>getChildList(){
        return childList;
    }

    //设置该节点的子节点集合
    public void setChildList(List<ManyTreeNode>childList) {
        this.childList = childList;
    }

    //设置该节点的信息中的节点id
    public void setDataId(String newId){
        this.data.setNodeId(newId);
    }

    //设置父节点
    public void setParentNode(ManyTreeNode parentNode){
        this.parentNode=parentNode;
    }

    public ManyTreeNode getParentNode(){
        return parentNode;
    }

}
