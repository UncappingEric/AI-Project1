package view;

import java.awt.Color;

/**
 * Class representation of Cell node.
 *
 * @author Eric Cajuste
 * @author Thurgood Kilper
 */

import java.awt.Point;

public class Cell {
	//each cell uses 56 bytes of memory

	/**
	 * blocked 	= type 0
	 * open  	= type 1
	 * hard 	= type 2
	 */
	short type= 1;

	/**
	 * f = g (+ h)(* weight)
	 * g = cost to move to neighbor cell
	 * h = estimated distance from cell to goal
	 */

	double key;

	double f = Double.NaN, g = Double.NaN;

	double h;

	boolean path = false, route = false;
	Point self = null;
	Color c = null;
	Cell parent;

	public Cell(int x, int y){
		self = new Point(x,y);
	}

	public Cell copy(){
		Cell c = new Cell(self.x,self.y);
		c.type = type;
		c.parent = parent;
		c.path = path;
		c.route = route;
		c.h = h; c.f = f; c.g = g;

		return c;
	}

	//compare cells by point coordinates
	@Override
	public boolean equals(Object o){
		if(!(o instanceof Cell))
			return false;
		Cell c = (Cell) o;
		return c.self.equals(self);
	}

	//determine hash code by point coordinates
	@Override
	public int hashCode(){
		int hash = self.x * 1000 + self.y;
		return hash;
	}
}
