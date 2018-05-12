package testcase.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestReplaceMacro {
	public static void main(String[] args) {
		String script = "\"ay=<#=etr#>\"" + "\r\n"
				+ "+\"&ac=<#=etr#>&sc=<#=etr#>\"";
		Pattern p = Pattern.compile("(<#=[^<##>]*#>)+");
		Matcher matcher = p.matcher(script);
		String quote = "\'";
		int start = 0, end = -1, firstIndex = 0, count = 0;
		StringBuilder sb = new StringBuilder();
		if (matcher.find()) {
			start = matcher.start();
			end = matcher.end();
			String segment = script.substring(firstIndex, start);
			sb.append(segment);
			if (script.substring(0,start).lastIndexOf('\"') >= 0) {
				quote = "\"";
			}
			sb.append(quote);
			sb.append("+ cell.marrArr["+ (count++) +"]");
			firstIndex = end + 1 ;
		}
		
		while (matcher.find()) {
			start = matcher.start();
			end = matcher.end();
			String segment = script.substring(firstIndex, start);
			if (sb.length() > 0 && segment.indexOf('+') < 0) {
				sb.append("+");
				sb.append(quote);
			}
			sb.append(segment);
			sb.append(quote);
			sb.append("+ cell.marrArr["+ (count++) +"]");
			firstIndex = end ;
		}
		String segment = script.substring(firstIndex);
		if (!segment.equals(quote)) {
			sb.append("+");
			sb.append(quote);
			sb.append(segment);
		}
	}
}
