package com.example.a1535725170.javatree;

/**
 * Created by 1535725170 on 2018/1/18.
 */

public class ManyNodeTree {
    private ManyTreeNode root;

    private ManyTreeNode tmp;

    private int floor;

    public ManyNodeTree(){
        root = new ManyTreeNode(new TreeNode("root"));
        tmp = root;
        floor = 0;
    }

    public ManyTreeNode getRoot(){
        return root;
    }

    public ManyTreeNode getTmp(){
        return tmp;
    }

    public void addChild(ManyTreeNode manyTreeNode){
        this.tmp.getChildList().add(manyTreeNode);
        manyTreeNode.setParentNode(this.tmp);
    }

    public void beChild(int n){
        if(tmp.getChildList()!=null&&tmp.getChildList().size()>n) {
            ManyTreeNode newNode = this.tmp.getChildList().get(n);
            tmp = newNode;
            floor = floor + 1;
        }
    }

    public void beParent(){
        if(tmp.getData().getNodeId()!="root"){
            ManyTreeNode newNode = tmp.getParentNode();
            tmp = newNode;
            floor = floor + 1;
        }
    }

    public String iteratorTree(ManyTreeNode manyTreeNode){
        StringBuilder buffer = new StringBuilder();
        buffer.append("\n");
        if(manyTreeNode!=null){
            for(ManyTreeNode index : manyTreeNode.getChildList()){
                buffer.append(index.getData().getNodeId()+",");

                if(index.getChildList()!=null&&index.getChildList().size()>0){
                    buffer.append(iteratorTree(index));
                }
            }
        }
        buffer.append("\n");
        return buffer.toString();
    }

}
