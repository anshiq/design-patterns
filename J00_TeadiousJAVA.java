public class J00_TeadiousJAVA {
    public static void main(String[] arg) {
        String k = new String("ab"); // points at newly allocated object memory.
        String p = new String("ab"); // points at newly allocated object memory.
        System.out.println(p == k); // false
        String l = "ll"; // point at an address of string pool
        String m = new String("ll"); // points at newly allocated object memory.
        System.out.println(l == m); // false
        String g = "lb"; // both point same memory location in string pool
        String h = "lb";
        System.out.println(g == h); // true

        System.out.println(System.identityHashCode(h));
        System.out.println(System.identityHashCode(g));
        System.out.println(System.identityHashCode(m));
        System.out.println(System.identityHashCode(l));
        System.out.println(System.identityHashCode(p));
        System.out.println(System.identityHashCode(k));

    }

}
