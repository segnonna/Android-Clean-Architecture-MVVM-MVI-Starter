package hos.houns.domain.base.validator

interface FormValidator<in P> {

    fun validate(params: P): FormValidationResult

}

abstract class FormValidationResult
