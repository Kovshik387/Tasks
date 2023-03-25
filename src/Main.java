import Labs.Task8.*;
public class Main {
    public static void main(String[] args) throws Exception {
        String test = "(a, b, (c), d)";
        String superTest = "(a, second, (abc, y, (x, 7), uuu, (8, 9, (10, 1)), abcddcdba))";
        String normalTest = "(a,b,dfff, (g,f,q,w,e,(1,2,3)),end)";
        String uberTest = "(a, second, (abc, y, (x, 7), uuu, (8, 9, (10, 1, e, (start, 2, end,(startb, f, f))), 3, (start,d)), abcddcdba))";

        var start = new TreeNode(superTest);

        start.printThree();
    }
}