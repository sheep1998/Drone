package com.example.a1535725170.drone;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1535725170 on 2018/1/19.
 */

public class ManyTreeNode {

    private String text;

    private ManyTreeNode parentNode;

    private List<ManyTreeNode> childList;

    private int floor;

    public ManyTreeNode(String text){
        this.text=text;
        this.childList= new ArrayList<ManyTreeNode>();
    }

    public void setText(String text){
        this.text=text;
    }

    public String getText(){
        return text;
    }

    public void setParentNode(ManyTreeNode parentNode){
        this.parentNode=parentNode;
    }

    public ManyTreeNode getParentNode(){
        return parentNode;
    }

    public List<ManyTreeNode> getChildList(){
        return childList;
    }

    public void addChild(ManyTreeNode child){
        this.childList.add(child);
        child.setParentNode(this);
        child.setFloor(this.getFloor()+1);
    }

    public void setFloor(int floor){
        this.floor=floor;
    }

    public int getFloor(){
        return floor;
    }

}
