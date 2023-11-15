package oopsy_daisy;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.stream.Stream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class GeneratePDF {
    public GeneratePDF(){

    }

    public boolean CreatePDF(){
        Document document = new Document();
        

        try{
            try{
                PdfWriter.getInstance(document, new FileOutputStream("AssignmentGrade.pdf"));
            } catch (FileNotFoundException e){
                System.out.println("file not found"); 
            }
            

            document.open();
            Font font = FontFactory.getFont(FontFactory.HELVETICA, 16, BaseColor.BLACK);
            Chunk chunk = new Chunk("Assignment Grades", font);
        
        document.add(chunk);

        PdfPTable table = new PdfPTable(3);
            addTableHeader(table);
            addRows(table);
            // addCustomRows(table);

        document.add(table);


        document.close();
        }
         catch (DocumentException e){
            System.out.println("Error creating pdf");
        }

        return true; 
    }


    private void addTableHeader(PdfPTable table) {
    Stream.of("Student ID", "Total Grade", "column header 3")
      .forEach(columnTitle -> {
        PdfPCell header = new PdfPCell();
        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
        header.setBorderWidth(2);
        header.setPhrase(new Phrase(columnTitle));
        table.addCell(header);
    });
    }

    private void addRows(PdfPTable table) {
        table.addCell("row 1, col 1");
        table.addCell("row 1, col 2");
        table.addCell("row 1, col 3");
    }

    

}
