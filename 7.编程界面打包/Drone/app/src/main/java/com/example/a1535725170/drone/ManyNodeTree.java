package com.example.a1535725170.drone;

/**
 * Created by 1535725170 on 2018/1/19.
 */

public class ManyNodeTree {
    private ManyTreeNode root;

    private ManyTreeNode tmp;

    private int floor;

    public ManyNodeTree(){
        root = new ManyTreeNode("root");
        tmp = root;
        floor=0;
    }

    public ManyTreeNode getRoot(){
        return this.root;
    }

    public void addChild(ManyTreeNode manyTreeNode){
        this.tmp.addChild(manyTreeNode);
    }

    public void deleteChild(int n){
        this.tmp.getChildList().remove(n);
    }

    public void beChild(int n){
        if(tmp.getChildList()!=null && tmp.getChildList().size()>n){
            ManyTreeNode newNode = this.tmp.getChildList().get(n);
            tmp = newNode;
            floor = floor + 1;
        }
    }

    public void beParent(){
        if(tmp.getText()!="root"){
            ManyTreeNode newNode = tmp.getParentNode();
            tmp = newNode;
            floor = floor - 1;
        }
    }

    public String iteratorTree(ManyTreeNode manyTreeNode){
        StringBuilder buffer = new StringBuilder();
        buffer.append("\n");
        if(manyTreeNode!=null){
            for(ManyTreeNode index : manyTreeNode.getChildList()){
                buffer.append(index.getText()+",");
                if(index.getChildList()!=null && index.getChildList().size()>0){
                    buffer.append(iteratorTree(index));
                }
            }
        }
        buffer.append("\n");
        return buffer.toString();
    }

}
