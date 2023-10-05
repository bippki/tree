import java.util.ArrayList;
import java.util.List;

class TreeFactory {
    public static List<Tree> treeList = new ArrayList<>();

    public static Tree getTree(String type) {
        for (Tree tree : treeList) {
            if (((TreeImpl) tree).type.equals(type)) {
                return tree;
            }
        }

        Tree newTree = new TreeImpl(type);
        treeList.add(newTree);
        return newTree;
    }
}
