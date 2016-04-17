import java.util.concurrent.ConcurrentHashMap;

class SparkConfTest {
    public static void main(String[] args) {
        SparkConf sc = new SparkConf().setMaster("local[2]").setAny("spark.shuffle.max","40");
        System.out.println(sc.get("spark.master"));
    }
}

class SparkConf {
    private static ConcurrentHashMap<String,String> setting = new ConcurrentHashMap<String,String>();

    SparkConf setMaster(String value) {
        this.setAny("spark.master",value);
        return this;
    }

    SparkConf setAny(String name, String value) {
        setting.put(name,value);
        return this;
    }

    String get(String name) {
        return setting.get(name);
    }
}
