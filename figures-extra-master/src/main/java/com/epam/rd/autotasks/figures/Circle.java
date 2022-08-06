package com.epam.rd.autotasks.figures;

class Circle extends Figure{
    double r;
    Point p;
    public Circle(Point p,double r) {
        if(r>0 && p!=null) {
            this.p=p;
            this.r=r;
        }
        else
            throw new IllegalArgumentException();
    }
    public Point centroid() {
        return p;
    }
    public boolean isTheSame(Figure figure) {
        if(this.getClass()==figure.getClass()) {
            return (Math.abs(p.getX() - ((Circle) figure).p.getX()) <= 0.0001 && Math.abs(p.getY() - ((Circle) figure).p.getY()) <= 0.0001) && Math.abs(r - ((Circle) figure).r) <= 0.0001;
        }
        else
            return false;

    }
}
