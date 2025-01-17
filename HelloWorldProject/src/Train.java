public class Train {
    private String name, product, origin, destination;
    private int weight, miles;
    public Train (String n, String p, String o, String d, int w, int m) {
        name = n;
        product = p;
        origin = o;
        destination = d;
        weight = w;
        miles = m;
    } // end car constructor

    public Train (String n, String d) {
        name = n;
        destination = d;
    } // end engine constructor

    public String getName(){
	    return this.name; 
    } // end getName

    public String getProduct(){
	    return this.product; 
    } // end getproduct

    public String getOrigin(){
	    return this.origin; 
    } // end getOrigin

    public String getDestination(){
	    return this.destination; 
    } // end getDestination

    public int getWeight(){
	    return this.weight; 
    } // end getWeight

    public int getMiles(){
	    return this.miles; 
    } // end getMiles

    public int setMiles(int x){
        this.miles = x;
	    return this.miles; 
    } // end getMiles

    public String toString(){
	    return ("Name: " + this.name + " Product: " + this.product + " Origin: " + this.origin + " Destination: " + this.destination + " Weight: " + this.weight + " Miles: " + this.miles);
    } // end getMiles
}
