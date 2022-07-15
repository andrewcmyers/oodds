Node parseS() {
    if (peek().isIdentifier()) {
        return new Id(nextToken());
    } else if (peek().equals("(")) {
        consumeToken("(");
        List<Node> children = parseL();
        consumeToken(")");
        return new App(children);
    }
}

List<Node> parseL() {
    List<Node> nodes = new LinkedList<Node>();
    while (!peek().equals(")"))
        nodes.append(parseS());
    return nodes;
}
