/**
 * Generated by apidoc - http://www.apidoc.me
 * apidoc:0.7.36 http://www.apidoc.me/gilt/apidoc-spec/0.0.1-dev/play_2_x_json
 */
package com.gilt.apidocspec.models {

  case class Body(
    `type`: String,
    description: scala.Option[String] = None
  )

  case class Enum(
    description: scala.Option[String] = None,
    values: Seq[com.gilt.apidocspec.models.EnumValue]
  )

  case class EnumValue(
    name: String,
    description: scala.Option[String] = None
  )

  case class Field(
    name: String,
    `type`: String,
    description: scala.Option[String] = None,
    required: scala.Option[Boolean] = None,
    example: scala.Option[String] = None,
    minimum: scala.Option[Long] = None,
    maximum: scala.Option[Long] = None
  )

  case class Header(
    name: String,
    `type`: String,
    description: scala.Option[String] = None,
    required: Boolean,
    default: scala.Option[String] = None
  )

  case class Model(
    plural: scala.Option[String] = None,
    description: scala.Option[String] = None,
    fields: Seq[com.gilt.apidocspec.models.Field]
  )

  case class Operation(
    method: String,
    path: scala.Option[String] = None,
    description: scala.Option[String] = None,
    body: scala.Option[com.gilt.apidocspec.models.Body] = None,
    parameter: Seq[com.gilt.apidocspec.models.Parameter] = Nil,
    responses: Map[String, com.gilt.apidocspec.models.Response] = Map.empty
  )

  case class Parameter(
    name: String,
    `type`: String,
    description: scala.Option[String] = None,
    required: scala.Option[Boolean] = None,
    default: scala.Option[String] = None,
    example: scala.Option[String] = None
  )

  case class Resource(
    path: scala.Option[String] = None,
    operations: Seq[com.gilt.apidocspec.models.Operation]
  )

  case class Response(
    `type`: String
  )

  case class Service(
    name: String,
    baseUrl: String,
    description: scala.Option[String] = None,
    headers: Seq[com.gilt.apidocspec.models.Header],
    enums: Map[String, com.gilt.apidocspec.models.Enum],
    models: Map[String, com.gilt.apidocspec.models.Model],
    resources: Map[String, com.gilt.apidocspec.models.Resource]
  )

}

