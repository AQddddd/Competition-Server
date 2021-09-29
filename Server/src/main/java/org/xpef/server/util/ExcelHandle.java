package org.xpef.server.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.xpef.server.model.bo.Student;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ExcelHandle {

    public static List<Student> getStudents(List<String> names,List<List<String>> values) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Student> students=new ArrayList<>(values.size());
        for (List<String> colValues : values) {
            Student student=new Student();
            for (int i = 0; i < colValues.size(); i++) {
                String name=names.get(i);
                String value=colValues.get(i);
                Method method=Student.class.getMethod(name,String.class);
                method.invoke(student,value);
            }
            //补全默认身份信息
            student.fixDefault();
            students.add(student);
            System.out.println(JSONObject.toJSONString(student));
        }
        return students;
    }

    public static List<Student> handleExcel(byte[] bytes) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, IOException {
        ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(bytes);
        return handleExcel(byteArrayInputStream);
    }

    public static List<Student> handleExcel(String filePath) throws IOException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        // 获取文件路径
        File file = new File(filePath);
        //获得该文件的输入流
        FileInputStream stream = new FileInputStream(file);
        // 多态  抛异常
        return handleExcel(stream);
    }
    /**
     * 解析数据
     */
    public static List<Student> handleExcel(InputStream stream) throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        XSSFWorkbook workbook = new XSSFWorkbook(stream);

        // 根据名字获取工作表
        Sheet sheet = workbook.getSheetAt(0);
        // 获取最后一行的索引
        int lastRowIndex = sheet.getLastRowNum();
        System.out.println("lastRowIndex:" + lastRowIndex);
        List<String> colNames=new ArrayList<>();
        List<List<String>> values=new ArrayList<>(lastRowIndex);

        // 获取第一行
        Row row = sheet.getRow(0);
        // 获取最后一个单元格的索引
        int lastCellIndex = row.getLastCellNum();
        for (int j = 0; j < lastCellIndex; j++) {
            String cellValue = "set"+row.getCell(j).getStringCellValue();
            colNames.add(cellValue);
            //System.out.println("方法名: "+cellValue);
        }

        for (int i = 1; i <= lastRowIndex; i++) {
            Row r = sheet.getRow(i);
            List<String> colVales=new ArrayList<>(lastCellIndex);
            for (int j = 0; j < lastCellIndex; j++) {
                String cellValue;
                try {
                    switch (colNames.get(j)){
                        case "setGrade":
                            cellValue=String.valueOf(r.getCell(j).getNumericCellValue()).replace(".0","");
                            break;
                        case "setPhone":
                            DecimalFormat df = new DecimalFormat("#");
                            cellValue= df.format(r.getCell(j).getNumericCellValue());
                            break;
                        default:
                            cellValue=r.getCell(j).getStringCellValue();
                            break;
                    }
                }catch (IllegalStateException e){
                    cellValue=null;
                }

                //System.out.printf("第 %s 行  %s  值：%s%n",i,colNames.get(j),cellValue);
                colVales.add(cellValue);
            }
            values.add(colVales);

        }

        workbook.close();
        stream.close();

        return getStudents(colNames,values);
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, IOException {

       handleExcel("src/main/resources/test.xlsx");
    }

}

