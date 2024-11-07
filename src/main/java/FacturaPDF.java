import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;

public class FacturaPDF {

    public static void generarFactura(String nombreCliente, String fecha, String detalles) {
        try {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
            contentStream.newLineAtOffset(100, 750);
            contentStream.showText("Factura de Venta");
            contentStream.newLineAtOffset(0, -20);
            contentStream.showText("Cliente: " + nombreCliente);
            contentStream.newLineAtOffset(0, -20);
            contentStream.showText("Fecha: " + fecha);
            contentStream.newLineAtOffset(0, -20);
            contentStream.showText("Detalles del Pedido: " + detalles);
            contentStream.endText();
            contentStream.close();
            document.save("Factura_" + nombreCliente + ".pdf");
            document.close();
            System.out.println("PDF generado correctamente.");
        } catch (IOException e) {
            System.err.println("Error generando el PDF: " + e.getMessage());
        }
    }
}
