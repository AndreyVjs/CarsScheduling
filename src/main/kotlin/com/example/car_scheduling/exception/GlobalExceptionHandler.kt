package com.example.car_scheduling.exception
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import com.example.car_scheduling.controller.dto.response.ErrorResponse

@ControllerAdvice
class GlobalExceptionHandler{

    //Esse :: class significa selecione isso de todas as classe
    //Ou seja se der erro em alguma classe e não tiver tratativa vai cair aqui!

    //Oque eu estou recebendo
    //Esse ex: exception == o erro que rolou
    //O request significa de onde o erro veio/da url celular ext

    //Oque eu estou retornando
    // ResponseEntity<ErrorResponse> esse entity é como se fosse um evelope padrão pra se retornar
    // Http pra internet ha coisas nele que são obrigatorias (Como o HTTp) ele não pode deixar fazer a festa por isso obrigada retornar o ResponseEntity
    // Ele é composto por basicamente duas coias o Body + o HTTp ou seja no caso o seu ErrorResponse + O Http

    @ExceptionHandler(NotFoundException::class)
    fun handlerException(ex: NotFoundException, request: WebRequest
    ): ResponseEntity<ErrorResponse> {
        val erro = ErrorResponse(

            404,
            ex.message,
            ex.errorCode,
            null
        )

        return ResponseEntity(erro, HttpStatus.NOT_FOUND)
    }
}