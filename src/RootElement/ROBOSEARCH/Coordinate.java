// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package RootElement.ROBOSEARCH;

import javax.vecmath.Vector3d;

/************************************************************/
/**
 * 
 */
public class Coordinate {
	/**
	 * 
	 */
	private CoordinateStatus coordinateStatus;
	/**
	 * 
	 *
	 */
	private Vector3d coordinate;

	/**
	 * 
	 * @param status 
	 * @return 
	 */
	//this function will be used to change status for coordinates when robots
	//decides to send coordinate with changed status. Also it can be used
	//by others classes if necessary for sending coordinates.
	//This may be used for updating map when necessary.
	public void setStatus(CoordinateStatus status) {
		this.coordinateStatus = status;
	}

	/**
	 * 
	 * @return 
	 */
	//This function returns X value of that Coordinate with respect to new origin
	public double getCoordinateX() {
		return (coordinate.x+12);
	}
	
	/**
	 * 
	 * @return 
	 */
	//This function returns Y value of that Coordinate with respect to new origin
	public double getCoordinateY() {
		return (coordinate.z+12);
	}
	
	/**
	 * 
	 * @return 
	 */
	public Vector3d getCoordinate() {
		return coordinate;
	}
	/**
	 * 
	 * @return 
	 */
	public CoordinateStatus getStatus() {
		return coordinateStatus;
	}
	/**
	 * @param Vector3d
	 * @return 
	 */
	public void changeCoordinate(Vector3d newCoordinate) {
        this.coordinate = newCoordinate;
        
    }
	/**
	 * 
	 * @param coordinates 
	 * @param status 
	 */
	//Constructor
	public Coordinate(Vector3d coordinates, CoordinateStatus status) {
		this.coordinate = coordinates;
		this.coordinateStatus = status;
	}

	/**
	 * 
	 * @return 
	 * @param coorX 
	 * @param coorY 
	 */
	//This function is created for adapter pattern. This is adaptee class
	//so the implementation of the function should be here.
	//There is a basic reason behind this(-12) convertion:
	//Since we decided to change origin of the map from middle to
	//top left and the map is 25x25 -12 would ensure that we have origin on decided place
	//also coorY has been used after second comma because Simbad simulator uses X and Z
	//for the plane(2D) that robots are placed.
	//IMPORTANT REMARKS:
	//1.if the map size is changed this "12" value must be changed accordingly
	//2.Also the array size that has been hardcooded in environment.java class must be changed as well.
	public Vector3d convertXYtoXYZ(double coorX, double coorY) {//converts coordinate in a way that origin is at top left
        Vector3d coordinate = new Vector3d(coorX-12,0,coorY-12);//temporary 3d vector
        return coordinate;
	}
    
};