


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

enum ShapeColor//list of colors
{
  Blue("Blue"),
  Yellow("Yellow"),
  Red("Red"),
  Green("Green"),
  White("White");
  
  private final String sc;
  
  ShapeColor(String sc)
  {
    this.sc = sc;
  }
  
  public String getsc()
  {
    return sc;
  }
  public static ShapeColor getRandom() 
  {
    return values()[(int) (Math.random() * values().length)];
  }
}

interface Shape
{
  public double area();//interface method
}
interface Resizable
{
  public void resize();//interface method
}
  

abstract class TwoD implements Shape  //method area(); will be passed down
{
  protected ShapeColor sc;
  protected int a, b, c, d;
  
  public TwoD()
  {
   
  }
  
  public TwoD(ShapeColor sc, int a)
  {
    this.sc = sc;
    this.a = a;
  }
    
  public TwoD(ShapeColor sc, int a, int b)
  {
    this.sc = sc;
    this.a = a;  
    this.b = b;
  }
    
  public TwoD(ShapeColor sc, int a, int b, int c)
  {
    this.sc = sc;
    this.a = a;  
    this.b = b;
    this.c = c;
  }
    
  public TwoD(ShapeColor sc, int a, int b, int c, int d)
  {
    this.sc = sc;
    this.a = a;  
    this.b = b;
    this.c = c;
    this.d = d;
  }
  
  public TwoD(TwoD td)
  {
    this.sc = td.sc;
    this.a = td.a;
    this.b = td.b;
    this.c = td.c;
    this.d = td.d;    
  }
  
  public int getA()
  {
    return a;
  }
    
  public int getB()
  {
    return b;
  }
    
  public int getC()
  {
    return c;
  }
    
  public int getD()
  {
    return d;
  }
    
  public ShapeColor getShapeColor()
  {
    return sc;
  }
  
  public void set(ShapeColor sc, int a, int b, int c, int d)
  {
    this.sc = sc;
    this.a = a;
    this.b = b;
    this.c = c;
    this.d = d;
  }
  
  public String toString()
  {
    return String.format("2D ");
    
  }
  
}

class Circle extends TwoD //inherits TwoD
{
  

  public Circle()
  {
  }

  public Circle(ShapeColor sc, int radius)
  {  
    
    super(sc, radius);
  }

  public Circle(Circle c)
  {
    
    this(c.sc,c.a);
  }
  @Override
  public double area()
  {
    return Math.PI * a * a;
  }
  
  public int getRadius()
  {
    return a ;
  }

  public void set(ShapeColor sc, int radius)
  {
    this.sc = sc;
    this.a = radius;
  }
  
  @Override
  public String toString()
  {
    
    return String.format("("+super.toString()+ "("+ sc + ","+ a +")" +")");
  }
}
 
  
class Rectangle extends TwoD//inherits TwoD
{
  public Rectangle() {
    
  }
  public Rectangle(ShapeColor sc,int length,int width) {
    super(sc, length,width);
  
  }
  public Rectangle(Rectangle r) {
    
    this(r.sc,r.a,r.b);
  }
  
  @Override
  public double area() {
    
    return a * b;
  }
  
  public int getLength() {
    
    return a;
  }
  
  public int getWidth() {
    
    return b;
  }
  public void set(ShapeColor sc, int length,int width)
  {
    this.sc = sc;
    this.a = length;
    this.b = width;
  }
  @Override
  public String toString()
  {
    
    return String.format("("+super.toString()+ "("+ sc + ","+ a+ ","+ b +")" +")");
  }
  
}

class Triangle extends TwoD//inherits TwoD
{

