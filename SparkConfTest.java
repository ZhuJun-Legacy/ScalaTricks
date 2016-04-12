import java.util.concurrent.ConcurrentHashMap;

class SparkConfTest {
    public static void main(String[] args) {
        SparkConf sc = new SparkConf().setMaster("local","127.0.0.0").setAny("spark.shuffle.max","40");
        System.out.println(sc.get("local"));
    }
}

class SparkConf {
    private static ConcurrentHashMap<String,String> setting = new ConcurrentHashMap<String,String>();

    SparkConf setMaster(String name, String value) {
        this.setAny(name,value);
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
