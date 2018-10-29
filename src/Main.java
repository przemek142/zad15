import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList();
        List<String> list = ReadCSV.readFile();

        for (Object o : list) {
            String[] productData = ((String) o).split(";");
            products.add(new
                    Product(
                    productData[0],
                    new BigDecimal(productData[1]),
                    new BigDecimal(productData[2])
            ));
        }

        Invoice invoice = new Invoice();
        invoice.calc(products);

        PrintToPDF.createPDF(products, invoice);

    }
}