  public Triangle() {
    
  }
  public Triangle(ShapeColor sc,int a,int b ,int c) {
    super(sc,a ,b ,c);
  }
  public Triangle(Triangle t) {
    this(t.sc,t.a,t.b,t.c);
  }
  
@Override  
public double area() {
  

   int s=(a+b+c)/2;
     double area=Math.sqrt(s*(s-a)*(s-b)*(s-c));
     return area;
  }
public int getA() {
  return a;
}
public int getB() {
  return b;
}
public int getC() {
  return c;
}
public void set(ShapeColor sc, int a,int b , int c)
{
  this.sc = sc;
  this.a = a;
  this.b = b;
  this.c = c;
}
@Override
public String toString()
{
	
  return String.format("("+super.toString()+ "("+ sc + ","+ a+ ","+ b + ","+ c+")" +")");
}



}
class Trapezoid extends TwoD//inherits TwoD
{
  
  private int h;
  
  public Trapezoid() {
    
    h=1;
  }
  
  public Trapezoid(ShapeColor sc, int a ,int b,int c,int d,int h) {
 
    super(sc,a ,b ,c,d);
    this.h=h;
    
  }
  
  public int getA() {
    return a;
  }
  public int getB() {
    return b;
  }
  
  public int getC() {
    return c;
  }
  
  public int getD() {
    return d;
  }
  
  public int getHeight() {
    return h;
  }
  
  @Override
  public double area() {
    return ((a+b)*0.5)*h;
    
  }
  
  public void set(ShapeColor sc, int a ,int b,int c,int d,int h) {
    this.sc = sc;
    this.a = a;
    this.b = b;
    this.c = c;
    this.d = d;
    this.h = h;
  }
  
  @Override
  public String toString() {
    return String.format("("+super.toString()+ "("+ sc + ","+ a+ ","+ b + ","+ c+","+d+ ")" +h+")");
    
  }
  
}
abstract class ThreeD implements Resizable,Shape //method area(); and method resize(); is passed down
{
  protected ShapeColor sc;
  protected double a;  
  
  public ThreeD() {
    
    
  }
  public ThreeD(ShapeColor sc ,double a ) {
  
    this.sc=sc;
    this.a=a;
  }
  public ThreeD(ThreeD td) {
    this.sc=td.sc;
    this.a=td.a;
  }
  public double getA() {
    return a;
  }
  public void set(ShapeColor sc,double a) {
    this.sc=sc;
    this.a=a;
  }
  
  @Override
  public void resize() {
	
    this.a = (a*(0.9));
    DecimalFormat df = new DecimalFormat("0.000");
   System.out.println("("+"3D "+"(" + sc +","+ df.format(a) + ")"+")");

  }
  protected double volume(){
    return a;
    
  }
  
  @Override
  public String toString()
  {
    return String.format("3D ");
    
  }
}

class Cube extends ThreeD//inherits ThreeD
{
  public Cube() {
  
  }
  public Cube(ShapeColor sc,Double a) {
    super(sc,a);
  }
  public Cube(Cube c) {
    this(c.sc,c.a);
  }

  @Override
  public double area() {
    double area = (a*a)*6;
    return area;
  }
  @Override
  protected double volume() {
    double volume = a*a*a;
    return volume;
  }
  public double getA() {
    return a;
  }
  public void set(ShapeColor sc, double a)
  {
    this.sc = sc;
    this.a = a;
  }
  
  @Override
  public String toString()
  {
	  
	 
	  DecimalFormat df = new DecimalFormat("0.000");
	    return String.format("("+super.toString()+ "("+ sc + ","+ df.format(a)+ ")" +")");
  }

  
}
class Sphere extends ThreeD//inherits ThreeD
{
  public Sphere() {
  
  }
  public Sphere(ShapeColor sc,Double a) {
    super(sc,a);
  }
  public Sphere(Sphere s) {
    this(s.sc,s.a);
  }

  @Override
  public double area() {
    double area = 4*Math.PI*a*a;
    return area;
  }
  @Override
  protected double volume() {
    double volume = (4/3)*Math.PI*a*a*a;
    return volume;
  }
  public double getA() {
    return a;
  }
  public void set(ShapeColor sc, double a)
  {
    this.sc = sc;
    this.a = a;
  }
  
