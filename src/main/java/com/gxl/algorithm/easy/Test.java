package com.gxl.algorithm.easy;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Test
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2024/3/5 10:41
 */
public class Test {
    public static void main(String[] args) {
        //        try {
        //            Class.forName(InterfaceTest.class.getName());
        //        } catch (ClassNotFoundException e) {
        //            e.printStackTrace();
        //        }
        //        System.out.println(InterfaceTest.check("D"));
        //        System.out.println(InterfaceTest.check("A"));

        //        BigDecimal bd = new BigDecimal("14");
        //        System.out.println(bd.compareTo(new BigDecimal("13")) <= 0);

        //        var today = LocalDate.now();
        //        var before = LocalDate.of(1976, 6, 13);
        //        var period = Period.between(before, today);
        //        System.out.printf("%s岁%s个月%s天\n", period.getYears(), period.getMonths(), period.getDays());
        //
        //        var str = 123;
        //        System.out.println(String.format("%05d",str));

        //        for (var i = 1; i < 10000; i++) {
        //            var exchangeRate = 1.0877D;
        //            var rlt = String.format("%.2f", i * exchangeRate);
        //
        //            var exchangeRate_2 = new BigDecimal("1.0877");
        //            var rlt2 = new DecimalFormat("#0.00").format(new BigDecimal(i).multiply(exchangeRate_2));
        //
        //            if (!rlt.equals(rlt2)) {
        //                System.out.println(rlt + " " + rlt2.toString());
        //            }
        //        }
        //        List<String> list = new ArrayList<>(){{
        //            add("1");
        //            add("2");
        //        }};
        //
        //        System.out.println(list.contains("1"));

        //        LocalDate date = LocalDate.of(2024, 3, 26);
        //        System.out.println(date.plusDays(45 + 60));

        //        LocalDate date = LocalDate.now();
        //        System.out.println(date.plusDays(-10));

        //
        //        File file = new File("/Users/johngao/Desktop/aa/121416-324-carib-1080p.mp4");
        //        System.out.println("后缀:" + file.getName().substring(file.getName().lastIndexOf(".") + 1));
        //        System.out.println("目录:"+file.getParent());

        //        convert(A.A_, 1);
        //        convert(B.B_, "1");

        //        List<String> list = new ArrayList<>() {
        //            {
        //                add("admin");
        //                add("admin1");
        //                add("admin2");
        //                add("admin");
        //            }
        //        };
        //        for (var i = 0; i < list.size(); i++) {
        //            for (var j = i + 1; j < list.size(); j++) {
        //                if (list.get(i).equals(list.get(j))) {
        //                    System.out.println("重复");
        //                    return;
        //                }
        //            }
        //        }
        //        System.out.println("未重复");

//        LocalDate date = LocalDate.now();
//        System.out.println(date.plusDays(1));
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            System.out.println(format.parse(date.plusDays(1).toString()).getTime());
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

//        int a = 123;
//        int b = 333;
//        int rlt = a ^ b;
//        System.out.println(rlt);
//        System.out.println(rlt ^ b);

//        System.out.println(Integer.toHexString(10485768));
//
//        System.out.println("3Des_Decrypt".toUpperCase());
//        System.out.println(new byte[1024 * 1024 * 10].length);
//        System.out.println(Integer.toHexString(10485776));

//        int[] v1 = {1,2,3,4,5};
//        int[] v2 = Arrays.copyOfRange(v1, 0, v1.length);
//        System.out.println(Arrays.toString(v2));

        LocalDate date = LocalDate.of(2024,9,8);
        System.out.println(date.plusDays(14).toString());

    }

    public static <T> void convert(F tt, T code) {
//
//        var a = tt.getCode(code);
//        System.out.println(a.getName());

    }
}

enum A implements F<Integer> {
                              A_(1, "TEST-A");

    int    code;
    String name;

    A(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public F getCode(Integer code) {
        for (A a : A.values()) {
            if (a.code == code) {
                return a;
            }
        }
        return null;
    }
}

enum B implements F<String> {
                             B_("1", "TEST-B");

    String code;
    String name;

    B(String code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public F getCode(String code) {
        for (B a : B.values()) {
            if (a.code.equals(code)) {
                return a;
            }
        }
        return null;
    }
}

interface F<T> {

    String getName();

    F getCode(T code);
}

enum InterfaceTest {
                    A("A"), B("B"), C("C");

    String                      mName;
    private static List<String> mList = new ArrayList<>();
    static {
        for (var i : InterfaceTest.values()) {
            mList.add(i.mName);
        }
        System.out.println("==Yes==");
    }

    public static boolean check(String mName) {
        return mList.contains(mName);
    }

    InterfaceTest(String mName) {
        this.mName = mName;
    }

}
