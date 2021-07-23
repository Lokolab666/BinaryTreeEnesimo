package model;

import java.util.LinkedList;
import java.util.List;

public class TreeNode <T>{
    private T info;
    private LinkedList<TreeNode<T>> sons;

    public TreeNode(T info) {
        this.info = info;
        sons = new LinkedList<>();
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public LinkedList<TreeNode<T>> getSons() {
        return sons;
    }

}
