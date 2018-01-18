package com.example.a1535725170.javatree;

/**
 * Created by 1535725170 on 2018/1/17.
 */

public class TreeNode {
    //节点的id
    private String nodeId;

    //父节点的id
    private String parentId;

    //节点的内容
    private String text;

    //构造函数
    public TreeNode(String nodeId){
        this.nodeId = nodeId;
    }

    //构造函数
    public TreeNode(String nodeId,String parentId){
        this.nodeId = nodeId;
        this.parentId = parentId;
    }

    //设置节点的id
    public void setNodeId(String nodeId){
        this.nodeId = nodeId;
    }

    //得到节点的id
    public String getNodeId(){
        return nodeId;
    }

    //设置父节点的id
    public void setParentId(String parentId){
        this.parentId = parentId;
    }

    //得到父节点的id
    public String getParentId(){
        return parentId;
    }

    //设置节点的text
    public void setText(String text){
        this.text = text;
    }

    //得到节点的text
    public String getText(){
        return text;
    }

}