  @Override
  public String toString()
  {
	  DecimalFormat df = new DecimalFormat("0.000");
    return String.format("("+super.toString()+ "("+ sc + ","+ df.format(a)+ ")" +")");
  }

  
}
class Tetrahedron extends ThreeD//inherits ThreeD
{
  public Tetrahedron() {
  
  }
  public Tetrahedron(ShapeColor sc,Double a) {
    super(sc,a);
  }
  public Tetrahedron(Sphere t) {
    this(t.sc,t.a);
  }

  @Override
  public double area() {
    double area = (1.73205080757)*a*a;
    return area;
  }
  @Override
  protected double volume() {
    double volume = (a*a*a)/8.48528137424;
    return volume;
  }
  public double getA() {
    return a;
  }
  public void set(ShapeColor sc, double a)
  {
    this.sc = sc;
    this.a = a;
  }
  
  @Override
  public String toString()
  {
	 
	  DecimalFormat df = new DecimalFormat("0.000");
	    return String.format("("+super.toString()+ "("+ sc + ","+ df.format(a)+ ")" +")");
  }

  
}
  
  


public class ShapesProgram{
  
  

	private static int getInt() //get random positive int
	{	int max = 15;
		int min = 1;
		
		Random irdm = new Random(); 
	
		   int randomNum = irdm.nextInt((max - min) + 1) + min;
		return randomNum;
	}
	private static double getDouble() //get random positive real number
	{
		double min = 0.000;
		double max = 14.999;
		double diff = max - min;
	
		
		double rand = min + Math.random( ) * diff;
		
		
		return rand;	
	}
	private static ShapeColor getColor() //get random color
	{
		return ShapeColor.getRandom();		
	}

  
	 
	  private static boolean isTriangle(int a,int b,int c) {//verifies the triangle's dimensions
		 
		  if(((a+b)>=c)&&((c+b)>=a)&&((c+a)>=b)){
			  return true;
		  }
		  else 
			  return false;
			  } 
    
    
  
