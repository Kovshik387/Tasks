package Labs.Task7;

import Labs.Utility.FileStream;

public class Task22 {
    public String Coding(String original){

        StringBuilder result = new StringBuilder();

        var words = original.split(" ");

        for (String word : words) {
            StringBuilder subString = new StringBuilder();
            StringBuilder point = new StringBuilder();
            for (int j = word.length() - 1; j >= 0; j--) {

                if (word.contains("+") || word.contains("#")){
                    subString.append(word);
                    break;
                }

                if (word.charAt(j) == '.' || word.charAt(j) == ',') point.append(word.charAt(j));
                else subString.append(word.charAt(j));

            }
            result.append(subString).append(point).append(" ");
        }
        return result.toString();
    }

    public static void main(String[] args){

        String test = "";
        for (var item : new FileStream().<String>readArray("Input//InputStringTask11").get(0)) test += item + " ";

        System.out.println(test);

        System.out.println(new Task22().Coding(test));
    }

}
