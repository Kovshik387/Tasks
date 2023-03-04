package Labs.Task7;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Task23 {

    public String transliteration(String original){

        StringBuilder result = new StringBuilder();

        Map<Character,String> dictionary = new HashMap<Character, String>(){{
            put('а',"a"); put('б',"b"); put('в',"v");put('г',"g"); put('д',"d");put('е',"e");
            put('ё',"e"); put('ж',"v");put('з',"z"); put('и',"i");put('й',"i"); put('к',"k");
            put('л',"l"); put('м',"m");put('н',"n"); put('о',"o");put('п',"p"); put('р',"r");
            put('с',"s"); put('т',"t");put('у',"u"); put('ф',"f");put('х',"kh"); put('ц',"ts");
            put('ч',"ch");put('ш',"ch");put('щ',"shch"); put('ы',"y");put('ъ',"ie"); put('э',"e");
            put('ю',"iu"); put('я',"ia");
        }};

        var words = original.split(" ");

        for (String word : words) {
            StringBuilder subString = new StringBuilder();
            StringBuilder point = new StringBuilder();
            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(word.length()-1) == '.') point.append(j);
                if (dictionary.containsKey(Character.toLowerCase(word.charAt(j)))){
                    if (Character.isUpperCase(word.charAt(j))) {
                        String str = dictionary.get(Character.toLowerCase(word.charAt(j)));
                        subString.append(str.substring(0,1).toUpperCase()).append(str.substring(1,str.length()));
                    }
                    else subString.append(dictionary.get(word.charAt(j)));
                }
            }
            result.append(subString).append(point).append(" ");
        }

        return result.toString();
    }

    public static void main(String[] args){

        String test = "Щикотно";

        System.out.println(new Task23().transliteration(test));

    }

}
