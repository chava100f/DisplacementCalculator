package sample.service;

import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.util.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import sample.beans.Desplazamiento;
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

    private final Logger log = Logger.getLogger(ExcelReaderService.class);

    public InsumoVista leeArchivo(String rutaArchivo) throws IOException {

        log.info("Inicia Lectura del archivo Excel->" + rutaArchivo);

        int i = 0;
        String[][] excelColumnas;

        InsumoVista insumosVista = new InsumoVista();

        FileInputStream inputStream = new FileInputStream(new File(rutaArchivo));

        Workbook workbook = new XSSFWorkbook(inputStream);

        //Primera Hoja de Archivo Excel
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();

        excelColumnas = new String[firstSheet.getLastRowNum()+1][firstSheet.getRow(0).getLastCellNum()];
        log.info("PRIMERA HOJA - excelColumnas["+(firstSheet.getLastRowNum()+1)+"]["+firstSheet.getRow(0).getLastCellNum()+"]");
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();

            if(i<=firstSheet.getLastRowNum()) {
                for(int j=0; j<nextRow.getLastCellNum(); j++) {

                    Cell cell = nextRow.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    excelColumnas[i][j] = getAnyCellValueToString(cell);
                }
                insumosVista.getLstNods().add(new Nodo(excelColumnas[i][0], excelColumnas[i][1],
                        excelColumnas[i][2], excelColumnas[i][3]));
            }
            i++;
        }

        insumosVista.getLstNods().remove(0);
        insumosVista.getLstNods().remove(new Nodo());

        i=0;

        //Segunda Hoja de Archivo Excel
        Sheet secondSheet = workbook.getSheetAt(1);
        iterator = secondSheet.iterator();

        excelColumnas = new String[secondSheet.getLastRowNum()+1][secondSheet.getRow(0).getLastCellNum()];
        log.info("SEGUNDA HOJA - excelColumnas["+(secondSheet.getLastRowNum()+1)+"]["+secondSheet.getRow(0).getLastCellNum()+"]");
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();

            if(i<=secondSheet.getLastRowNum()) {

                for(int j=0; j<nextRow.getLastCellNum(); j++) {

                    Cell cell = nextRow.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    excelColumnas[i][j] = getAnyCellValueToString(cell);
                }

                if(String.valueOf(excelColumnas[i][5]).equals("6.0") || String.valueOf(excelColumnas[i][5]).equals("Material") ) {
                    insumosVista.getLstElements().add(new Elemento(excelColumnas[i][0], excelColumnas[i][1],
                            excelColumnas[i][5], excelColumnas[i][8], excelColumnas[i][9]));
                }
            }
            i++;

        }

        i=0;
        insumosVista.getLstElements().remove(0);
        insumosVista.getLstElements().remove(new Elemento());

        //Segunda Hoja de Archivo Excel
        Sheet thirdSheet = workbook.getSheetAt(2);
        iterator = thirdSheet.iterator();

        excelColumnas = new String[thirdSheet.getLastRowNum()+1][thirdSheet.getRow(0).getLastCellNum()];
        log.info("TERCERA HOJA - excelColumnas["+(thirdSheet.getLastRowNum()+1)+"]["+thirdSheet.getRow(0).getLastCellNum()+"]");
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();

            if(i<=thirdSheet.getLastRowNum()) {

                for(int j=0; j<nextRow.getLastCellNum(); j++) {

                    Cell cell = nextRow.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    excelColumnas[i][j] = getAnyCellValueToString(cell);
                }

                insumosVista.getLstDesplazamientos().add(new Desplazamiento(excelColumnas[i][0], excelColumnas[i][1],
                        excelColumnas[i][2], excelColumnas[i][3], excelColumnas[i][4], excelColumnas[i][5], excelColumnas[i][6], excelColumnas[i][7]));
            }
            i++;

        }

        workbook.close();
        inputStream.close();


        log.info("Inicia Lectura del archivo Excel->" + rutaArchivo);

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
