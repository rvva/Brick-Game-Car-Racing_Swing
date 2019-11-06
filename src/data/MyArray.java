/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;



/**
 *
 * @author student
 */
public class MyArray {

    protected int[][] array;
    
    protected MyArray(){
    }

    public MyArray(int rowc, int colc)  {
        if (rowc <= 0) {
            throw new IllegalArgumentException("Zła liczba wierszy!");
        }

        if (colc <= 0) {
            throw new IllegalArgumentException("Zła liczba kolumn");
        }

        array = new int[rowc][colc];
    }

    public MyArray(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Zła liczba wierszy, kolumn!");
        }
        array = new int[length][length];
    }

    public int[][] getArray() {
        return array;
    }

    public void setTab(int[][] tab) {
        this.array = tab;
    }

    public int getRowCount() {
        return array.length;
    }

    public int getColCount() {
        return array[0].length;
    }

    public boolean isRowIdxValid(int rownIdx) {
        return rownIdx >= 0 && rownIdx < getRowCount() ;
    }

    public boolean isColIdxValid(int colnIdx) {
        return colnIdx >= 0 && colnIdx < getColCount() ;
    }

    public boolean areIndexesValid(int rowIdx, int colIdx) {
        return isRowIdxValid(rowIdx) && isColIdxValid(colIdx);
    }

    public int getValueOf(int rowIdx, int colIdx) {
        if (!areIndexesValid(rowIdx, colIdx)) {
            throw new IllegalArgumentException("Błędny indeks!");
        }
        return array[rowIdx][colIdx];
    }
    
    @Override
     public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0, limitRow = getRowCount(); i < limitRow; i++) {
            for (int j = 0, limitCol = getColCount(); j < limitCol; j++) {
                //stringBuilder.append(array[i][j] == -1 ? "" : array[i][j]).append("\t");
                stringBuilder.append(array[i][j]).append("\t");
            }
            stringBuilder.append("\n\r");
        }
        return stringBuilder.toString();
    }
}
