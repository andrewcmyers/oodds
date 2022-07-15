class SCmp implements Comparator<String> {
    @Override
    public int compareTo(String x, String y) {
        return x.compareTo(y);
    }
}

String[] a = {"z", "Y", "x"};
sort(a, new SCmp());

