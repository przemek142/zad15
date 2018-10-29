import java.io.FileOutputStream;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PrintToPDF {

    public static void createPDF(ArrayList<Product> products, Invoice invoice) {
        System.out.println("DefaultCell");

        // step 1: creation of a document-object
        Document document = new Document();

        try {
            // step 2:
            // we create a writer that listens to the document
            // and directs a PDF-stream to a file
            PdfWriter.getInstance(document, new FileOutputStream("F_VAT.pdf"));

            // step 3: we open the document
            document.open();

            document.add(new Paragraph("Faktura VAT - wersja beta"));
            document.add(new Paragraph(" "));

            PdfPTable table = new PdfPTable(4);
//            PdfPCell cell = new PdfPCell(new Paragraph("Faktura VAT"));
//            cell.setColspan(4);
//            table.addCell(cell);
            table.addCell("Nazwa");
            table.addCell("Cena netto");
            table.addCell("Vat[%]");
            table.addCell("Cena brutto");

//            Collections.sort(products);
            for (Product product : products) {
                table.addCell(product.getName());
                table.addCell(product.getNetPrice().toString());
                table.addCell(product.getVAT().toString());
                table.addCell(product.getGrossPrice().toString());
            }
            document.add(table);

            document.add(new Paragraph("Suma netto: " + invoice.getNetProfit().toString()));
            document.add(new Paragraph("Suma brutto: " + invoice.getGrossProfit().toString()));
            document.add(new Paragraph("Suma VAT: " + invoice.getVatSum().toString()));


        } catch (DocumentException de) {
            System.err.println(de.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }

        // step 5: we close the document
        document.close();
    }
}

