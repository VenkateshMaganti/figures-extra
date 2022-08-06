package com.epam.rd.autotasks.figures;

class Triangle extends Figure{
    Point p1,p2,p3;
    public Triangle(Point a, Point b, Point c) {
        p1=a;
        p2=b;
        p3=c;
        if((a==null || b==null || c==null) || (0.5*(a.getX()*(b.getY()-c.getY())+b.getX()*(c.getY()-a.getY())+c.getX()*(a.getY()-b.getY()))==0))
            throw new IllegalArgumentException();
    }
    public Point centroid() {
        return new Point((p1.getX()+p2.getX()+p3.getX())/3,(p1.getY()+p2.getY()+p3.getY())/3);

    }
    public boolean isTheSame(Figure figure) {
        if(this.getClass()== figure.getClass()) {
            return Math.abs(this.area() - ((Triangle) figure).area()) <= 0.0001;
        }
        else
            return false;
    }
    public double area() {
        double Area=0.5*(p1.getX()*(p2.getY()-p3.getY())+p2.getX()*(p3.getY()-p1.getY())+p3.getX()*(p1.getY()-p2.getY()));
        return Math.abs(Area);
    }
}
