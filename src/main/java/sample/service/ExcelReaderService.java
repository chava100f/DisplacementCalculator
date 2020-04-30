package sample.service;

import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.util.*;

import sample.beans.Elemento;
import sample.beans.InsumoVista;
import sample.beans.Nodo;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReaderService {
    private final int NUMERO_COLUMNAS_EXCEL_SEGUND_PAGINA = 22;
    private final int NUMERO_COLUMNAS_EXCEL_PRIMER_PAGINA = 3;

    public InsumoVista leeArchivo(String rutaArchivo) throws IOException {

        int i = 0;
        String[][] excelColumnas;

        InsumoVista insumosVista = new InsumoVista();

        FileInputStream inputStream = new FileInputStream(new File(rutaArchivo));

        Workbook workbook = new XSSFWorkbook(inputStream);

        //Primera Hoja de Archivo Excel
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();

        excelColumnas = new String[firstSheet.getLastRowNum()+1][firstSheet.getRow(0).getLastCellNum()];
        System.out.print("excelColumnas["+(firstSheet.getLastRowNum()+1)+"]["+firstSheet.getRow(0).getLastCellNum()+"]");
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();

            if(i<=firstSheet.getLastRowNum()) {
                for(int j=0; j<nextRow.getLastCellNum(); j++) {

                    Cell cell = nextRow.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    excelColumnas[i][j] = getAnyCellValueToString(cell);
                    System.out.print(excelColumnas[i][j]);
                    System.out.print(" - ");
                }
                insumosVista.getLstNods().add(new Nodo(excelColumnas[i][0], excelColumnas[i][1],
                        excelColumnas[i][2], excelColumnas[i][3]));
            }
            i++;

            System.out.println();
        }

        insumosVista.getLstNods().forEach(System.out::println);
        insumosVista.getLstNods().remove(0);
        insumosVista.getLstNods().remove(new Nodo());

        i=0;

        //Segunda Hoja de Archivo Excel
        Sheet secondSheet = workbook.getSheetAt(1);
        iterator = secondSheet.iterator();
        System.out.println(secondSheet.getLastRowNum() +","+secondSheet.getRow(0).getLastCellNum());

        excelColumnas = new String[secondSheet.getLastRowNum()+1][secondSheet.getRow(0).getLastCellNum()];
        System.out.print("excelColumnas["+(secondSheet.getLastRowNum()+1)+"]["+secondSheet.getRow(0).getLastCellNum()+"]");
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();

            if(i<=secondSheet.getLastRowNum()) {

                for(int j=0; j<nextRow.getLastCellNum(); j++) {

                    Cell cell = nextRow.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    excelColumnas[i][j] = getAnyCellValueToString(cell);
                    System.out.print(excelColumnas[i][j]);
                    System.out.print(" - ");
                }
                insumosVista.getLstElements().add(new Elemento(excelColumnas[i][0], excelColumnas[i][1],
                        excelColumnas[i][5], excelColumnas[i][8], excelColumnas[i][9]));
            }
            i++;

            System.out.println();
        }

        workbook.close();
        inputStream.close();


        System.out.println("ListaElementos = " );
        insumosVista.getLstElements().forEach(System.out::println);
        insumosVista.getLstElements().remove(0);
        insumosVista.getLstElements().remove(new Elemento());


        return insumosVista;

    }

    private String getAnyCellValueToString(Cell cell){

        String value;

        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                value = cell.getStringCellValue();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                value = String.valueOf(cell.getNumericCellValue());
                break;
            case Cell.CELL_TYPE_BLANK:
                value = "";
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                value = String.valueOf(cell.getBooleanCellValue());
                break;
            default:
                value="Valor no reconocido";
                break;
        }
        return value;
    }
}
