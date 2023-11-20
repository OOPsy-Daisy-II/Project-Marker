package oopsy_daisy;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.stream.Stream;

import com.google.common.collect.Table;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.List; 
import java.util.ArrayList; 

public class GeneratePDF implements Observer{
    public PdfPTable table;
    int numberOfColumns = 0; 
    

    public GeneratePDF(String specPath){

        CreatePDF(specPath);   
    }

    public void CreatePDF(String specPath){
        Document document = new Document();
        
        document.setPageSize(PageSize.A4.rotate());
        
        ExamineSpec examiner = new ExamineSpec(specPath);
        int columnCount = examiner.getCount();
        List<String> TestFileList = examiner.getFilenames();

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

            Paragraph newLine = new Paragraph("\n"); // You can customize the content within the paragraph
            document.add(newLine);

            numberOfColumns = columnCount +3;

            table = createTable(numberOfColumns);
            table.setWidthPercentage(100);
             


             table.addCell(new PdfPCell(new Paragraph("StudentID")));
            
             for (int i =0; i<columnCount; i++){
                PdfPCell cell = new PdfPCell(new Paragraph(TestFileList.get(i)));
                table.addCell(cell);
             }
            
            table.addCell(new PdfPCell(new Paragraph("Total")));
            table.addCell(new PdfPCell(new Paragraph("Comments")));

            //test to show that the PDF is being written to
            ArrayList<Integer> marks = new ArrayList<>();
            marks.add(12);
            marks.add(13);
            marks.add(41);
            marks.add(32);

            addRows(table, "specPath", marks);
             
            document.add(table);


         document.close();
        }
         catch (DocumentException e){
            System.out.println("Error creating pdf");
        }
    }

    private static PdfPTable createTable(int columnCount) {
        return new PdfPTable(columnCount);
    }
    


    public void addRows(PdfPTable table, String ID, ArrayList<Integer> marks ) {
        int numColumns = marks.size();
        System.out.println("Adding Rows to table");


        table.addCell(new PdfPCell(new Paragraph(ID)));

        int total = 0;
        for (int i =0; i<numColumns; i++){
                PdfPCell cell = new PdfPCell(new Paragraph(String.valueOf(marks.get(i))));
                total +=marks.get(i);
                System.out.println("TOTAL "+ total);
                table.addCell(cell);
             }
            
        table.addCell(new PdfPCell(new Paragraph(String.valueOf(total))));
        table.addCell(new PdfPCell(new Paragraph("Comments")));


        
    }


    public void update(){
        Document temp = new Document();
        temp.setPageSize(PageSize.A4.rotate());

        try{
            try{
                PdfWriter.getInstance(temp, new FileOutputStream("temp.pdf"));
            } catch (FileNotFoundException e){
                System.out.println("file not found"); 
            }
            
            temp.open();

            PdfPTable newtable = createTable(numberOfColumns);
            table.setWidthPercentage(100);


        ArrayList<Integer> marks = new ArrayList<>(); 
        String studentID = "";
        String comment = "";
        
        // addRows(studentID, marks);
        //this is a test line

        marks.add(12);
        marks.add(13);
        marks.add(41);
        marks.add(32);

        addRows(newtable, "816031079", marks); 

        temp.add(newtable);
        temp.close();

        


        System.out.println("the pdf observer was triggered"); 




    }




    

    

}
