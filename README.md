# PdfToXlsxFileGenerator
Do you want to convert you'r PDF file to XLSX(Excel/SpredSheet), can use the JAR file

PDF to XLSX (Excel/SpreadSheet) file converter in JAVA

How To use it? 

Step 1) Add the JAR to the Build Path

Step 2) Create a main method

Step 3) Extend the Parser interface and write your parser to parse the PDF file( Note - The return type should be List<List<String>> where the inner list refers to the rows and the outer, column as in 2D Matrix ).
  
Step 4) Call "Main.start( )" and set the parameter as the object of your parser.
