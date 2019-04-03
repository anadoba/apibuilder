/**
 * Generated by API Builder - https://www.apibuilder.io
 * Service version: 0.14.70
 * apibuilder 0.14.75 app.apibuilder.io/apicollective/apibuilder-internal/0.14.70/play_2_x_json
 */
package io.apibuilder.internal.v0.models {

  sealed trait TaskData extends _root_.scala.Product with _root_.scala.Serializable

  /**
   * @param numberAttempts Records the number of times we have attempted to run this task. Commonly we
   *        increment number attempts, process the task, and if succeeds we then delete the
   *        task. If it fails, we update last_error. This allows us to retry a task say
   *        twice; after which we no longer process the task (can notify an admin of the
   *        error).
   */
  final case class Task(
    guid: _root_.java.util.UUID,
    data: io.apibuilder.internal.v0.models.TaskData,
    numberAttempts: Long = 0L,
    lastError: _root_.scala.Option[String] = None
  )

  final case class TaskDataDiffVersion(
    oldVersionGuid: _root_.java.util.UUID,
    newVersionGuid: _root_.java.util.UUID
  ) extends TaskData

  final case class TaskDataIndexApplication(
    applicationGuid: _root_.java.util.UUID
  ) extends TaskData

  /**
   * Provides future compatibility in clients - in the future, when a type is added
   * to the union TaskData, it will need to be handled in the client code. This
   * implementation will deserialize these future types as an instance of this class.
   * 
   * @param description Information about the type that we received that is undefined in this version of
   *        the client.
   */
  final case class TaskDataUndefinedType(
    description: String
  ) extends TaskData

}

