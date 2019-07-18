package w3task1;

import java.util.Calendar;
import java.util.Date;

public abstract class GeometricObject implements Comparable<GeometricObject> {
	  private String color = "white";
	  private boolean filled = false;
	  private Date dateCreated = Calendar.getInstance().getTime();

	  protected GeometricObject() {
	  }
	  
	  protected GeometricObject(String color, boolean filled) {
		    this.color = color;
		    this.filled = filled;
		  }
	  
	  public String getColor() {
	    return color;
	  }

	  public void setColor(String color) {
	    this.color = color;
	  }

	  public boolean isFilled() {
	    return filled;
	  }

	  public void setFilled(boolean filled) {
	    this.filled = filled;
	  }

	  public Date getDateCreated() {
		  return dateCreated;
	  }
	  
	  public abstract String toString();
	  public abstract double getArea();

	  public abstract double getPerimeter();
	}
