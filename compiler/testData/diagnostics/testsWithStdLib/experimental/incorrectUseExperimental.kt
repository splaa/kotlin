// !DIAGNOSTICS: -UNUSED_PARAMETER -UNUSED_VARIABLE
// FILE: api.kt

package api

@Experimental(ExperimentalLevel.WARNING, ExperimentalScope.BINARY)
@Target(AnnotationTarget.PROPERTY)
annotation class BinaryExperimental

@BinaryExperimental
val x = ""

// FILE: usage.kt

import api.*

<!USE_EXPERIMENTAL_WITHOUT_ARGUMENTS!>@UseExperimental<!>
fun use1(): String {
    return <!EXPERIMENTAL_API_USAGE!>x<!>
}

<!USE_EXPERIMENTAL_ARGUMENT_HAS_BINARY_SCOPE!>@UseExperimental(BinaryExperimental::class)<!>
fun use2(): String {
    return <!EXPERIMENTAL_API_USAGE!>x<!>
}
