package Labs.Task8;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TreeNode {
        private String input;
        private int deep = 0;

        private List<Node> children = new ArrayList<>();
        public class Node{
            private String head;
            private List<String> body;
            private int deep;
            public Node(String head, List<String> body, int deep){
                this.head = head; this.body = body; this.deep = deep;
            }

            @Override
            public String toString(){
                return "Head: " + head + "\nBody: " + body.toString() + "\nDeep: " + deep +"\n----------------";
            }

        }

        public TreeNode(String input ) throws Exception {
            if (input.charAt(0) != '(' || input.charAt(input.length() -1 ) != ')') throw new Exception("Некорректные данные");
            else this.input = input;
            children = new ArrayList<>();
        }

        public List<Node> getChildren() {
            return children;
        }

        private void findThree(String str){
            List<String> children = new ArrayList<>();
            String word = "";

            for (int i = 0; i < str.length() ;i++){

                if (str.charAt(i) == '('){
                    if (!children.isEmpty()) this.children.add(new Node(children.get(0),children.subList(1,children.size()),deep));
                    deep++;
                    findThree(str.substring(i+1,str.length()));
                }


                if (str.charAt(i) != ' ' && str.charAt(i) != ',' && str.charAt(i) != ')' && str.charAt(i) != '('){
                    word += str.charAt(i);
                }
                else if (word != ""){
                    children.add(word);
                    word = "";
                }

                if (str.charAt(i) == ')'){
                    if (!children.isEmpty()) this.children.add(new Node(children.get(0),children.subList(1,children.size()),deep));
                    deep--;
                    findThree(str.substring(i+1,str.length()));
                }

                if (deep == 0) return;
            }
        }

        public void printThree(){
            this.findThree(this.input);
            var test = getChildren();

            for (var testItem : test){
                System.out.println(testItem.toString());
            }

            StringBuilder builder = new StringBuilder();
            boolean entry_two = false;

            for (int i = 0; i < test.size();i++){
                var item = test.get(i);
                if (item.deep == 1 && i == 0) builder.append(item.head).append("\n");

                if (item.deep > 2) {
                    builder.append("|");

                    int space_count = item.deep;


                    if (item.deep >= 5) space_count += 2;
                    if (item.deep == 4) space_count += 1;

                    builder.append(" ".repeat(item.deep % 4 == 0 ? item.deep -1 : item.deep -2));
                    builder.append("+-").append(item.head).append("\n");

                    for (int j = 0; j < item.body.size();j++){
                        builder.append("|").append(" ".repeat(space_count - 2)).append("|").append(" ").append("+-").append(item.body.get(j)).append("\n");
                    }
                }

                if (item.deep == 1){
                    if (!Objects.equals(item.head, test.get(0).head)) builder.append("+-").append(item.head).append("\n");
                    for (int j = 0; j < item.body.size();j++) builder.append("+-").append(item.body.get(j)).append("\n");
                }

                if (item.deep == 2){
                    if (!entry_two) {
                        builder.append("+-").append(item.head).append("\n");entry_two = true;}
                    else {
                        builder.append("| +-").append(item.head).append("\n");entry_two =false;};
                    for (int j = 0; j < item.body.size();j++){
                        builder.append("| +-").append(item.body.get(j)).append("\n");
                    }
                }

            }
            System.out.println(builder);
        }

}

