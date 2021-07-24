package preperationExamples;

import java.util.ArrayList;
import java.util.HashSet;

public class RunInherit {

    public static Roots findRoots(double a, double b, double c) {
        double root1=(-b+Math.sqrt(Math.pow(b, 2)-4*a*c))/(2*a);
        double root2=(-b-Math.sqrt(Math.pow(b, 2)-4*a*c))/(2*a);
        return new Roots(root1,root2);
    }
    
    public static void main(String[] args) {
        Roots roots = RunInherit.findRoots(2, 10,8);
        System.out.println("Roots: " + roots.x1 + ", " + roots.x2);
    }
}

class Roots {
    public final double x1, x2;

    public Roots(double x1, double x2) {         
        this.x1 = x1;
        this.x2 = x2;
    }
}