package io.apibuilder.internal.v0.models {

  package object json {
    import play.api.libs.json.__
    import play.api.libs.json.JsString
    import play.api.libs.json.Writes
    import play.api.libs.functional.syntax._
    import io.apibuilder.internal.v0.models.json._

    private[v0] implicit val jsonReadsUUID = __.read[String].map(java.util.UUID.fromString)

    private[v0] implicit val jsonWritesUUID = new Writes[java.util.UUID] {
      def writes(x: java.util.UUID) = JsString(x.toString)
    }

    private[v0] implicit val jsonReadsJodaDateTime = __.read[String].map { str =>
      import org.joda.time.format.ISODateTimeFormat.dateTimeParser
      dateTimeParser.parseDateTime(str)
    }

    private[v0] implicit val jsonWritesJodaDateTime = new Writes[org.joda.time.DateTime] {
      def writes(x: org.joda.time.DateTime) = {
        import org.joda.time.format.ISODateTimeFormat.dateTime
        val str = dateTime.print(x)
        JsString(str)
      }
    }

    private[v0] implicit val jsonReadsJodaLocalDate = __.read[String].map { str =>
      import org.joda.time.format.ISODateTimeFormat.dateParser
      dateParser.parseLocalDate(str)
    }

    private[v0] implicit val jsonWritesJodaLocalDate = new Writes[org.joda.time.LocalDate] {
      def writes(x: org.joda.time.LocalDate) = {
        import org.joda.time.format.ISODateTimeFormat.date
        val str = date.print(x)
        JsString(str)
      }
    }

    implicit def jsonReadsApibuilderInternalTask: play.api.libs.json.Reads[Task] = {
      for {
        guid <- (__ \ "guid").read[_root_.java.util.UUID]
        data <- (__ \ "data").read[io.apibuilder.internal.v0.models.TaskData]
        numberAttempts <- (__ \ "number_attempts").read[Long]
        lastError <- (__ \ "last_error").readNullable[String]
      } yield Task(guid, data, numberAttempts, lastError)
    }

    def jsObjectTask(obj: io.apibuilder.internal.v0.models.Task): play.api.libs.json.JsObject = {
      play.api.libs.json.Json.obj(
        "guid" -> play.api.libs.json.JsString(obj.guid.toString),
        "data" -> jsObjectTaskData(obj.data),
        "number_attempts" -> play.api.libs.json.JsNumber(obj.numberAttempts)
      ) ++ (obj.lastError match {
        case None => play.api.libs.json.Json.obj()
        case Some(x) => play.api.libs.json.Json.obj("last_error" -> play.api.libs.json.JsString(x))
      })
    }

    implicit def jsonWritesApibuilderInternalTask: play.api.libs.json.Writes[Task] = {
      new play.api.libs.json.Writes[io.apibuilder.internal.v0.models.Task] {
        def writes(obj: io.apibuilder.internal.v0.models.Task) = {
          jsObjectTask(obj)
        }
      }
    }

    implicit def jsonReadsApibuilderInternalTaskDataDiffVersion: play.api.libs.json.Reads[TaskDataDiffVersion] = {
      for {
        oldVersionGuid <- (__ \ "old_version_guid").read[_root_.java.util.UUID]
        newVersionGuid <- (__ \ "new_version_guid").read[_root_.java.util.UUID]
      } yield TaskDataDiffVersion(oldVersionGuid, newVersionGuid)
    }

    def jsObjectTaskDataDiffVersion(obj: io.apibuilder.internal.v0.models.TaskDataDiffVersion): play.api.libs.json.JsObject = {
      play.api.libs.json.Json.obj(
        "old_version_guid" -> play.api.libs.json.JsString(obj.oldVersionGuid.toString),
        "new_version_guid" -> play.api.libs.json.JsString(obj.newVersionGuid.toString)
      )
    }

    implicit def jsonReadsApibuilderInternalTaskDataIndexApplication: play.api.libs.json.Reads[TaskDataIndexApplication] = {
      (__ \ "application_guid").read[_root_.java.util.UUID].map { x => new TaskDataIndexApplication(applicationGuid = x) }
    }

    def jsObjectTaskDataIndexApplication(obj: io.apibuilder.internal.v0.models.TaskDataIndexApplication): play.api.libs.json.JsObject = {
      play.api.libs.json.Json.obj(
        "application_guid" -> play.api.libs.json.JsString(obj.applicationGuid.toString)
      )
    }

    implicit def jsonReadsApibuilderInternalTaskData: play.api.libs.json.Reads[TaskData] = {
      (
        (__ \ "task_data_index_application").read(jsonReadsApibuilderInternalTaskDataIndexApplication).asInstanceOf[play.api.libs.json.Reads[TaskData]]
        orElse
        (__ \ "task_data_diff_version").read(jsonReadsApibuilderInternalTaskDataDiffVersion).asInstanceOf[play.api.libs.json.Reads[TaskData]]
        orElse
        play.api.libs.json.Reads(jsValue => play.api.libs.json.JsSuccess(io.apibuilder.internal.v0.models.TaskDataUndefinedType(jsValue.toString))).asInstanceOf[play.api.libs.json.Reads[TaskData]]
      )
    }

    def jsObjectTaskData(obj: io.apibuilder.internal.v0.models.TaskData): play.api.libs.json.JsObject = {
      obj match {
        case x: io.apibuilder.internal.v0.models.TaskDataIndexApplication => play.api.libs.json.Json.obj("task_data_index_application" -> jsObjectTaskDataIndexApplication(x))
        case x: io.apibuilder.internal.v0.models.TaskDataDiffVersion => play.api.libs.json.Json.obj("task_data_diff_version" -> jsObjectTaskDataDiffVersion(x))
        case x: io.apibuilder.internal.v0.models.TaskDataUndefinedType => sys.error(s"The type[io.apibuilder.internal.v0.models.TaskDataUndefinedType] should never be serialized")
      }
    }

    implicit def jsonWritesApibuilderInternalTaskData: play.api.libs.json.Writes[TaskData] = {
      new play.api.libs.json.Writes[io.apibuilder.internal.v0.models.TaskData] {
        def writes(obj: io.apibuilder.internal.v0.models.TaskData) = {
          jsObjectTaskData(obj)
        }
      }
    }
  }
}

