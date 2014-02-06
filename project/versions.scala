object VersionKeys {
  import sbt.settingKey

  val scalaParserCombinatorsVersion = settingKey[String]("The version of the Scala Parser Combinators to use.")
  val scalaXmlVersion = settingKey[String]("The version of the Scala XML to use.")
}
