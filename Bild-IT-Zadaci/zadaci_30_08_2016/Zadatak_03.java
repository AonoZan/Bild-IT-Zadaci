
package zadaci_30_08_2016;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_03 {
	public static String formatSC(String sourceCode) {
		sourceCode = sourceCode.replace("\n{", " {");
		sourceCode = sourceCode.replace("\n\t{", " {");
		sourceCode = sourceCode.replace("\n {", " {");
		sourceCode = sourceCode.replace("\n  {", " {");
		return sourceCode;
	}
	public static void main(String[] args) {
		
		System.out.println(formatSC("asdasd\n{  \n}\nasdasd\n{  \n}"));
	}

}