  private static ArrayList<Shape> getTwoD() {//gets a random TwoD shape
	
	
	  ArrayList<Shape> alist1 = new ArrayList <Shape> ();
	  int one=getInt();
	  int two=getInt();
	  int three=getInt();
	
	
	alist1.add (new Circle (getColor(),getInt()));	
	alist1.add (new Rectangle (getColor(),getInt(),getInt()));	
	if(isTriangle(one,two,three) == true){
		
		alist1.add (new Triangle (getColor(),one,two,three));
	  }
	  else{
	  }

	alist1.add (new Trapezoid (getColor(),getInt(),getInt(),getInt(),getInt(),getInt()));
	 
	Collections.shuffle(alist1);
	 
	  
	 ArrayList<Shape> alist = new ArrayList <Shape> ();

		 
	 		alist.add(alist1.get(0));
	 		displayList(alist);
	
	 		return alist;
	
	  }
	
  
private static ArrayList<Shape> getThreeD() {//gets a random ThreeD shape
	DecimalFormat df = new DecimalFormat("0.000");
	 ArrayList<Shape> alist2 = new ArrayList <Shape> ();
	 double a = getDouble();
	 double b = getDouble();
	 double c = getDouble();
		
	 df.format(b);
	 df.format(c);
	alist2.add (new Sphere(getColor(),a));
	alist2.add (new Cube(getColor(),b));
	alist2.add (new Tetrahedron(getColor(),getDouble()));
	Collections.shuffle(alist2);
	 ArrayList<Shape> alist = new ArrayList <Shape> ();

	 
		alist.add(alist2.get(0));
		displayList(alist);
		return alist;
	  
  }
  
  
  private static void displayList(ArrayList<Shape>alist) {//if a shape is called , its details would be displayed
    for(Shape p : alist)
    {  
    	DecimalFormat df = new DecimalFormat("0.000");
	
      if (p instanceof Circle)
      {
        
      System.out.printf ("Circle ");
      System.out.println (p);
      System.out.printf("%s%n","Area = "+df.format(p.area ()));
      System.out.printf ("%s%n","I am a circle shape");
      System.out.println ("------------------------------");
      }
      if (p instanceof Rectangle)
      {
        
      System.out.printf ("Rectangle ");
      System.out.println (p);
      System.out.printf("%s%n","Area = "+df.format(p.area ()));
      System.out.printf ("%s%n","I am a rectangle shape");
      System.out.println ("------------------------------");

      }
      if (p instanceof Triangle)
      {
        
      System.out.printf ("Triangle ");
      System.out.println (p);
      System.out.printf("%s%n","Area = "+df.format(p.area ()));
      System.out.printf ("%s%n","I am a triangle shape");
      System.out.println ("------------------------------");
  
      }
      if (p instanceof Trapezoid)
      {
        
      System.out.printf ("Trapezoid ");
      System.out.println (p);
      System.out.printf("%s%n","Area = "+df.format(p.area ()));
      System.out.printf ("%s%n","I am a trapezoid shape");
      System.out.println ("------------------------------");
  
      }
      if (p instanceof Cube)
      {
        
      System.out.printf ("Cube ");
      System.out.println (p);
      System.out.printf("%s%n","Surface area = "+df.format((p.area ())));
      Cube vol = (Cube)(p);
      System.out.printf("%s%n","Volume = "+ df.format(vol.volume()));  
      Cube rs = (Cube)(p);
      System.out.printf("%s","Size reduced by 10%: cube ");  
      rs.resize();  
      System.out.printf("%s%n","Updated surface area = "+df.format(rs.area ()));
      System.out.printf("%s%n","Updated volume = "+ df.format(rs.volume()));  
      System.out.printf ("%s%n","I am a cube shape");
      System.out.println ("------------------------------");
           }
     
      if (p instanceof Sphere)	
		{
		System.out.printf ("Sphere ");
		System.out.println(p);
			
		System.out.printf("%s%n","Area = " + df.format((p.area())));
		Sphere vol = (Sphere)(p);
		System.out.printf("%s%n","Volume = " + df.format(vol.volume()));
		Sphere rs = (Sphere)(p);
		System.out.printf("%s","Size reduced by 10%: sphere ");  
		rs.resize();  
		System.out.printf("%s%n","Updated surface area = "+df.format(rs.area ()));
		System.out.printf("%s%n","Updated volume = "+ df.format(rs.volume()));  
		System.out.printf ("%s%n","I am a sphere shape");
		 System.out.println ("------------------------------");
		 }
	

		 if (p instanceof Tetrahedron)	
		{
			System.out.printf ("Tetrahedron ");
			System.out.println (p);
			Tetrahedron area = (Tetrahedron)(p);
			Tetrahedron vol = (Tetrahedron)(p);
			System.out.printf("%s%n","Area = " + df.format(area.area()));
			System.out.printf("%s%n","Volume = " + df.format(vol.volume()));
			Tetrahedron rs = (Tetrahedron)(p);
			System.out.printf("%s","Size reduced by 10%: tetrahedron ");  
			rs.resize();  
			System.out.printf("%s%n","Updated surface area = "+df.format(rs.area ()));
			System.out.printf("%s%n","Updated volume = "+ df.format(rs.volume()));  
			System.out.printf ("%s%n","I am a tetrahedron shape");
			 System.out.println ("------------------------------");
			
		}
      
    }		 
	 
	
      
  }
  
  public static void main(String[]args) {//main method
	
	  
		 
	  Random random = new Random();
	   
	for (int i = 1;; i++){
	int k = random.nextInt(3);
		  
	 if(k == 0) {
		 break; 
	 }
	 else  if(k == 1) {
		 System.out.printf ("%s","Shape "+i+": ");
		 getTwoD();
	 }
	 else  if(k == 2) {
		 System.out.printf ("%s","Shape "+i+": ");
		 getThreeD();
	 }

	
	}
		 

	  
  }
}
		
  
  
  
  
  
  

  

