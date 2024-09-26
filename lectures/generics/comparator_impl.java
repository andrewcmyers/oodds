class SCmp implements Comparator<String> {
    @Override
    public int compare(String x, String y) {
        return x.compareTo(y);
    }
}

String[] a = {"z", "Y", "x"};
sort(a, new SCmp());

