package task3;

import com.google.gson.*;

import java.io.FileReader;
import java.util.List;


public class task3 {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Укажите пути к файлам values.json, tests.json и report.json.");
            return;
        }
        String valuesP = args[0];
        String testsP = args[1];
        String reportP = args[2];

//        String valuesP = "C:\\Users\\Fer\\IdeaProjects\\TestTaskPerformanceLab\\src\\main\\java\\task3\\values.json";
//        String testsP = "C:\\Users\\Fer\\IdeaProjects\\TestTaskPerformanceLab\\src\\main\\java\\task3\\tests.json";
//        String reportP = "C:\\Users\\Fer\\IdeaProjects\\TestTaskPerformanceLab\\src\\main\\java\\task3\\report.json";

        GsonParser parser = new GsonParser();
        Root root = parser.parse();
        System.out.println("root pars =-=-=-=-  " + root.toString());
    }

    public static class GsonParser{
        public Root parse(){
            Gson gson = new Gson();

            try{
                FileReader readerValues =  new FileReader("C:\\Users\\Fer\\IdeaProjects\\TestTaskPerformanceLab\\src\\main\\java\\task3\\values.json");
                Root rootValues = gson.fromJson(readerValues, Root.class);
                return rootValues;
            }catch (Exception e){
                System.out.println("Parser error " + e.toString());
            }
            return null;
        }
    }

    public class Root{
        public List<Value> values;
        public List<Value> getValues(){return values;}
        public void setValues(List<Value> values){
            this.values = values;
        }
        @Override
        public String toString(){
            return "Root{" +
                    "values=" + values +
                    '}';
        }
    }
    public class Value{
        public int id;
        public String value;
        public Value(int id, String value){
            this.id = id;
            this.value =value;
        }
        public int getId(){
            return id;
        }
        public String getValue(){
            return value;
        }
        @Override
        public String toString(){
            return "values{" +
                    "id='" + id + '\'' +
                    ", value=" + value +
                    '}';
        }
    }

}
