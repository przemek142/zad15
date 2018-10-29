import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Product implements Comparable<Product> {
    private String name;
    private BigDecimal netPrice, grossPrice, VAT;

    public Product(String name, BigDecimal grossPrice, BigDecimal VAT) {
        this.name = name;
        this.grossPrice = grossPrice;
        this.VAT = VAT;
        this.netPrice = grossPrice.divide((VAT.divide(BigDecimal.valueOf(100))).add(BigDecimal.valueOf(1)),2 , RoundingMode.HALF_UP);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", netPrice=" + netPrice +
                ", grossPrice=" + grossPrice +
                ", VAT=" + VAT +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) &&
                Objects.equals(netPrice, product.netPrice) &&
                Objects.equals(grossPrice, product.grossPrice) &&
                Objects.equals(VAT, product.VAT);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, netPrice, grossPrice, VAT);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(BigDecimal netPrice) {
        this.netPrice = netPrice;
    }

    public BigDecimal getGrossPrice() {
        return grossPrice;
    }

    public void setGrossPrice(BigDecimal grossPrice) {
        this.grossPrice = grossPrice;
    }

    public BigDecimal getVAT() {
        return VAT;
    }

    public void setVAT(BigDecimal VAT) {
        this.VAT = VAT;
    }

    @Override
    public int compareTo(Product o) {
        if (this.VAT.compareTo(o.VAT) != 0) {
            if (this.netPrice.compareTo(o.netPrice) != 0) {
                return this.name.compareTo(o.name);
            } else
                return this.netPrice.compareTo(o.netPrice);
        } else
            return this.VAT.compareTo(o.VAT);
    }
}
