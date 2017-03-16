package free

import common._

import scala.concurrent._
import scala.concurrent.duration.Duration
import scala.concurrent.ExecutionContext.Implicits.global

import cats.instances.future._

/**
 * An example of executing a program using an interpreter
 */
object Example extends App {

  import Programs._
  
  val future: Future[Photo] = 
    saveAndThenGetPhoto(PhotoId("abc"), "Chris", "yolo".getBytes)
      .foldMap(Interpreters.futureInterpreter)
  
  println(Await.result(future, atMost = Duration.Inf))


}
