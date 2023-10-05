
interface Tree {
    void display(int x, int y);
}

class TreeImpl implements Tree {
    public String type;

    public TreeImpl(String type) {
        this.type = type;
    }

    @Override
    public void display(int x, int y) {
        System.out.println("Отображение " + type + " дерева на координатах (" + x + ", " + y + ")");
    }
}


public class Main {
    public static void main(String[] args) {
        int numberOfTrees = 1000000000;

        long memoryBeforeWithFlyweight = getUsedMemory();

        for (int i = 0; i < numberOfTrees; i++) {
            Tree tree = TreeFactory.getTree("елка");
        }

        long memoryAfterWithFlyweight = getUsedMemory();

        TreeFactory.treeList.clear();

        long memoryBeforeWithoutFlyweight = getUsedMemory();

        for (int i = 0; i < numberOfTrees; i++) {
            Tree tree = new TreeImpl("елка");
            //System.out.println(tree);
        }

        long memoryAfterWithoutFlyweight = getUsedMemory();

        System.out.println("Затраты памяти с Flyweight: " + (memoryAfterWithFlyweight - memoryBeforeWithFlyweight) + " байт");
        System.out.println("Затраты памяти без Flyweight: " + (memoryAfterWithoutFlyweight - memoryBeforeWithoutFlyweight) + " байт");
    }

    public static long getUsedMemory() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }
}