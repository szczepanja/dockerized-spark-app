import org.apache.spark.sql.SparkSession

object ReadFromDir {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession
      .builder()
      .appName("Spark read CSV from HDFS")
      .master("local[*]")
      .getOrCreate()

    val df = spark
      .read
      .text("build.sbt")

    df.show()

  }
}
