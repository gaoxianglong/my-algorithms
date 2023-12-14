package com.gxl.algorithm.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 查询无效交易
 * 解题思路：
 * https://leetcode.cn/problems/invalid-transactions/
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2023/12/14 09:02
 */
public class InvalidTransactions {
    class Transaction {
        String  t;
        String  name;
        String  city;
        int     amount;
        int     time;
        boolean valid;

        Transaction(String t, String name, int time, int amount, String city) {
            this.t = t;
            this.name = name;
            this.city = city;
            this.amount = amount;
            this.time = time;
            this.valid = this.amount > 1000;
        }

        void valid(Transaction transaction) {
            var dt = Math.abs(this.time - transaction.time);
            if (this.name.equals(transaction.name) && !transaction.city.equals(this.city) && dt <= 60) {
                transaction.valid = true;
                valid = true;
            }
        }
    }

    public List<String> invalidTransactions(String[] transactions) {
        var rlt = new ArrayList<String>();
        var ts = new ArrayList<Transaction>();
        for (var t : transactions) {
            var temp = t.split(",");
            ts.add(new Transaction(t, temp[0], Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), temp[3]));
        }
        var n = transactions.length;
        for (var i = 0; i < n; i++) {
            if (ts.get(i).valid) {
                continue;
            }
            for (var j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                ts.get(i).valid(ts.get(j));
            }
        }
        ts.stream().filter(x -> x.valid).forEach(x -> rlt.add(x.t));
        return rlt;
    }

    public static void main(String[] args) {
        var ts = new String[] { "alice,20,800,mtv", "alice,50,100,beijing" };
        System.out.println(new InvalidTransactions().invalidTransactions(ts));
    }
}
