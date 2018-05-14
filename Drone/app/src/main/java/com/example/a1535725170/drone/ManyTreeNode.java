package com.example.a1535725170.drone;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by 1535725170 on 2018/1/19.
 */

public class ManyTreeNode {

    private String text;

    private ManyTreeNode parentNode;

    private List<ManyTreeNode> childList;

    private int floor;

    private Object pic;

    private String kind;

    private boolean hasBeenBuild;

    private String attribution;

    private String radio;

    public ManyTreeNode(String text){
        this.text=text;
        this.childList= new ArrayList<ManyTreeNode>();
        this.pic = R.mipmap.ic_launcher_round;
        this.kind = "not_a_condition";
        this.hasBeenBuild = false ;
        this.attribution = null;
        this.radio = null;
    }

    public void reset(){
        this.text="请点击输入";
        this.childList= new ArrayList<ManyTreeNode>();
        this.pic = R.mipmap.ic_launcher_round;
        this.kind = "not_a_condition";
        this.hasBeenBuild = false ;
        this.attribution = null;
        this.radio = null;
    }

    public void setRadio(String radio){this.radio = radio;}

    public String getRadio(){return radio;}

    public void setAttribution(String text){this.attribution = text;}

    public String getAttribution(){ return attribution;}

    public void setText(String text){
        this.text=text;
    }

    public String getText(){
        return text;
    }

    public Object getPic(){return pic;}

    public void setPic(Object pic){
        this.pic = pic;
    }

    public boolean getHasBeenBuild(){
        return hasBeenBuild;
    }

    public void setHasBeenBuild(boolean hasBeenBuild) {
        this.hasBeenBuild = hasBeenBuild;
    }

    public String getKind(){return kind;}

    public void setKind(String kind){
        this.kind = kind;
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
