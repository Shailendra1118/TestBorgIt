import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.Base64

import scala.util.Try
import scala.util.matching.Regex

object BorgItMain {

  case class JiraChangeDetail(field: String, toStatus: String)

  case class JiraChangeLog(author: String,
                           private val createdTimeString: String,
                           items: Seq[JiraChangeDetail]) {
    private val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    val createTime = ZonedDateTime.parse(createdTimeString, dateFormatter)
  }


  private val eventPattern = "^.*\\/events\\/(.{8}-.{4}-.{4}-.{4}-.{12})$".r



  // Main Method
  def main(args: Array[String]) {
    // prints Hello World
    println("Hello World!")

    def isTestMode: Boolean = None.isDefined
    println("Hello isTestMode: "+isTestMode)
    //getApprovalStatus()
    val prices: Seq[Double] = Seq(1.5, 2.0, 2.5)
    val sum = prices.fold(0.0)(_ + _)
    println(s"Sum :: $sum")

    type AppDirectProductOAuthDetails = Product2[String, String]
    val cred:Option[AppDirectProductOAuthDetails] = None // = Some("", "secret")

    cred.fold {
      println(s"\nInside fold")
    } {
      case cred => {
        println(s"\nInside cred: $cred")
      }
    }

    //new method
    //validate(Some("Basic cjd1SXZMSjk3Sjp1T1QyWG5yQThFMHIxbTBpTVR6Vg=="))

    // symbols

    val input = "https://mpa.userqa.apphelp.tools/mpa/subscription/test/apphelp-oauth2-test-product?eventUrl=https%3A%2F%2Fapphelpdemo.test.devappdirect.me%2Fapi%2Fintegration%2Fv1%2Fevents%2F93c70b82-42a0-4c88-8ce8-55d505b3006d"
    val input1 = "https://testcoxcomm.appdirect.com/api/integration/v1/events/69a42823-dd94-4d7e-bd67-b9f9a528aad1"
    testRegEx(input1);

  }


  def testRegEx(input: String) = {
    println(s"Inside testRegEx::::")

    val eventPattern = "^.*\\/events\\/(.{8}-.{4}-.{4}-.{4}-.{12})$".r

    val eventUrlPattern = "^.*\\/eventUrl=\\/(.{8}-.{4}-.{4}-.{4}-.{12})$".r
    val domain = eventUrlPattern.findFirstIn(input)
    //println(s"domain: $domain")

    val s = "Some(1234)"
    val pattern2 = """.*eventUrl=\[\s\S\]""".r
    val nums = "[0-9]".r
    //val Pattern(number) = s
    //println(nums.findAllIn(s).mkString)
    //println(pattern2.findFirstIn(input))

    val pattern = "Scala".r
    val str = "Scala is Scalable and cool"
    //println((pattern findFirstIn str).get)
    val res = eventPattern.matches(input)
    //println(res)

    //val index = input.indexOf("//api")
    val endIndex = input.indexOf("/api")
    //println(s"index= $index")
    println(s"endIndex= $endIndex")
    val substring = input.substring(0, endIndex)
    println(s"substring:: $substring")


    val marketplaceNameRegex: Regex = """^.*://(.*)/api/.*$""".r
    val marketplaceBaseUrlRegex: Regex = """^(.*)/api/.*$""".r

    input match {
      case MarketplaceName(marketplace) =>
        val name = "marketplace-" + marketplace
        println(s"name:: $name")

      case _ =>
        println(s"error...")
    }

    object MarketplaceName {
      def unapply(url: String): Option[String] =
        url match {
          case marketplaceBaseUrlRegex(name) => Some(name)
          case _ => None
        }
    }

  }




  def validate(header: Option[String]): Option[String] = {
    header match {
      case Some(header) =>
        header.split(" ").drop(1).headOption match {
         case Some(credentials) => {
           println(s"credentials: $credentials")
           //Some(s"Something: $password")
           new String(Base64.getDecoder.decode(credentials)).split(":").toList match {
             case username::password ::Nil => {
               println(s"Received username: $username, password: $password")
               //if("hello".equals(username) && "world".equals(password)) {
               if("testKey" == username && "testSecret" == password) {
                 println(s"Received correct username & password")
                 None
               }
               else {
                 println(s"Received in-correct username & password")
                 Some(s"provided username:[$username], expected:hello, provided password:[$password], expected:world ")
               }
             }
             case _=>{
               println(s"could not decode credentials from base64encoded string with Basic authoriz")
               Some(s"could not decode credentials from base64encoded string with Basic authoriz")
             }

           }
         }
         case _=>{
           println(s"Could not extract encoded credentials" )
           Some(s"Could not extract encoded credentials")
         }
       }
      case _ => {
        println(s"Empty credentials last")
        Some(s"Empty credentials last")
      }
    }
  }



  def decodeBase64(value: String): Option[String] =
    Try(Base64.getDecoder.decode(value)).toOption.map(new String(_))

}
