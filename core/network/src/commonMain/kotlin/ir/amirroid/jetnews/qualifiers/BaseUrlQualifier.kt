package ir.amirroid.jetnews.qualifiers

import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.QualifierValue

object BaseUrlQualifier : Qualifier {
    override val value: QualifierValue
        get() = "base_url"
}
