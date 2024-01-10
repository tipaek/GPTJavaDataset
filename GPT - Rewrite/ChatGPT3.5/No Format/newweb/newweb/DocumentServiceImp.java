package com.newweb.service.business.imp;

import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.stereotype.Component;

import com.newweb.util.DateUtil;

@Component("documentService")
public class DocumentServiceImp implements DocumentService {

    private static final String REPORT_FILE_NAME = "report.xls";

    @Override
    public String exportReportToExcel(List<Map<String, Object>> records, String path) {
        String fileName = path + REPORT_FILE_NAME;
        try {
            HSSFWorkbook book = new HSSFWorkbook();
            FileOutputStream fileOut = new FileOutputStream(fileName);

            HSSFSheet sheet = book.createSheet("新世纪报表");

            createTitleRow(sheet);

            createExportDateRow(sheet);

            createRecordsContent(sheet, records, book);

            book.write(fileOut); // 把book对象输出到文件中
            fileOut.close();
            return fileName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void createTitleRow(HSSFSheet sheet) {
        HSSFRow title = sheet.createRow(0);
        String[] titleCells = {"客户", "联系电话", "全部账单金额", "全部账单应收金额", "全部实收总额", "欠款总额"};
        CellStyle titleStyle = createTitleCellStyle(sheet.getWorkbook());
        for (int i = 0; i < titleCells.length; i++) {
            int index = title.getPhysicalNumberOfCells();
            HSSFCell cell = title.createCell(index);
            cell.setCellStyle(titleStyle);
            cell.setCellValue(titleCells[i]);
        }
    }

    private CellStyle createTitleCellStyle(HSSFWorkbook workbook) {
        CellStyle titleStyle = workbook.createCellStyle();
        titleStyle.setAlignment(CellStyle.ALIGN_CENTER);
        Font titleFont = workbook.createFont();
        titleStyle.setFont(titleFont);
        return titleStyle;
    }

    private void createExportDateRow(HSSFSheet sheet) {
        HSSFCell dateCell = sheet.createRow(sheet.getLastRowNum() + 1).createCell(0);
        CellStyle dateStyle = createDateCellStyle(sheet.getWorkbook());
        dateCell.setCellValue("报表导出日期：" + DateUtil.getLocationCurrentDate());
        sheet.addMergedRegion(new Region(dateCell.getRowIndex(), (short) dateCell.getColumnIndex(), dateCell.getRowIndex(), (short) 5));
        dateCell.setCellStyle(dateStyle);
        sheet.createRow(sheet.getLastRowNum() + 1);
    }

    private CellStyle createDateCellStyle(HSSFWorkbook workbook) {
        CellStyle dateStyle = workbook.createCellStyle();
        dateStyle.setAlignment(CellStyle.ALIGN_CENTER);
        return dateStyle;
    }

    private void createRecordsContent(HSSFSheet sheet, List<Map<String, Object>> records, HSSFWorkbook workbook) {
        for (int i = 0; i < records.size(); i++) {
            Map<String, Object> map = records.get(i);
            HSSFRow content = sheet.createRow(sheet.getLastRowNum() + 1);
            createContentStrings(content, map);
            createContentDoubles(content, map, workbook);
        }
    }

    private void createContentStrings(HSSFRow content, Map<String, Object> map) {
        String[] contentStrings = {(String) map.get("customer"), (String) map.get("contact")};
        createContentCells(content, contentStrings, createStringCellStyle(content.getSheet().getWorkbook()));
    }

    private void createContentDoubles(HSSFRow content, Map<String, Object> map, HSSFWorkbook workbook) {
        Double[] contentDoubles = {(Double) map.get("allAccount"), (Double) map.get("allRece"),
                (Double) map.get("allRealIn"), (Double) map.get("owe")};
        createContentCells(content, contentDoubles, createDoubleCellStyle(workbook));
    }

    private CellStyle createStringCellStyle(HSSFWorkbook workbook) {
        CellStyle style = workbook.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        return style;
    }

    private CellStyle createDoubleCellStyle(HSSFWorkbook workbook) {
        CellStyle style = workbook.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_RIGHT);
        return style;
    }

    private void createContentCells(HSSFRow content, Object[] contentArray, CellStyle style) {
        for (Object value : contentArray) {
            int index = content.getPhysicalNumberOfCells();
            HSSFCell cell = content.createCell(index);
            setCellValue(cell, value);
            cell.setCellStyle(style);
        }
    }

    private void setCellValue(HSSFCell cell, Object value) {
        if (value instanceof String) {
            cell.setCellValue((String) value);
        } else if (value instanceof Double) {
            cell.setCellValue((Double) value);
        }
    }
}
