/**
 *
 */
package cn.afterturn.easypoi.excel.graph.entity;

import cn.afterturn.easypoi.excel.graph.constant.ExcelGraphElementType;


/**
 * @author xfworld
 * @version 1.0
 * @since 2015-12-30
 */
public class ExcelGraphElement {
    private Integer startRowNum;
    private Integer endRowNum;
    private Integer startColNum;
    private Integer endColNum;
    private Integer elementType = ExcelGraphElementType.StringType;


    public Integer getStartRowNum() {
        return startRowNum;
    }

    public void setStartRowNum(Integer startRowNum) {
        this.startRowNum = startRowNum;
    }

    public Integer getEndRowNum() {
        return endRowNum;
    }

    public void setEndRowNum(Integer endRowNum) {
        this.endRowNum = endRowNum;
    }

    public Integer getStartColNum() {
        return startColNum;
    }

    public void setStartColNum(Integer startColNum) {
        this.startColNum = startColNum;
    }

    public Integer getEndColNum() {
        return endColNum;
    }

    public void setEndColNum(Integer endColNum) {
        this.endColNum = endColNum;
    }

    public Integer getElementType() {
        return elementType;
    }

    public void setElementType(Integer elementType) {
        this.elementType = elementType;
    }
}
