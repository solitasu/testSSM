/*package com.test.controller;




import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.model.User;

import wsepr.easypoi.excel.Excel;
import wsepr.easypoi.excel.editor.IFontEditor;
import wsepr.easypoi.excel.editor.IPrintSetup;
import wsepr.easypoi.excel.style.Align;
import wsepr.easypoi.excel.style.BorderStyle;
import wsepr.easypoi.excel.style.Color;
import wsepr.easypoi.excel.style.VAlign;
import wsepr.easypoi.excel.style.font.BoldWeight;
import wsepr.easypoi.excel.style.font.Font;


public class print implements java.io.Serializable {
	*//**
 * 导出Excel
 *//*
	public void exportUserInfoToExcel() throws IOException{  
	    OutputStream out = response.getOutputStream();  
	    response.setContentType("application/x-download");  
	    //设置导出文件名称  
	    response.setHeader("Content-Disposition", "attachment;filename="+DateUtil.getNow("yyyyMMddHHmmssSSS")+".xls");  
	      
	    Excel excel = new Excel();  
	      
	    //查询内容list，userService.getUserList方法自己实现  
	    List<User> list = userService.getUserList();  
	    //表头数组  
	    String[] header = {"用户ID","用户名","性别","地址"};  
	    //表单title  
	    String title = "用户信息列表";  
	    int headerLen = header.length;  
	    //单元格边框颜色  
	    Color borderColor = Color.GREY_50_PERCENT;  
	    //表头字体  
	    IFontEditor headFont = new IFontEditor(){  
	        public void updateFont(Font font){  
	            font.fontHeightInPoints(14)  
	            .boldweight(BoldWeight.BOLD)  
	            .color(Color.WHITE);  
	        }  
	    };  
	    //标题字体  
	    IFontEditor titleFont = new IFontEditor(){  
	        public void updateFont(Font font){  
	            font.fontHeightInPoints(30)  
	            .boldweight(BoldWeight.BOLD)  
	            .color(Color.DARK_BLUE);  
	        }  
	    };  
	    //设置表单信息  
	    excel.setWorkingSheet(0)//设置第1个工作表为工作状态  
	         .sheetName(title+"1")   
	         .fitToPage(true)  
	         .horizontallyCenter(true)  
	         .printGridlines(false)  
	         .displayGridlines(true)  
	         .autobreaks(true)  
	         .printSetup(new IPrintSetup(){  
	            public void setup(HSSFPrintSetup printSetup) {  
	                printSetup.setLandscape(true);//是否打印背景  
	                printSetup.setFitHeight((short)1);//调整缩放  
	                printSetup.setFitWidth((short)1);//调整缩放  
	            }  
	        });  
	      
	    //设置标题内容，标题行列合并，标题样式  
	    excel.row(0).height(60);  
	    excel.cell(0, 0).value(title)  
	        .align(Align.CENTER)  
	        .font(titleFont);  
	    excel.region(0, 0, 0, headerLen-1).merge();//合并标题的单元格  
	      
	    //设置表头及样式  
	    for(int i=0;i<headerLen;i++){  
	        excel.column(i).width(5000);  
	        excel.cell(1, i).value(header[i])  
	             .align(Align.CENTER)  
	             .bgColor(Color.DARK_BLUE)  
	             .font(headFont);  
	    }  
	      
	    //添加内容  
	    for(int i=0,len=list.size();i<len;i++){  
	        excel.row(i+2).height(30);//设置行高度  
	        for(int j=0;j<headerLen;j++){  
	            excel.cell(i+2, j).align(Align.CENTER)//设置区域内单元格水平对齐方式  
	                .vAlign(VAlign.CENTER)//设置垂直对齐方式  
	                .border(BorderStyle.THIN, borderColor);  
	        }     
	        User grid = list.get(i);  
	        excel.cell(i+2, 0).value(grid.getUserId());  
	        excel.cell(i+2, 1).value(grid.getName());  
	        excel.cell(i+2, 2).value(grid.getSex());  
	        excel.cell(i+2, 3).value(grid.getAddress());  
	    }  
	      
	    excel.saveExcel(out);  
	}  
}
*/