package io.apibuilder.internal.v0 {

  object Bindables {

    import play.api.mvc.{PathBindable, QueryStringBindable}

    // import models directly for backwards compatibility with prior versions of the generator
    import Core._

    object Core {
      implicit def pathBindableDateTimeIso8601(implicit stringBinder: QueryStringBindable[String]): PathBindable[_root_.org.joda.time.DateTime] = ApibuilderPathBindable(ApibuilderTypes.dateTimeIso8601)
      implicit def queryStringBindableDateTimeIso8601(implicit stringBinder: QueryStringBindable[String]): QueryStringBindable[_root_.org.joda.time.DateTime] = ApibuilderQueryStringBindable(ApibuilderTypes.dateTimeIso8601)

      implicit def pathBindableDateIso8601(implicit stringBinder: QueryStringBindable[String]): PathBindable[_root_.org.joda.time.LocalDate] = ApibuilderPathBindable(ApibuilderTypes.dateIso8601)
      implicit def queryStringBindableDateIso8601(implicit stringBinder: QueryStringBindable[String]): QueryStringBindable[_root_.org.joda.time.LocalDate] = ApibuilderQueryStringBindable(ApibuilderTypes.dateIso8601)
    }

    trait ApibuilderTypeConverter[T] {

      def convert(value: String): T

      def convert(value: T): String

      def example: T

      def validValues: Seq[T] = Nil

      def errorMessage(key: String, value: String, ex: java.lang.Exception): String = {
        val base = s"Invalid value '$value' for parameter '$key'. "
        validValues.toList match {
          case Nil => base + "Ex: " + convert(example)
          case values => base + ". Valid values are: " + values.mkString("'", "', '", "'")
        }
      }
    }

    object ApibuilderTypes {
      import org.joda.time.{format, DateTime, LocalDate}

      val dateTimeIso8601: ApibuilderTypeConverter[DateTime] = new ApibuilderTypeConverter[DateTime] {
        override def convert(value: String): DateTime = format.ISODateTimeFormat.dateTimeParser.parseDateTime(value)
        override def convert(value: DateTime): String = format.ISODateTimeFormat.dateTime.print(value)
        override def example: DateTime = DateTime.now
      }

      val dateIso8601: ApibuilderTypeConverter[LocalDate] = new ApibuilderTypeConverter[LocalDate] {
        override def convert(value: String): LocalDate = format.ISODateTimeFormat.yearMonthDay.parseLocalDate(value)
        override def convert(value: LocalDate): String = value.toString
        override def example: LocalDate = LocalDate.now
      }

    }

    final case class ApibuilderQueryStringBindable[T](
      converters: ApibuilderTypeConverter[T]
    ) extends QueryStringBindable[T] {

      override def bind(key: String, params: Map[String, Seq[String]]): _root_.scala.Option[_root_.scala.Either[String, T]] = {
        params.getOrElse(key, Nil).headOption.map { v =>
          try {
            Right(
              converters.convert(v)
            )
          } catch {
            case ex: java.lang.Exception => Left(
              converters.errorMessage(key, v, ex)
            )
          }
        }
      }

      override def unbind(key: String, value: T): String = {
        s"$key=${converters.convert(value)}"
      }
    }

    final case class ApibuilderPathBindable[T](
      converters: ApibuilderTypeConverter[T]
    ) extends PathBindable[T] {

      override def bind(key: String, value: String): _root_.scala.Either[String, T] = {
        try {
          Right(
            converters.convert(value)
          )
        } catch {
          case ex: java.lang.Exception => Left(
            converters.errorMessage(key, value, ex)
          )
        }
      }

      override def unbind(key: String, value: T): String = {
        converters.convert(value)
      }
    }

  }

}
