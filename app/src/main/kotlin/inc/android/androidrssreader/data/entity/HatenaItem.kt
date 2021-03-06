package inc.android.androidrssreader.data.entity

import org.simpleframework.xml.Element
import org.simpleframework.xml.Path
import org.simpleframework.xml.Root
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter

@Root(name = "item", strict = false)
class HatenaItem {
    @set:Element
    @get:Element
    var title: String? = null

    @set:Element
    @get:Element
    var link: String? = null

    @set:Element(required = false)
    @get:Element(required = false)
    var description: String? = null

    @Path("dc/date")
    @set:Element
    @get:Element
    var date: String? = null

    @Path("hatena/bookmarkcount")
    @set:Element
    @get:Element
    var bookmarkcount: Int = -1

    @Path("hatena/imageurl")
    @set:Element(required = false)
    @get:Element(required = false)
    var imageurl: String? = null

    val formattedDate: String
        get() {
            return LocalDateTime.parse(
                this.date,
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")
            ).format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"))
        }
}
