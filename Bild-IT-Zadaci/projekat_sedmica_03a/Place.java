
package projekat_sedmica_03a;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 * 
 * Basic class for storing place from table and easy access and change.
 *
 */
public class Place {
	String value;
	public Place() {
		this("_");
	}
	public Place(String value) {
		this.value = value;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}

