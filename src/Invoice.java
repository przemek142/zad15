import java.math.BigDecimal;
import java.util.ArrayList;

public class Invoice {
    private BigDecimal netProfit = BigDecimal.valueOf(0);
    private BigDecimal grossProfit = BigDecimal.valueOf(0);
    private BigDecimal vatSum = BigDecimal.valueOf(0);

    public void calc(ArrayList<Product> products){
        for (Product product : products) {
            netProfit = netProfit.add(product.getNetPrice());
            grossProfit = grossProfit.add(product.getGrossPrice());
            vatSum = vatSum.add(product.getGrossPrice().subtract(product.getNetPrice()));
        }
    }

    @Override
    public String toString() {
        return "net: " + netProfit + " gros: " +grossProfit + " vat: " + vatSum;
    }

    public BigDecimal getNetProfit() {
        return netProfit;
    }

    public void setNetProfit(BigDecimal netProfit) {
        this.netProfit = netProfit;
    }

    public BigDecimal getGrossProfit() {
        return grossProfit;
    }

    public void setGrossProfit(BigDecimal grossProfit) {
        this.grossProfit = grossProfit;
    }

    public BigDecimal getVatSum() {
        return vatSum;
    }

    public void setVatSum(BigDecimal vatSum) {
        this.vatSum = vatSum;
    }
}
