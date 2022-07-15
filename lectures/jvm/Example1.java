class Example1 implements I1 {
    public void f(int a) {
	Example1 o = this;
	g1(o);
        boolean b = false;
        int x = 0, y = 0, z = 0;
        if (b) x = y+1;
        else x = z;
    }
     void g1(Example1 o) {
        o.f(0);
     }
     void g2(I1 o) {
        o.f(0);
     }
     private void f2(int x) {
     }
     void g3() {
        f2(0);
     }
}
