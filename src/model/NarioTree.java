package model;

import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;

public class NarioTree<T> {
    private TreeNode<T> root;
    private Comparator<T> comparator;

    public NarioTree(Comparator<T> comparator) {
        this.comparator = comparator;
        root = null;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void addNodeFirst( TreeNode<T> father, T info ){
        TreeNode<T> newNode = new TreeNode<>(info);
        if ( isEmpty() ){
            root = newNode;
        }
        else {
            father.getSons().addFirst(newNode);
        }

    }

    public void addNodeLast( TreeNode<T> father, T info ){
        TreeNode<T> newNode = new TreeNode<>(info);
        if ( isEmpty() ){
            root = newNode;
        }
        else {
            father.getSons().addLast(newNode);
        }

    }


    public TreeNode<T> findNode( T info ){
        return find( root, info );
    }

    private TreeNode<T> find(TreeNode<T> node, T info){
        if ( node != null ){
            if ( comparator.compare( node.getInfo(), info ) == 0 ){
                return node;
            }
            for ( TreeNode<T> son : node.getSons() ){
                if ( find(son, info) != null ){
                    return find(son, info);
                }
            }
            return null;
                }
        return null;
    }

    public ArrayList<T> printTree(){
        ArrayList<T> out = new ArrayList<>();
        ArrayDeque<TreeNode> tailAux = new ArrayDeque<>();
        tailAux.offer(root);
        TreeNode<T> aux =null;
        while ( !tailAux.isEmpty() ){
            int len = tailAux.size();
            for (int i = 0; i < len; i++){
                TreeNode node = tailAux.poll();
                assert node != null;
                aux = node;

            }
            out.add(aux.getInfo());
        }
        return out;
    }
}
