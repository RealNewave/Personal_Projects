/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler;

/**
 *
 * @author Hans
 */
public class Opdracht10 {

    public static void main(String[] args) {

        Opdracht10Klasse a = new Opdracht10Klasse();
        a.bereken10();
    }
}

class Opdracht10Klasse {

    public void bereken10() {

        int j = 1;
        boolean isPriem;
        long sum = 0, begin, end;
        begin= System.currentTimeMillis();
        while (j < 2000000) {
            isPriem = false;
            if (!(j % 2 == 0)) {
                for (int i = 2; i <= Math.sqrt(j); i++) {

                    if (j % i == 0) {
                        isPriem = false;
                        break;

                    } else {
                        isPriem = true;
                    }

                }
            }
            if (isPriem) {

                sum += j;
//                StringBuilder sb = new StringBuilder();
//                sb.append("Priem: ").append(j).append(" sum: ").append(sum);
//                System.out.println(sb);
            }
            j+=2;
        }
        System.out.println(sum + 5);
        end = System.currentTimeMillis();
        
        System.out.println(end - begin);
    }
//143042032102
//142913828922

}
