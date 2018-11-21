package projecteuler;

import java.math.BigInteger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hans
 */
public class Opdracht10_2 {

    public static void main(String[] args) {
        Opdracht10_2_ a = new Opdracht10_2_();
        a.opdracht();

    }
}

class Opdracht10_2_ {

    public void opdracht() {
        BigInteger sum = BigInteger.ZERO;
        for (BigInteger num = BigInteger.valueOf(2); num.compareTo(BigInteger.valueOf(2000000)) < 0; num = num.nextProbablePrime()) {
            sum = sum.add(num);
        }
        System.out.println(sum.toString());
    }
}

