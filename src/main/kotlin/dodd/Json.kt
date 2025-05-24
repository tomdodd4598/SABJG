package dodd

class Builder(private val internal: StringBuilder, private val indentation: String) {

    constructor() : this(StringBuilder(), "")

    fun inner() = Builder(internal, "\t$indentation")

    fun append(obj: Any, indent: Boolean) {
        if (indent) {
            internal.append(indentation)
        }
        internal.append(obj)
    }

    fun shrink(count: Int) {
        internal.setLength(internal.length - count)
    }

    override fun toString() = internal.toString()
}

abstract class JsonElement {

    abstract fun addToString(builder: Builder, indent: Boolean)
}

class JsonObject(vararg pairs: Pair<String, JsonElement>) : JsonElement() {

    private val internal = pairs.toMap()

    override fun addToString(builder: Builder, indent: Boolean) {
        if (internal.isEmpty()) {
            builder.append("{}", indent)
            return
        }

        builder.append("{\n", indent)

        val inner = builder.inner()
        for ((k, v) in internal) {
            inner.append("\"$k\": ", true)
            v.addToString(inner, false)
            builder.append(",\n", false)
        }
        builder.shrink(2)
        builder.append("\n", false)

        builder.append("}", true)
    }
}

class JsonArray(vararg elems: JsonElement) : JsonElement() {

    private val internal = elems.toList()

    override fun addToString(builder: Builder, indent: Boolean) {
        if (internal.isEmpty()) {
            builder.append("[]", indent)
            return
        }

        builder.append("[\n", indent)

        val inner = builder.inner()
        for (e in internal) {
            e.addToString(inner, true)
            builder.append(",\n", false)
        }
        builder.shrink(2)
        builder.append("\n", false)

        builder.append("]", true)
    }
}

abstract class JsonValue<T>(protected val value: T) : JsonElement() {

    override fun addToString(builder: Builder, indent: Boolean) {
        builder.append(toString(), indent)
    }

    abstract override fun toString(): String
}

class JsonNumber(value: Number) : JsonValue<Number>(value) {

    override fun toString() = value.toString()
}

class JsonString(value: String) : JsonValue<String>(value) {

    override fun toString() = "\"$value\""
}

class JsonBoolean(value: Boolean) : JsonValue<Boolean>(value) {

    override fun toString() = value.toString()
}

object JsonNull : JsonElement() {

    override fun addToString(builder: Builder, indent: Boolean) {
        builder.append("null", indent)
    }
}

val Number?.elem get() = if (this == null) JsonNull else JsonNumber(this)

val String?.elem get() = if (this == null) JsonNull else JsonString(this)

val Boolean?.elem get() = if (this == null) JsonNull else JsonBoolean(this)

private fun forceValue(value: Any?) = when(value) {
    null -> JsonNull
    is JsonElement -> value
    is Number -> value.elem
    is String -> value.elem
    is Boolean -> value.elem
    else -> throw IllegalArgumentException("Invalid JSON value \"$value\" of type \"${value.javaClass.simpleName}\"!")
}

private fun forcePairs(vararg pairs: Pair<String, Any?>) = Array(pairs.size) {
    val pair = pairs[it]
    pair.first to forceValue(pair.second)
}

fun json(vararg pairs: Pair<String, Any?>): String {
    val builder = Builder()
    JsonObject(*forcePairs(*pairs)).addToString(builder, false)
    builder.append("\n", false)
    return builder.toString()
}

fun obj(vararg pairs: Pair<String, Any?>) = JsonObject(*forcePairs(*pairs))

fun arr(vararg elems: Any?) = JsonArray(*Array(elems.size) { forceValue(elems[it]) })
