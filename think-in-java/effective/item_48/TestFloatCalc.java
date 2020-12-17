package effective.item_48;

import java.math.BigDecimal;

public class TestFloatCalc {
    public static void main(String[] args) {
        testSubtract();
        monetaryCalcWithBigDecimal();
        monetaryCalc();
    }
    public static void testSubtract() {
        System.out.println(1.03-0.42);
        System.out.println(1.00-9 * 0.10);
    }

    public static void monetaryCalcWithBigDecimal() {
        final BigDecimal TEN_CENTS = new BigDecimal(".10");
        int itemsBought = 0;
        BigDecimal funds = new BigDecimal("1.00");
        for (BigDecimal price = TEN_CENTS;
             funds.compareTo(price) >= 0;
             price = price.add(TEN_CENTS)) {
            funds = funds.subtract(price);
            itemsBought++;
        }
        System.out.println(itemsBought + " items bought.");
        System.out.println("Money left over: $" + funds);
    }

    public static void monetaryCalc() {
        double funds = 1.00;
        int itemsBought = 0;
        for (double price = 0.10; funds >= price; price += 0.10) {funds -= price;
            itemsBought++;
        }
        System.out.println(itemsBought + " items bought.");
        System.out.println("Change: $" + funds);
    }

}
