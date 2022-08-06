package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure{
    private final Point p1,p2,p3,p4;

    public Quadrilateral(Point p1,Point p2,Point p3,Point p4) {
        this.p1=p1;
        this.p2=p2;
        this.p3=p3;
        this.p4=p4;

        if(p1==null || p2==null || p3==null || p4==null )
            throw new IllegalArgumentException();
        if(area() <=0 )
            throw new IllegalArgumentException();
        if( new Triangle(p1,p2,p3).area()<=0 || new Triangle(p1,p2,p4).area()<=0 || new Triangle(p2,p3,p4).area()<=0 || new Triangle(p1,p3,p4).area()<=0)
            throw new IllegalArgumentException();

        if((new Segment(p1, p3).intersection(new Segment(p2, p4)) == null))
            throw new IllegalArgumentException();

        double s1=Math.sqrt((p1.getX()-p2.getX())*(p1.getX()-p2.getX()) +((p1.getY()-p2.getY())*(p1.getY()-p2.getY())));
        double s2=Math.sqrt((p2.getX()-p3.getX())*(p2.getX()-p3.getX()) +((p2.getY()-p3.getY())*(p2.getY()-p3.getY())));
        double s3=Math.sqrt((p3.getX()-p4.getX())*(p3.getX()-p4.getX()) +((p3.getY()-p4.getY())*(p3.getY()-p4.getY())));
        double s4=Math.sqrt((p4.getX()-p1.getX())*(p4.getX()-p1.getX()) +((p4.getY()-p1.getY())*(p4.getY()-p1.getY())));
        if(s1==0 || s2==0 || s3==0 || s4==0)
            throw new IllegalArgumentException();

    }
    public Point centroid() {
        Point g1=new Triangle(p1,p2,p3).centroid();
        Point g2=new Triangle(p1,p2,p4).centroid();
        Point g3=new Triangle(p1,p3,p4).centroid();
        Point g4=new Triangle(p2,p3,p4).centroid();
        return (new Segment(g1,g3)).intersection(new Segment(g2,g4));
    }
    //Override
    public boolean isTheSame(Figure figure) {

        if(getClass()!=figure.getClass()) return false;
        else
        {
            if (!(Math.abs(p1.getX()-((Quadrilateral)figure).p1.getX())<=0.0001 && Math.abs(p1.getY()-((Quadrilateral)figure).p1.getY())<=0.0001) &&
                    !(Math.abs(p1.getX()-((Quadrilateral)figure).p2.getX())<=0.0001 && Math.abs(p1.getY()-((Quadrilateral)figure).p2.getY())<=0.0001) &&
                    !(Math.abs(p1.getX()-((Quadrilateral)figure).p3.getX())<=0.0001 && Math.abs(p1.getY()-((Quadrilateral)figure).p3.getY())<=0.0001) &&
                    !(Math.abs(p1.getX()-((Quadrilateral)figure).p4.getX())<=0.0001 && Math.abs(p1.getY()-((Quadrilateral)figure).p4.getY())<=0.0001)) return false;
            if (!(Math.abs(p2.getX()-((Quadrilateral)figure).p1.getX())<=0.0001 && Math.abs(p2.getY()-((Quadrilateral)figure).p1.getY())<=0.0001) &&
                    !(Math.abs(p2.getX()-((Quadrilateral)figure).p2.getX())<=0.0001 && Math.abs(p2.getY()-((Quadrilateral)figure).p2.getY())<=0.0001) &&
                    !(Math.abs(p2.getX()-((Quadrilateral)figure).p3.getX())<=0.0001 && Math.abs(p2.getY()-((Quadrilateral)figure).p3.getY())<=0.0001) &&
                    !(Math.abs(p2.getX()-((Quadrilateral)figure).p4.getX())<=0.0001 && Math.abs(p2.getY()-((Quadrilateral)figure).p4.getY())<=0.0001)) return false;
            if (!(Math.abs(p3.getX()-((Quadrilateral)figure).p1.getX())<=0.0001 && Math.abs(p3.getY()-((Quadrilateral)figure).p1.getY())<=0.0001) &&
                    !(Math.abs(p3.getX()-((Quadrilateral)figure).p2.getX())<=0.0001 && Math.abs(p3.getY()-((Quadrilateral)figure).p2.getY())<=0.0001) &&
                    !(Math.abs(p3.getX()-((Quadrilateral)figure).p3.getX())<=0.0001 && Math.abs(p3.getY()-((Quadrilateral)figure).p3.getY())<=0.0001) &&
                    !(Math.abs(p3.getX()-((Quadrilateral)figure).p4.getX())<=0.0001 && Math.abs(p3.getY()-((Quadrilateral)figure).p4.getY())<=0.0001)) return false;
            return ((Math.abs(p4.getX()-((Quadrilateral)figure).p1.getX())<=0.0001 && Math.abs(p4.getY()-((Quadrilateral)figure).p1.getY())<=0.0001) ||
                    (Math.abs(p4.getX()-((Quadrilateral)figure).p2.getX())<=0.0001 && Math.abs(p4.getY()-((Quadrilateral)figure).p2.getY())<=0.0001) ||
                    (Math.abs(p4.getX()-((Quadrilateral)figure).p3.getX())<=0.0001 && Math.abs(p4.getY()-((Quadrilateral)figure).p3.getY())<=0.0001) ||
                    (Math.abs(p4.getX()-((Quadrilateral)figure).p4.getX())<=0.0001 && Math.abs(p4.getY()-((Quadrilateral)figure).p4.getY())<=0.0001));
        }
    }
    public double area() {
        return (new Triangle(p1,p2,p3)).area()+(new Triangle(p1,p4,p3)).area();
    }
}

class Segment {
    private final double xStart;
    private final double xEnd;
    private final double yStart;
    private final double yEnd;

    public Segment(Point start, Point end) {
        xStart = start.getX();
        xEnd = end.getX();
        yStart = start.getY();
        yEnd = end.getY();
        if ((xStart == xEnd) && (yStart == yEnd)) {
            throw new IllegalArgumentException();
        }
    }

    Point intersection(Segment another) {
        double k = (xStart - xEnd) * (another.yStart - another.yEnd) - (yStart - yEnd) * (another.xStart - another.xEnd);
        double t, u;
        if (k == 0) {
            return null;
        }
        t = ((xStart - another.xStart) * (another.yStart - another.yEnd) - (yStart - another.yStart) * (another.xStart - another.xEnd)) / k;
        u = ((xStart - another.xStart) * (yStart - yEnd) - (yStart - another.yStart) * (xStart - xEnd)) / k;
        if ((t < 0 || t > 1) || (u < 0 || u > 1)) {
            return null;
        }
        return new Point(xStart + t * (xEnd - xStart), yStart + t * (yEnd - yStart));
    }

}

