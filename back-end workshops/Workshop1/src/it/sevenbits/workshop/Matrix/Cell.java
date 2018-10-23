package it.sevenbits.workshop.Matrix;

class Cell {
    private int x;
    private int y;
    private int value;

    private Cell(){
    }

    public Cell(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    public void Inverse(){
        value = -value;
    }

    public int GetX() {
       return x;
    }

    public void SetX(int newX) {
        x = newX;
    }

    public int GetY() {
        return y;
    }

    public void SetY(int newY) {
        y = newY;
    }

    public int GetValue() {
        return value;
    }

    public void SetValue(int newValue) {
        value = newValue;
    }
}
