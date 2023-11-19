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
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class GeneratePDF implements Observer{
    public GeneratePDF(){

    }

    public boolean CreatePDF(){
        Document document = new Document();
        

        try{
            try{
                PdfWriter.getInstance(document, new FileOutputStream("AssignmentGrade.pdf"));
            } catch (FileNotFoundException e){
                System.out.println("file not found"); 
                return false; 
            }
            

            document.open();
            Font font = FontFactory.getFont(FontFactory.HELVETICA, 16, BaseColor.BLACK);
            Chunk chunk = new Chunk("Assignment Grades", font);
        
            document.add(chunk);

            Paragraph newLine = new Paragraph("\n"); // You can customize the content within the paragraph
            document.add(newLine);

            PdfPTable table = new PdfPTable(2); //number of columns 
                addTableHeader(table);
                addRows(table, "816029783", "43");
               

            document.add(table);


        document.close();
        }
         catch (DocumentException e){
            System.out.println("Error creating pdf");
            return false; 
        }

        return true; 
    }


    public void update(){
        
        System.out.println("the pdf observer was triggered"); 




    }




    private void addTableHeader(PdfPTable table) {
    Stream.of("Student ID", "Total Grade")
      .forEach(columnTitle -> {
        PdfPCell header = new PdfPCell();
        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
        header.setBorderWidth(2);
        header.setPhrase(new Phrase(columnTitle));
        table.addCell(header);
    });
    }

    private void addRows(PdfPTable table, String ID, String mark) {
        table.addCell(ID);
        table.addCell(mark);
    }

    

}
