package TP01;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class BigIntMAth {
    public static BigInteger[] euclideEtendu(BigInteger a, BigInteger b) {
        BigInteger[] vars = new BigInteger[3];

        BigInteger r = a,
                r_ = b,
                u = new BigInteger(String.valueOf(1)),
                v = new BigInteger(String.valueOf(0)),
                u_ = new BigInteger(String.valueOf(0)),
                v_ = new BigInteger(String.valueOf(1));
        BigInteger q;
        BigInteger rs, us, vs;

        while (!r_.equals(BigInteger.ZERO)) {
            q = r.divide(r_);

            rs = r;
            us = u;
            vs = v;

            r = r_;
            u = u_;
            v = v_;

            r_ = rs.add(q.multiply(r_).negate());
            u_ = us.add(q.multiply(u_).negate());
            v_ = vs.add(q.multiply(v_).negate());
        }

        vars[0] = r;
        vars[1] = u;
        vars[2] = v;

        return vars;
    }

    public static BigInteger InverseMode(BigInteger a,BigInteger n){
        BigInteger[] vars = euclideEtendu(a,n);

        if(vars[0].equals(BigInteger.ONE))
            return vars[1];
        else
            return null;
    }

    public static List<BigInteger> findDivisors(BigInteger num){
        BigInteger limit = num;
        BigInteger counter = BigInteger.ONE;
        List<BigInteger> bigIntDevisors = new ArrayList<>();
        while(counter.compareTo(limit) < 0)
        {
            if (num.mod(counter).compareTo(BigInteger.ZERO) == 0)
            {
                bigIntDevisors.add(counter);
                BigInteger partner = num.divide(counter);
                limit = partner; // shorten the loop
                bigIntDevisors.add(partner);
            }
            counter = counter.add(BigInteger.ONE);
        }
        return bigIntDevisors;
    }
}
