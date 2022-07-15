/**
 * A very basic class for pretty printing, not intended to be instantiated.
 */
public class PrettyPrint {
    /**
     * A simple Node class to demonstrate a very basic case of pretty printing.
     */  
    public static class Node {
        /** The value of this node.  Assumes the dynamic type has a nice <tt>toString()</tt>.*/
        public Object value = null;

        /**
         * The potential children.  If both are <tt>null</tt>, this is a 'terminal' node.  If
         * index 0 has a value but not index 1, this is a unary operator.  If index 1 has a
         * value, but not index 0, this is a post-fix operator node.  If both indices have
         * values, this is a binary operator.
         *
         * There are many other ways this can be represented, this is just one.  In particular,
         * the storage strategy would necessarily change if you wanted to support say pre-fix
         * operators, or really, anything more than 4 possible states.  This may or may not
         * have been done intentionally ;)
         */
        public Node[] children = new Node[2];

        /**
         * Initializes this node to have the given value and children.
         *
         * @param value
         *     The symbolic value of this node.  Assumes the dynamic type
         *     has a human-friendly <b>toString()</b> method.
         *
         * @param child_0
         *     If this is a terminal node, it should be <b>null</b>.  If this is
         *     a unary operator node, it should be the only child.  If this is a
         *     post-fix operator, it should be <b>null</b>.  If this is a binary
         *     operator node, it should be the left child.
         *
         * @param child_1
         *     If this is a terminal node, it should be <b>null</b>.  If this is
         *     a unary operator node, it should be <b>null</b>.  If this is a
         *     post-fix operator, it should be the only child.  If this is a
         *     binary operator node, it should be the right child.
         *
         * @throws RuntimeException
         *     If the parameter <b>value</b> is <b>null</b>, an exception will
         *     be thrown.
         */
        public Node(Object value, Node child_0, Node child_1) {
            if(value == null)
                throw new RuntimeException("The value parameter may not be null");
            this.value = value;
            children[0] = child_0;
            children[1] = child_1;
        }

        /**
         * Whether or not this node is a terminal node.
         *
         * @return
         *     True if this node is a terminal, false otherwise.
         */
        public boolean isTerminal() {
            return children[0] == null && children[1] == null;
        }

        /**
         * Whether or not this node is a unary operator node.
         *
         * @return
         *     True if this node is a unary operator, false otherwise.
         */
        public boolean isUnaryOp() {
            return children[0] != null && children[1] == null;
        }

        /**
         * Whether or not this node is a post-fix operator.
         *
         * @return
         *     True if this node is a post-fix operator, false otherwise.
         */
        public boolean isPostFixOp() {
            return children[0] == null && children[1] != null;
        }

        /**
         * Whether or not this node is a binary operator node.
         *
         * @return
         *     True if this node is a binary operator, false otherwise.
         */
        public boolean isBinaryOp() {
            return children[0] != null && children[1] != null;
        }

        /**
         * Simple override for convenience, assumes <tt>value</tt> has
         * a meaningful <tt>toString()</tt> implementation.
         *
         * @return
         *     The return value of <b>this.value.toString()</b>.
         */
        public String toString() {
            return value.toString();
        }
    }// end class Node

    /**
     * A recursive pretty printing algorithm to print the correct
     * parenthetical grouping of nodes. 
     *
     * @param n
     *     The node to print next.
     */  
    public static void prettyPrint(Node n) {
        // terminal nodes just get printed
        if(n.isTerminal()) {
            System.out.print(n);
        }
        // print the unary op followed by its only child
        else if(n.isUnaryOp()) {
            System.out.print(n);
            prettyPrint(n.children[0]);
        }
        // post-fix operators get printed after their only child
        else if(n.isPostFixOp()) {
            prettyPrint(n.children[1]);
            System.out.print(n);
        }
        // binary operators, print the left child first, the op, then right
        else if(n.isBinaryOp()) {
            System.out.print("(");
            prettyPrint(n.children[0]);
            System.out.print(" " + n + " ");
            prettyPrint(n.children[1]);
            System.out.print(")");
        }
    }

    /**
     * A simple example of how to construct an AST and print it out.
     *
     * @param args Unused.
     */  
    public static void main(String[] args) {
        // form the first example in the notes, starting with the terminals
        Node three = new Node(3, null, null);
        Node four  = new Node(4, null, null);
        Node five  = new Node(5, null, null);
        // form the binary operators, times will be the root
        Node plus  = new Node("+", three, five);
        Node times = new Node("*", plus, four);
        // print the first example
        System.out.print("Printing the AST\n" +
                         "        *\n"        +
                         "      /   \\\n"     +
                         "     +     4\n"     +
                         "    / \\\n"         +
                         "   3   5\n\n"       );
        prettyPrint(times);
        System.out.print("\n");
        System.out.println("-----------------------------------");

        // form the second example in the notes
        Node thirty_two = new Node(32, null, null);
        Node two        = new Node( 2, null, null);
        // form the divide binary operator
        Node divide     = new Node("/", thirty_two, two);
        // reconfigure times for this example (set right child to divide)
        times.children[1] = divide;
        // form the negation at the root of the tree
        Node negative = new Node("-", times, null);
        // print the second example
        System.out.print("Printing the AST\n" +
                         "        -\n"        +
                         "        |\n"        +
                         "        *\n"        +
                         "      /   \\\n"     +
                         "     +     /\n"     +
                         "    / \\   / \\\n"  +
                         "   3   5 32  2\n\n" );
        prettyPrint(negative);
        System.out.print("\n"); 
        System.out.println("-----------------------------------");

        // form the third example in the notes
        Node a = new Node("a", null, null);
        Node b = new Node("b", null, null);

        Node bottom_star = new Node("*", null, b);
        Node lowest_tree = new Node(".", a, bottom_star);
        Node concat_lowest_tree_a = new Node(".", lowest_tree, a);
        Node middle_star = new Node("*", null, concat_lowest_tree_a);
        Node concat_b_middle_star = new Node(".", b, middle_star);
        Node concat_concat_b_middle_star_b = new Node(".", concat_b_middle_star, b);
        Node or = new Node("+", a, concat_concat_b_middle_star_b);
        Node root_star = new Node("*", null, or);
        System.out.print("Printing the AST\n" +
                         "     *\n"           +
                         "     |\n"           +
                         "     +\n"           +
                         "    / \\\n"         +
                         "   /   \\\n"        +
                         "  a     .\n"        +
                         "       / \\\n"      +
                         "      /   \\\n"     +
                         "     .     b\n"     +
                         "    / \\\n"         +
                         "   b   *\n"         +
                         "       |\n"         +
                         "       .\n"         +
                         "      / \\\n"       +
                         "     /   \\\n"      +
                         "    .     a\n"      +
                         "   / \\\n"          +
                         "  a   *\n"          +
                         "      |\n"          +
                         "      b\n\n"        );
        prettyPrint(root_star);
        System.out.print("\n");
    }
}
