package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NarioTreeTest {
    private NarioTree<Integer> tree;

    private void setUp(){
        tree = new NarioTree< >( (val1, val2) -> Integer.compare( val1, val2 ) );
        tree.addNodeFirst(null, 56);
        tree.addNodeFirst(tree.findNode(56), 34 );
        tree.addNodeFirst(tree.findNode(56), 98 );
        tree.addNodeFirst(tree.findNode(56), 29 );

        tree.addNodeLast(tree.findNode(98), 134);
        tree.addNodeLast(tree.findNode(134), 27);
        tree.addNodeLast(tree.findNode(134), 32);
        tree.addNodeLast(tree.findNode(134), 87);
        tree.addNodeLast(tree.findNode(134), 16);
    }

    @Test
    void addNodeFirst() {
    }

    @Test
    void addNodeLast() {
    }

    @Test
    void findNode() {
        setUp();
        assertNotNull( tree.findNode(56));
        assertEquals(56, tree.findNode(56).getInfo());
        assertNotNull(tree.findNode(98));
        assertNotNull(tree.findNode(34));
        assertEquals(34, tree.findNode(34).getInfo());
        assertEquals(29, tree.findNode(29).getInfo());
        assertNotNull(tree.findNode(29));
        assertNotNull(tree.findNode(134));
        assertNotNull(tree.findNode(27));
        assertNotNull(tree.findNode(16));
        assertEquals(16, tree.findNode(16).getInfo());


    }

    @Test
    void printTree() {
        setUp();
        tree.printTree().forEach((num) -> System.out.println(num + "\t"));
    }
}