package com.gilt.apidocspec.models {
  package object json {
    import play.api.libs.json.__
    import play.api.libs.json.JsString
    import play.api.libs.json.Writes
    import play.api.libs.functional.syntax._

    private[apidocspec] implicit val jsonReadsUUID = __.read[String].map(java.util.UUID.fromString)

    private[apidocspec] implicit val jsonWritesUUID = new Writes[java.util.UUID] {
      def writes(x: java.util.UUID) = JsString(x.toString)
    }

    private[apidocspec] implicit val jsonReadsJodaDateTime = __.read[String].map { str =>
      import org.joda.time.format.ISODateTimeFormat.dateTimeParser
      dateTimeParser.parseDateTime(str)
    }

    private[apidocspec] implicit val jsonWritesJodaDateTime = new Writes[org.joda.time.DateTime] {
      def writes(x: org.joda.time.DateTime) = {
        import org.joda.time.format.ISODateTimeFormat.dateTime
        val str = dateTime.print(x)
        JsString(str)
      }
    }


    implicit def jsonReadsApidocspecBody: play.api.libs.json.Reads[Body] = {
      (
        (__ \ "type").read[String] and
        (__ \ "description").readNullable[String]
      )(Body.apply _)
    }

    implicit def jsonWritesApidocspecBody: play.api.libs.json.Writes[Body] = {
      (
        (__ \ "type").write[String] and
        (__ \ "description").write[scala.Option[String]]
      )(unlift(Body.unapply _))
    }

    implicit def jsonReadsApidocspecEnum: play.api.libs.json.Reads[Enum] = {
      (
        (__ \ "description").readNullable[String] and
        (__ \ "values").readNullable[Seq[com.gilt.apidocspec.models.EnumValue]].map(_.getOrElse(Nil))
      )(Enum.apply _)
    }

    implicit def jsonWritesApidocspecEnum: play.api.libs.json.Writes[Enum] = {
      (
        (__ \ "description").write[scala.Option[String]] and
        (__ \ "values").write[Seq[com.gilt.apidocspec.models.EnumValue]]
      )(unlift(Enum.unapply _))
    }

    implicit def jsonReadsApidocspecEnumValue: play.api.libs.json.Reads[EnumValue] = {
      (
        (__ \ "name").read[String] and
        (__ \ "description").readNullable[String]
      )(EnumValue.apply _)
    }

    implicit def jsonWritesApidocspecEnumValue: play.api.libs.json.Writes[EnumValue] = {
      (
        (__ \ "name").write[String] and
        (__ \ "description").write[scala.Option[String]]
      )(unlift(EnumValue.unapply _))
    }

    implicit def jsonReadsApidocspecField: play.api.libs.json.Reads[Field] = {
      (
        (__ \ "name").read[String] and
        (__ \ "type").read[String] and
        (__ \ "description").readNullable[String] and
        (__ \ "required").readNullable[Boolean] and
        (__ \ "example").readNullable[String] and
        (__ \ "minimum").readNullable[Long] and
        (__ \ "maximum").readNullable[Long]
      )(Field.apply _)
    }

    implicit def jsonWritesApidocspecField: play.api.libs.json.Writes[Field] = {
      (
        (__ \ "name").write[String] and
        (__ \ "type").write[String] and
        (__ \ "description").write[scala.Option[String]] and
        (__ \ "required").write[scala.Option[Boolean]] and
        (__ \ "example").write[scala.Option[String]] and
        (__ \ "minimum").write[scala.Option[Long]] and
        (__ \ "maximum").write[scala.Option[Long]]
      )(unlift(Field.unapply _))
    }

    implicit def jsonReadsApidocspecHeader: play.api.libs.json.Reads[Header] = {
      (
        (__ \ "name").read[String] and
        (__ \ "type").read[String] and
        (__ \ "description").readNullable[String] and
        (__ \ "required").read[Boolean] and
        (__ \ "default").readNullable[String]
      )(Header.apply _)
    }

    implicit def jsonWritesApidocspecHeader: play.api.libs.json.Writes[Header] = {
      (
        (__ \ "name").write[String] and
        (__ \ "type").write[String] and
        (__ \ "description").write[scala.Option[String]] and
        (__ \ "required").write[Boolean] and
        (__ \ "default").write[scala.Option[String]]
      )(unlift(Header.unapply _))
    }

    implicit def jsonReadsApidocspecModel: play.api.libs.json.Reads[Model] = {
      (
        (__ \ "plural").readNullable[String] and
        (__ \ "description").readNullable[String] and
        (__ \ "fields").readNullable[Seq[com.gilt.apidocspec.models.Field]].map(_.getOrElse(Nil))
      )(Model.apply _)
    }

    implicit def jsonWritesApidocspecModel: play.api.libs.json.Writes[Model] = {
      (
        (__ \ "plural").write[scala.Option[String]] and
        (__ \ "description").write[scala.Option[String]] and
        (__ \ "fields").write[Seq[com.gilt.apidocspec.models.Field]]
      )(unlift(Model.unapply _))
    }

    implicit def jsonReadsApidocspecOperation: play.api.libs.json.Reads[Operation] = {
      (
        (__ \ "method").read[String] and
        (__ \ "path").readNullable[String] and
        (__ \ "description").readNullable[String] and
        (__ \ "body").readNullable[com.gilt.apidocspec.models.Body] and
        (__ \ "parameter").readNullable[Seq[com.gilt.apidocspec.models.Parameter]].map(_.getOrElse(Nil)) and
        (__ \ "responses").readNullable[Map[String, com.gilt.apidocspec.models.Response]].map(_.getOrElse(Map.empty))
      )(Operation.apply _)
    }

    implicit def jsonWritesApidocspecOperation: play.api.libs.json.Writes[Operation] = {
      (
        (__ \ "method").write[String] and
        (__ \ "path").write[scala.Option[String]] and
        (__ \ "description").write[scala.Option[String]] and
        (__ \ "body").write[scala.Option[com.gilt.apidocspec.models.Body]] and
        (__ \ "parameter").write[Seq[com.gilt.apidocspec.models.Parameter]] and
        (__ \ "responses").write[Map[String, com.gilt.apidocspec.models.Response]]
      )(unlift(Operation.unapply _))
    }

    implicit def jsonReadsApidocspecParameter: play.api.libs.json.Reads[Parameter] = {
      (
        (__ \ "name").read[String] and
        (__ \ "type").read[String] and
        (__ \ "description").readNullable[String] and
        (__ \ "required").readNullable[Boolean] and
        (__ \ "default").readNullable[String] and
        (__ \ "example").readNullable[String]
      )(Parameter.apply _)
    }

    implicit def jsonWritesApidocspecParameter: play.api.libs.json.Writes[Parameter] = {
      (
        (__ \ "name").write[String] and
        (__ \ "type").write[String] and
        (__ \ "description").write[scala.Option[String]] and
        (__ \ "required").write[scala.Option[Boolean]] and
        (__ \ "default").write[scala.Option[String]] and
        (__ \ "example").write[scala.Option[String]]
      )(unlift(Parameter.unapply _))
    }

    implicit def jsonReadsApidocspecResource: play.api.libs.json.Reads[Resource] = {
      (
        (__ \ "path").readNullable[String] and
        (__ \ "operations").readNullable[Seq[com.gilt.apidocspec.models.Operation]].map(_.getOrElse(Nil))
      )(Resource.apply _)
    }

    implicit def jsonWritesApidocspecResource: play.api.libs.json.Writes[Resource] = {
      (
        (__ \ "path").write[scala.Option[String]] and
        (__ \ "operations").write[Seq[com.gilt.apidocspec.models.Operation]]
      )(unlift(Resource.unapply _))
    }

    implicit def jsonReadsApidocspecResponse: play.api.libs.json.Reads[Response] = {
      (__ \ "type").read[String].map { x => new Response(`type` = x) }
    }

    implicit def jsonWritesApidocspecResponse: play.api.libs.json.Writes[Response] = new play.api.libs.json.Writes[Response] {
      def writes(x: Response) = play.api.libs.json.Json.obj(
        "type" -> play.api.libs.json.Json.toJson(x.`type`)
      )
    }

    implicit def jsonReadsApidocspecService: play.api.libs.json.Reads[Service] = {
      (
        (__ \ "name").read[String] and
        (__ \ "base_url").read[String] and
        (__ \ "description").readNullable[String] and
        (__ \ "headers").readNullable[Seq[com.gilt.apidocspec.models.Header]].map(_.getOrElse(Nil)) and
        (__ \ "enums").readNullable[Map[String, com.gilt.apidocspec.models.Enum]].map(_.getOrElse(Map.empty)) and
        (__ \ "models").readNullable[Map[String, com.gilt.apidocspec.models.Model]].map(_.getOrElse(Map.empty)) and
        (__ \ "resources").readNullable[Map[String, com.gilt.apidocspec.models.Resource]].map(_.getOrElse(Map.empty))
      )(Service.apply _)
    }

    implicit def jsonWritesApidocspecService: play.api.libs.json.Writes[Service] = {
      (
        (__ \ "name").write[String] and
        (__ \ "base_url").write[String] and
        (__ \ "description").write[scala.Option[String]] and
        (__ \ "headers").write[Seq[com.gilt.apidocspec.models.Header]] and
        (__ \ "enums").write[Map[String, com.gilt.apidocspec.models.Enum]] and
        (__ \ "models").write[Map[String, com.gilt.apidocspec.models.Model]] and
        (__ \ "resources").write[Map[String, com.gilt.apidocspec.models.Resource]]
      )(unlift(Service.unapply _))
    }
  }
}

